package Entity.LivingEntity.Bullet;

import Main.Assets;
import Main.Config;

public class FreezeBullet extends AbstractBullet{
    public FreezeBullet(double posX, double posY, int damage, double x, double y) {
        super(posX, posY, Assets.freezeBullet, damage, Config.FREEZE_BULLET_SPEED, x, y);
    }
}
