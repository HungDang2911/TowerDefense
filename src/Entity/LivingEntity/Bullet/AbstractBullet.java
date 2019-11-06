package Entity.LivingEntity.Bullet;

import Entity.AbstractEntity;
import Entity.LivingEntity.Enemy.AbstractEnemy;
import Entity.LivingEntity.LivingEntity;

public class AbstractBullet<E extends AbstractEnemy> extends AbstractEntity implements LivingEntity {
    private int damage;
    private double speed;
    private E target;
    protected AbstractBullet(double posX, double posY, double width, double height, E target) {
        super(posX, posY, width, height);
        this.target = target;
    }

    public int getDamage() {
        return damage;
    }

    private double getDistance(){
        return Math.sqrt(Math.pow(this.getPosX() - target.getPosX(), 2) + Math.pow(this.getPosX() - target.getPosX(), 2));
    }
    @Override
    public void update() {
        this.setPosX(this.getPosX() + (target.getPosX() - this.getPosX()) * speed / getDistance());
        this.setPosY(this.getPosY() + (target.getPosY() - this.getPosY()) * speed / getDistance());
    }

    @Override
    public void render() {

    }
    public boolean Hit(){
        if(getDistance() < 0.5)
            return true;
        else return false;
    }
}