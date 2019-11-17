package Entity.LivingEntity.Enemy;

import game.Assets;
import game.Config;

public class BossEnemy extends AbstractEnemy {
    public BossEnemy(double posX, double posY) {
        super(posX, posY, Assets.bossEnemy, Config.BOSS_ENEMY_HITPOINTS, Config.BOSS_ENEMY_SPEED, Config.BOSS_ENEMY_ARMOR, Config.BOSS_ENEMY_REWARD);
    }
}
