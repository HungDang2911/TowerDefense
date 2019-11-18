package Entity.LivingEntity.Bullet;

import Main.Assets;
import Main.Config;

public class MachineGunBullet extends AbstractBullet{
    public MachineGunBullet(double posX, double posY, int damage, double x, double y) {
        super(posX, posY, Assets.machineGunBullet, damage, Config.MACHINE_GUN_BULLET_SPEED, x, y);
    }
}
