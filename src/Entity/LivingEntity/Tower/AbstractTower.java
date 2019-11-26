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
    protected AbstractEnemy target;
    protected int ticks;

    protected AbstractTower(double posX, double posY, Image texture, int attackSpeed, double range, int damage) {
        super(posX, posY, 1, 1, texture);
        this.level = 1;
        this.attackSpeed = attackSpeed;
        this.range = range;
        this.damage = damage;
        this.ticks = 0;
    }

    public abstract void upgrade();

    public void update(List<AbstractEnemy> enemies, List<AbstractBullet> bullets) {
        if (ticks++ < attackSpeed) return;

        //Choose target then shoot it
        if (enemies.isEmpty()) return;
        if (this.target != null && getDistance(target) <= range) {
            bullets.add(getBullet(posX, posY, target.getPosX(), target.getPosY()));
        }
        else {
            double minDistance = 9999999D;
            AbstractEnemy closetEnemy = null;
            for (AbstractEnemy enemy:enemies) {
                if(getDistance(enemy) <= range && getDistance(enemy) < minDistance) {
                    closetEnemy = enemy;
                    minDistance = getDistance(enemy);
                }
            }
            if (closetEnemy != null) {
                this.target = closetEnemy;
                bullets.add(getBullet(posX, posY, target.getPosX(), target.getPosY()));
            }
        }
        ticks = 0;
    }

    protected abstract AbstractBullet getBullet(double posX, double posY, double x, double y);

}
