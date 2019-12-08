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
    }

    public void update(GameField field) {
        if (field.isChangingWave()) {
            if (incomingWaveEnemies == null || incomingWaveEnemies.isEmpty()) {
                incomingWaveEnemies = allEnemies.poll();
            }
        }
        else {
            if (incomingWaveEnemies.isEmpty()) {
                if (field.getEnemies().isEmpty()) {
                    if (allEnemies.isEmpty()) {
                        field.win();
                        return;
                    }
                    field.setChangingWave(true);
                    field.setNextWaveBtnVisible();
                }
                return;
            }
            if(ticks++ < Config.SPAWN_INTERVAL) return;
            field.getEnemies().add(incomingWaveEnemies.poll());
            ticks = 0;
        }
    }
}