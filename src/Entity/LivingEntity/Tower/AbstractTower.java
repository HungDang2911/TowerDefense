package Entity.LivingEntity.Tower;

import Entity.LivingEntity.AbstractLivingEntity;
import Entity.LivingEntity.Bullet.AbstractBullet;
import Entity.LivingEntity.Enemy.AbstractEnemy;
import javafx.scene.image.Image;

import java.util.List;

public abstract class AbstractTower extends AbstractLivingEntity{
    protected int level;
    protected int attackSpeed;
    protected double range;
    protected int damage;
    protected int ticks;

    protected AbstractTower(double posX, double posY, Image texture, int attackSpeed, double range, int damage) {
        super(posX, posY, texture);
        this.level = 1;
        this.attackSpeed = attackSpeed;
        this.range = range;
        this.damage = damage;
        this.ticks = 0;
    }

    public int getLevel() {
        return level;
    }

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public double getRange() {
        return range;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getTicks() {
        return ticks;
    }

    public abstract int getPrice();

    public abstract int getNextLevelPrice();

    public abstract double getNextLevelRange();

    public void setLevel(int level) {
        this.level = level;
    }

    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public void setRange(double range) {
        this.range = range;
    }

    public void setTicks(int ticks) {
        this.ticks = ticks;
    }

    protected void changeAngle(double x, double y) {
        double angle = Math.toDegrees(Math.atan((x - posX) / (y - posY)));
        if (x > posX && y > posY) textureAngle = 180 - angle; //R
        if (x > posX && y < posY) textureAngle = -angle;
        if (x < posX && y > posY) textureAngle = 180 - angle; //R
        if (x < posX && y < posY) textureAngle = -angle;
    }

    public abstract void upgrade();

    public void update(List<AbstractEnemy> enemies, List<AbstractBullet> bullets) {
        if (ticks++ < attackSpeed) return;


        //Choose target then shoot it
        if (enemies.isEmpty()) return;

        double minDistance = 9999999D;
        AbstractEnemy closetEnemy = null;
        for (AbstractEnemy enemy:enemies) {
            if(getDistance(enemy) <= range && getDistance(enemy) < minDistance) {
                closetEnemy = enemy;
                minDistance = getDistance(enemy);
            }
        }

        if (closetEnemy != null) {
            changeAngle(closetEnemy.getPosX(), closetEnemy.getPosY());
            bullets.add(getBullet(posX, posY, closetEnemy.getPosX(), closetEnemy.getPosY()));
            playShotSound();
        }
        ticks = 0;
    }

    protected abstract void playShotSound();

    protected abstract AbstractBullet getBullet(double posX, double posY, double x, double y);

}
