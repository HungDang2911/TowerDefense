package Entity.LivingEntity.Bullet;

import Entity.LivingEntity.AbstractLivingEntity;
import Entity.LivingEntity.Enemy.AbstractEnemy;
import Main.Config;
import javafx.scene.image.Image;

import java.util.List;

public abstract class AbstractBullet extends AbstractLivingEntity{
    protected int damage;
    protected double speed;
    protected double deltaX;
    protected double deltaY;
    protected AbstractEnemy target;


    protected AbstractBullet(double posX, double posY, Image texture, int damage, double speed, double x, double y) {
        super(posX, posY, texture);
        this.damage = damage;
        this.speed = speed;
        {
            double distance = Math.sqrt((posX - x) * (posX - x) + (posY - y) * (posY - y));
            deltaX = (x - posX) * speed / distance;
            deltaY = (y - posY) * speed / distance;
        }
    }

    protected void changeAngle() {
        double angle = Math.toDegrees(Math.atan((deltaX) / (deltaY)));
        if (deltaX > 0 && deltaY > 0) textureAngle = 180 - angle; //R
        if (deltaX > 0 && deltaY < 0) textureAngle = -angle;
        if (deltaX < 0 && deltaY > 0) textureAngle = 180 - angle; //R
        if (deltaX < 0 && deltaY < 0) textureAngle = -angle;
    }

    public int getDamage() {
        return damage;
    }

    public void update(List<AbstractEnemy> enemies) {
        if (isHit(enemies)) {
            target.onHit(this.damage);
            this.destroyed = true;
        }
        else {
            changeAngle();
            this.posX += deltaX;
            this.posY += deltaY;
            if (this.posX > Config.GAME_FIELD_HORIZONTAL_LENGTH || this.posX < 0 || this.posY > Config.GAME_FIELD_VERTICAL_LENGTH || this.posY < 0) this.destroyed = true;
        }

    }

    private boolean isHit(List<AbstractEnemy> enemies) {
        double minDistance = 999999D;
        for (AbstractEnemy enemy:enemies) {
            if (getDistance(enemy) >= (double)Config.TILE_SIZE * 32/64 || getDistance(enemy) > minDistance) continue;
            minDistance = getDistance(enemy);
            this.target = enemy;
            return true;
        }
        return false;
    }

}