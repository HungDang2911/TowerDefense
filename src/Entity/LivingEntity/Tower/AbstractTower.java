package Entity.LivingEntity.Tower;

import Entity.LivingEntity.AbstractLivingEntity;
import Entity.LivingEntity.Bullet.AbstractBullet;
import Entity.LivingEntity.Enemy.AbstractEnemy;
import javafx.scene.image.Image;

import java.util.List;

public abstract class AbstractTower extends AbstractLivingEntity{
    private double attackSpeed;
    private double range;
    private int damage;
    private AbstractEnemy target;
    private AbstractBullet bullet;

    protected AbstractTower(double posX, double posY, double width, double height, Image texture, double attackSpeed, double range, int damage) {
        super(posX, posY, width, height, texture);
        this.attackSpeed = attackSpeed;
        this.range = range;
        this.damage = damage;
    }

    public void update(List<AbstractEnemy> enemies) {
        //Choose target then shoot it
        if (enemies.isEmpty()) return;
        if (this.target != null) shoot(target);
        else {
            double minDistance = 99999;
            AbstractEnemy closetEnemy = null;
            for (AbstractEnemy enemy:enemies) {
                if(getDistance(enemy) <= range && getDistance(enemy) < minDistance) {
                    closetEnemy = enemy;
                    minDistance = getDistance(enemy);
                }
            }
            this.target = closetEnemy;
            shoot(target);
        }
    }

    public abstract void shoot(AbstractEnemy target);
}
