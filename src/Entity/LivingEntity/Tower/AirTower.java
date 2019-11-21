package Entity.LivingEntity.Tower;

import Entity.LivingEntity.Bullet.AbstractBullet;
import javafx.scene.image.Image;

public class AirTower extends AbstractTower{
    protected AirTower(double posX, double posY, Image texture, int attackSpeed, double range, int damage) {
        super(posX, posY, texture, attackSpeed, range, damage);
    }

    @Override
    protected AbstractBullet getBullet(double posX, double posY, double x, double y) {
        return null;
    }
}
