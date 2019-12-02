package Entity.GameTile;

import Entity.LivingEntity.Enemy.AbstractEnemy;
import States.GameState.GameField;
import javafx.scene.image.Image;

import java.util.LinkedList;
import java.util.Queue;

public class Spawner extends AbstractTile {
    private final int spawnInterval = 60;
    private int ticks = 0;
    Queue<AbstractEnemy> enemies = new LinkedList<>();

    protected Spawner(double posX, double posY, Image texture) {
        super(posX, posY, texture);
    }

    public void update(GameField field) {
        if (ticks++ < spawnInterval) return;
        else {
            field.getEnemies().add(enemies.poll());
            ticks = 0;
        }
    }
}