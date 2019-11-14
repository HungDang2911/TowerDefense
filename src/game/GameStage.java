package game;

import Entity.GameTile.GameTile;
import Entity.GameTile.Mountain;
import Entity.GameTile.Road;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameStage {
    private List<GameTile> tiles = new ArrayList<>();
    private List<Road> corners = new ArrayList<>();

    public GameStage(String path) throws FileNotFoundException {
            load(path);
    }

    public List<GameTile> getTiles() {
        return tiles;
    }

    public List<Road> getCorners() {
        return corners;
    }

    private void load(String path) throws FileNotFoundException {
        File map = new File(path);

        try (Scanner scanner = new Scanner(map)) {
            int horizontalLength = scanner.nextInt();
            int verticalLength = scanner.nextInt();


            for (int y = 0; y < verticalLength; y++) {
                for (int x = 0; x < horizontalLength; x++) {
                    int value = scanner.nextInt();
                    if (value == 0) tiles.add(new Road(x * Config.TILE_SIZE, y * Config.TILE_SIZE));
                    if (value == 1) tiles.add(new Mountain(x * Config.TILE_SIZE, y * Config.TILE_SIZE));
                    if (value == 2) {
                        Road road = new Road(x * Config.TILE_SIZE, y * Config.TILE_SIZE);
                        tiles.add(road);
                        corners.add(road);
                    }
                }
            }
        }

    }
}
