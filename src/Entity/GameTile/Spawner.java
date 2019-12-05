package Entity.GameTile;

import Entity.LivingEntity.Enemy.AbstractEnemy;
import Main.Assets;
import Main.Config;
import States.GameState.GameField;

import java.util.Queue;

public class Spawner extends AbstractTile {
    private int ticks = 0;
    Queue<Queue<AbstractEnemy>> allEnemies;
    Queue<AbstractEnemy> incomingWaveEnemies;

    public Spawner(double posX, double posY, int directionForEnemy, Queue<Queue<AbstractEnemy>> allEnemies) {
        super(posX, posY, Assets.spawner);
        this.directionForEnemy = directionForEnemy;
        this.allEnemies = allEnemies;
        incomingWaveEnemies = this.allEnemies.peek();
    }

    public void update(GameField field) {
        if (field.isChangingWave()) {
            incomingWaveEnemies = allEnemies.peek();
        }
        else {

        }
    }
}