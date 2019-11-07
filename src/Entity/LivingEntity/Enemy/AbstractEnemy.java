package Entity.LivingEntity.Enemy;

import Entity.LivingEntity.AbstractLivingEntity;
import Entity.LivingEntity.Bullet.AbstractBullet;
import Entity.LivingEntity.LivingEntity;
import javafx.scene.canvas.GraphicsContext;

public abstract class AbstractEnemy extends AbstractLivingEntity implements LivingEntity {
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
    public void render(GraphicsContext graphicsContext) {

    }


}
