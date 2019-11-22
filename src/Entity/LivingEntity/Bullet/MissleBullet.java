package Entity.LivingEntity.Bullet;

import Main.Assets;
import Main.Config;

public class MissleBullet extends AbstractBullet{
    public MissleBullet(double posX, double posY, int damage, double x, double y) {
        super(posX, posY, Assets.missleBullet, damage, Config.MISSLE_BULLET_SPEED, x, y);
    }
}
