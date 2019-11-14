package Entity.LivingEntity.Bullet;

import game.Assets;
import game.Config;
import javafx.scene.image.Image;

public class MachineGunBullet extends AbstractBullet{
    public MachineGunBullet(double posX, double posY, double deltaX, double deltaY) {
        super(posX, posY, Assets.machineGunBullet, Config.MACHINE_GUN_BULLET_DAMAGE, Config.MACHINE_GUN_BULLET_SPEED, deltaX, deltaY);
    }
}
