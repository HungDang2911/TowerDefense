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


    protected AbstractBullet(double posX, double posY, double width, double height, Image texture, int damage, double speed) {
        super(posX, posY, width, height, texture);
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
//            if (this.posX > Config.GAME_WIDTH || this.posX < 0 || this.posY > Config.GAME_HEIGHT || this.posY < 0) this.destroyed = true;
        }
    }

    public boolean isHit(List<AbstractEnemy> enemies) {
        double minDistance = 999;
        for (AbstractEnemy enemy:enemies) {
            if (getDistance(enemy) >= 1 || getDistance(enemy) > minDistance) continue;
            minDistance = getDistance(enemy);
            this.target = enemy;
            return true;
        }
        return false;
    }



    @Override
    public void render(GraphicsContext graphicsContext) {
    }

}