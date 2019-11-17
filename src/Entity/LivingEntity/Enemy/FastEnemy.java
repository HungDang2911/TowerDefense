package Entity.LivingEntity.Enemy;

import game.Assets;
import game.Config;
import javafx.scene.image.Image;

public class FastEnemy extends AbstractEnemy{
    public FastEnemy(double posX, double posY) {
        super(posX, posY, Assets.fastEnemy, Config.FAST_ENEMY_HITPOINTS, Config.FAST_ENEMY_SPEED, Config.FAST_ENEMY_ARMOR, Config.FAST_ENEMY_REWARD);
    }
}
