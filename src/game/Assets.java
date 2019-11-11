package game;

import javafx.scene.image.Image;

public class Assets {
    public static Image mountain, road, target;
    public static Image machineGunTower;
    public static Image enemy;
    public static void init() {
        mountain = new Image("file:resource/textures/Tiles/Mountain.png", Config.TILE_SIZE, Config.TILE_SIZE, true, true);
        road = new Image("file:resource/textures/Tiles/Road.png", Config.TILE_SIZE, Config.TILE_SIZE, true, true);
        machineGunTower = new Image("file:resource/textures/Tiles/Road.png", Config.TILE_SIZE, Config.TILE_SIZE, true, true);
        enemy = new Image("file:resource/textures/Enemy/Enemy.png", Config.TILE_SIZE, Config.TILE_SIZE, true, true);
    }
}
