package game;

import Entity.GameTile.GameTile;
import Entity.GameTile.Mountain;
import Entity.GameTile.Road;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameStage {
    private int width, height;
    private List<GameTile> tiles;

    public GameStage(int width, int height, List<GameTile>tiles) {
        this.width = width;
        this.height = height;
        this.tiles = List.copyOf(tiles);
    }

    public GameStage(String path) {
        load(path);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public List<GameTile> getTiles() {
        return tiles;
    }

    private void load(String path) {
        InputStream stream = GameStage.class.getResourceAsStream(path);
        Scanner scanner = new Scanner(stream);
        int width = scanner.nextInt();
        int height = scanner.nextInt();
        List<GameTile> tiles = new ArrayList<>();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int value = scanner.nextInt();
                if (value == 0) tiles.add(new Road(x, y));
                if (value == 1) tiles.add(new Mountain( x, y));
            }
        }
    }


}
