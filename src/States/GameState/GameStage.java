package States.GameState;

import Entity.GameTile.*;
import Entity.LivingEntity.Enemy.*;
import Main.Config;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class GameStage {
    private AbstractTile[][] tiles;

    public GameStage(String path) throws FileNotFoundException {
            load(path);
    }

    public AbstractTile[][] getTiles() {
        return tiles;
    }

    private void load(String path) throws FileNotFoundException {
        File map = new File(path);

        try (Scanner scanner = new Scanner(map)) {
            //MAP LOAD
            int horizontalLength = scanner.nextInt();
            int verticalLength = scanner.nextInt();

            this.tiles = new AbstractTile[verticalLength][horizontalLength];

            for (int y = 0; y < verticalLength; y++) {
                for (int x = 0; x < horizontalLength; x++) {
                    int value = scanner.nextInt();
                    if (value == 0) tiles[y][x] = new Mountain(x * Config.TILE_SIZE, y * Config.TILE_SIZE);
                    if (value == 1 || value == 2 || value == 3 || value == 4) tiles[y][x] = new Road(x * Config.TILE_SIZE, y * Config.TILE_SIZE, value);
                    if (value == 5) tiles[y][x] = new Target(x * Config.TILE_SIZE, y * Config.TILE_SIZE);
                    if (value == 9) tiles[y][x] = new Grass(x * Config.TILE_SIZE, y * Config.TILE_SIZE);
                }
            }

            //SPAWNER LOAD
            int spawnerCol = scanner.nextInt();
            int spawnerRow = scanner.nextInt();

            List<List<AbstractEnemy>> allEnemies = new LinkedList<>();

            for (int i = 0; i < Config.NUM_OF_WAVES; i++) {
                int numOfRoundEnemies = scanner.nextInt();
                List<AbstractEnemy> roundEnemies = new LinkedList<>();
                for (int j = 0; j < numOfRoundEnemies; j++) {
                    int value = scanner.nextInt();
                    if (value == 1) roundEnemies.add(new NormalEnemy(spawnerCol  * Config.TILE_SIZE, spawnerRow * Config.TILE_SIZE));
                    if (value == 2) roundEnemies.add(new FastEnemy(spawnerCol  * Config.TILE_SIZE, spawnerRow * Config.TILE_SIZE));
                    if (value == 3) roundEnemies.add(new TankerEnemy(spawnerCol  * Config.TILE_SIZE, spawnerRow * Config.TILE_SIZE));
                    if (value == 4) roundEnemies.add(new BossEnemy(spawnerCol  * Config.TILE_SIZE, spawnerRow * Config.TILE_SIZE));
                }
                allEnemies.add(roundEnemies);
            }
            tiles[spawnerRow][spawnerCol] = new Spawner(spawnerCol * Config.TILE_SIZE, spawnerRow * Config.TILE_SIZE, tiles[spawnerRow][spawnerCol].getDirectionForEnemy(), allEnemies);
        }
    }
}
