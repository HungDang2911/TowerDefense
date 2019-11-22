package Entity.LivingEntity.Bullet;

import Main.Assets;
import Main.Config;

public class AirBullet extends AbstractBullet{
    public AirBullet(double posX, double posY, int damage, double x, double y) {
        super(posX, posY, Assets.missleBullet, damage, Config.AIR_BULLET_SPEED, x, y);
    }
}