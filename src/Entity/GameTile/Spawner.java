package Entity.GameTile;

import Entity.LivingEntity.Enemy.AbstractEnemy;
import Main.Config;
import States.GameState.GameField;

import java.io.IOException;
import java.util.List;
import java.util.Queue;

public class Spawner extends AbstractTile {
    private int ticks = 0;
    List<List<AbstractEnemy>> allEnemies;
    List<AbstractEnemy> incomingWaveEnemies;

    public Spawner(double posX, double posY, int directionForEnemy, List<List<AbstractEnemy>> allEnemies) {
        super(posX, posY);
        this.directionForEnemy = directionForEnemy;
        this.allEnemies = allEnemies;
    }

    public int getTicks() {
        return ticks;
    }

    public void setTicks(int ticks) {
        this.ticks = ticks;
    }

    public List<List<AbstractEnemy>> getAllEnemies() {
        return allEnemies;
    }

    public void setAllEnemies(List<List<AbstractEnemy>> allEnemies) {
        this.allEnemies = allEnemies;
    }

    public List<AbstractEnemy> getIncomingWaveEnemies() {
        return incomingWaveEnemies;
    }

    public void setIncomingWaveEnemies(List<AbstractEnemy> incomingWaveEnemies) {
        this.incomingWaveEnemies = incomingWaveEnemies;
    }

    public void update(GameField field) throws IOException {
        if (field.isChangingWave()) {
            if (incomingWaveEnemies == null || incomingWaveEnemies.isEmpty()) {
                incomingWaveEnemies = allEnemies.remove(0);
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
                    field.getNextWaveBtn().setVisible(true);
                }
                return;
            }
            if(ticks++ < Config.SPAWN_INTERVAL) return;
            field.getEnemies().add(incomingWaveEnemies.remove(0));
            ticks = 0;
        }
    }
}