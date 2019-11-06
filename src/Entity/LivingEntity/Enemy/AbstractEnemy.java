package Entity.LivingEntity.Enemy;

import Entity.AbstractEntity;
import Entity.LivingEntity.Bullet.AbstractBullet;
import Entity.LivingEntity.LivingEntity;

public abstract class AbstractEnemy extends AbstractEntity implements LivingEntity {
    private int hitpoint;
    private double speed;
    private int armor;
    private int reward;

    public AbstractEnemy(double posX, double posY, double width, double height, int hitpoint, double speed, int armor, int reward) {
        super(posX, posY, width, height);
        this.hitpoint = hitpoint;
        this.armor = armor;
        this.reward = reward;
        this.speed = speed;
    }

    public void onHit(AbstractBullet bullet){
        this.hitpoint -= (bullet.getDamage() - this.armor);
    }

    @Override
    public void update() {
        //Move the enemy

    }

    @Override
    public void render() {

    }


}
