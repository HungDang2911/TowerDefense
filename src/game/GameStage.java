package game;

import Entity.GameTile.GameTile;
import Entity.GameTile.Mountain;
import Entity.GameTile.Road;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameStage {
    private List<GameTile> tiles = new ArrayList<>();

    public GameStage(String path) throws FileNotFoundException {
            load(path);
    }

    public List<GameTile> getTiles() {
        return tiles;
    }

    private void load(String path) throws FileNotFoundException {
        File file = new File(path);
        try {
            System.out.println(file.getName());
            Scanner scanner = new Scanner(file);
            int width = scanner.nextInt();
            int height = scanner.nextInt();

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int value = scanner.nextInt();
                    if (value == 0) tiles.add(new Road(x * Config.TILE_SIZE, y * Config.TILE_SIZE));
                    if (value == 1) tiles.add(new Mountain(x * Config.TILE_SIZE, y * Config.TILE_SIZE));
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println(e);
        }


//        InputStream stream = GameStage.class.getResourceAsStream(path);
//        Scanner scanner = new Scanner(stream);
//        int width = scanner.nextInt();
//        int height = scanner.nextInt();
//
//        for (int y = 0; y < height; y++) {
//            for (int x = 0; x < width; x++) {
//                int value = scanner.nextInt();
//                if (value == 0) tiles.add(new Road(x * Config.TILE_SIZE, y * Config.TILE_SIZE));
//                if (value == 1) tiles.add(new Mountain(x * Config.TILE_SIZE, y * Config.TILE_SIZE));
//            }
//        }
    }


}
