package Entity.LivingEntity.Enemy;

import game.Assets;
import game.Config;
import javafx.scene.image.Image;

public class NormalEnemy extends AbstractEnemy{
    public NormalEnemy(double posX, double posY) {
        super(posX, posY, Assets.normalEnemy, Config.NORMAL_ENEMY_HITPOINT, Config.NORMAL_ENEMY_SPEED, Config.NORMAL_ENEMY_ARMOR, Config.NORMAL_ENEMY_REWARD);
    }
}
