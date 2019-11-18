package Entity.LivingEntity.Enemy;

import Main.Assets;
import Main.Config;

public class NormalEnemy extends AbstractEnemy{
    public NormalEnemy(double posX, double posY) {
        super(posX, posY, Assets.normalEnemy, Config.NORMAL_ENEMY_HITPOINTS, Config.NORMAL_ENEMY_SPEED, Config.NORMAL_ENEMY_ARMOR, Config.NORMAL_ENEMY_REWARD);
    }
}
