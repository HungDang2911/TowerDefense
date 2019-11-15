package Entity.LivingEntity.Bullet;

import Entity.LivingEntity.AbstractLivingEntity;
import Entity.LivingEntity.Enemy.AbstractEnemy;
import game.Config;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.List;

public abstract class AbstractBullet extends AbstractLivingEntity{
    private int damage;
    private double speed;
    private double deltaX;
    private double deltaY;
    private AbstractEnemy target;


    protected AbstractBullet(double posX, double posY, Image texture, int damage, double speed, double deltaX, double deltaY) {
        super(posX, posY, 1, 1, texture);
        this.damage = damage;
        this.speed = speed;
        this.deltaX = deltaX;
        this.deltaY = deltaY;
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
            this.posX += deltaX;
            this.posY += deltaY;
            if (this.posX > Config.GAME_HORIZONTAL_LENGTH || this.posX < 0 || this.posY > Config.GAME_VERTICAL_LENGTH || this.posY < 0) this.destroyed = true;
        }

    }

    public boolean isHit(List<AbstractEnemy> enemies) {
        double minDistance = 999;
        for (AbstractEnemy enemy:enemies) {
            if (getDistance(enemy) >= Config.TILE_SIZE * (double)(7/64) || getDistance(enemy) > minDistance) {
                continue;
            }
            minDistance = getDistance(enemy);
            this.target = enemy;
            return true;
        }
        return false;
    }

}