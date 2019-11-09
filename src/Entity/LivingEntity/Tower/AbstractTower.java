package Entity.LivingEntity.Tower;

import Entity.LivingEntity.AbstractLivingEntity;
import Entity.LivingEntity.Bullet.AbstractBullet;
import Entity.LivingEntity.Enemy.AbstractEnemy;

import java.util.List;

public abstract class AbstractTower extends AbstractLivingEntity{
    private double attackSpeed;
    private double range;
    private int damage;
    private AbstractEnemy target;
    private boolean isTargetingEnemy;

    protected AbstractTower(double posX, double posY, double width, double height, double attackSpeed, double range, int damage) {
        super(posX, posY, width, height);
        this.attackSpeed = attackSpeed;
        this.range = range;
        this.damage = damage;
        this.isTargetingEnemy = false;
    }

    private double getDistance(AbstractEnemy enemy) {
        return Math.sqrt(Math.pow(this.getPosX() - enemy.getPosX(), 2) + Math.pow(this.getPosX() - enemy.getPosX(), 2));
    }

    public void update(List<AbstractEnemy> enemies) {
        if (target == null) isTargetingEnemy = false;

        if (this.isTargetingEnemy) 
        else {
            double minDistance = 99999;
            for (AbstractEnemy enemy:enemies) {
                if(getDistance(enemy) < range) {}
            }
        }
    }

    public abstract void shoot(AbstractBullet bullet, AbstractEnemy target);
}
