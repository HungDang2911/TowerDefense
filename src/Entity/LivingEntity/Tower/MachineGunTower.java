package Entity.LivingEntity.Tower;

import Entity.LivingEntity.Enemy.AbstractEnemy;
import game.Config;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class MachineGunTower extends AbstractTower{
    protected MachineGunTower(double posX, double posY, double width, double height, Image texture, double attackSpeed, double range, int damage) {
        super(posX, posY, width, height, texture, Config.MACHINE_GUN_ATTACK_SPEED, Config.MACHINE_GUN_RANGE, Config.MACHINE_GUN_DAMAGE);
    }

    @Override
    public void shoot(AbstractEnemy target) {

    }
}
