package States.GameState;

import Entity.GameTile.AbstractTile;
import Entity.GameTile.Mountain;
import Entity.GameTile.Road;
import Entity.GameTile.Target;
import Main.Config;

import java.io.File;
import java.io.FileNotFoundException;
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
            int horizontalLength = scanner.nextInt();
            int verticalLength = scanner.nextInt();

            this.tiles = new AbstractTile[verticalLength][horizontalLength];

            for (int y = 0; y < verticalLength; y++) {
                for (int x = 0; x < horizontalLength; x++) {
                    int value = scanner.nextInt();
                    if (value == 0) tiles[y][x] = new Mountain(x * Config.TILE_SIZE, y * Config.TILE_SIZE);
                    if (value == 1 || value == 2 || value == 3 || value == 4) tiles[y][x] = new Road(x * Config.TILE_SIZE, y * Config.TILE_SIZE, value);
                    if (value == 5) tiles[y][x] = new Target(x * Config.TILE_SIZE, y * Config.TILE_SIZE, value);
                }
            }
        }

    }
}
