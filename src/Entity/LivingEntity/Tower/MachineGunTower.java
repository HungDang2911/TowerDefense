package Entity.LivingEntity.Tower;

import Entity.LivingEntity.Enemy.AbstractEnemy;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class MachineGunTower extends AbstractTower{
    protected MachineGunTower(double posX, double posY, double width, double height, Image texture, double attackSpeed, double range, int damage) {
        super(posX, posY, width, height, texture, attackSpeed, range, damage);
    }

    @Override
    public void shoot(AbstractEnemy target) {

    }
}
