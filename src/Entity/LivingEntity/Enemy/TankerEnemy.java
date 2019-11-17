package Entity.LivingEntity.Enemy;

import game.Assets;
import game.Config;

public class TankerEnemy extends AbstractEnemy {
    public TankerEnemy(double posX, double posY) {
        super(posX, posY, Assets.tankerEnemy, Config.TANKER_ENEMY_HITPOINTS, Config.TANKER_ENEMY_SPEED, Config.TANKER_ENEMY_ARMOR, Config.TANKER_ENEMY_REWARD);
    }
}
