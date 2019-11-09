package Entity.LivingEntity.Bullet;

import Entity.LivingEntity.AbstractLivingEntity;
import Entity.LivingEntity.Enemy.AbstractEnemy;
import Entity.LivingEntity.LivingEntity;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public abstract class AbstractBullet extends AbstractLivingEntity{
    private int damage;
    private double speed;
    private AbstractEnemy target;
    protected AbstractBullet(double posX, double posY, double width, double height, AbstractEnemy target) {
        super(posX, posY, width, height);
        this.target = target;
    }

    public int getDamage() {
        return damage;
    }

    private double getDistance(){
        return Math.sqrt(Math.pow(this.getPosX() - target.getPosX(), 2) + Math.pow(this.getPosX() - target.getPosX(), 2));
    }
    public void update(List<AbstractEnemy> enemies) {
        this.setPosX(this.getPosX() + (target.getPosX() - this.getPosX()) * speed / getDistance());
        this.setPosY(this.getPosY() + (target.getPosY() - this.getPosY()) * speed / getDistance());
    }

    @Override
    public void render(GraphicsContext graphicsContext) {

    }
    public boolean Hit(){
        if(getDistance() < 0.5)
            return true;
        else return false;
    }
}