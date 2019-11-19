package Main;

import javafx.scene.image.Image;

public class Assets {
    public static Image menuBackground;
    public static Image mountain, road, target;
    public static Image machineGunTower;
    public static Image normalEnemy, fastEnemy, tankerEnemy, bossEnemy;
    public static Image machineGunBullet;
    public static void init() {
        //Backgrounds
        menuBackground = new Image("file:resource/Background/MainMenuBackground.png", Config.GAME_HORIZONTAL_LENGTH, Config.GAME_VERTICAL_LENGTH, true, true);

        //Tiles
        mountain = new Image("file:resource/textures/Tiles/Mountain.png", Config.TILE_SIZE, Config.TILE_SIZE, true, true);
        road = new Image("file:resource/textures/Tiles/Road.png", Config.TILE_SIZE, Config.TILE_SIZE, true, true);

        //Towers
        machineGunTower = new Image("file:resource/textures/Tower/MachineGunTower.png", Config.TILE_SIZE, Config.TILE_SIZE, true, true);

        //Bullets
        machineGunBullet = new Image("file:resource/textures/Bullet/MachineGunBullet.png", Config.TILE_SIZE, Config.TILE_SIZE, true, true);


        //Enemies
        normalEnemy = new Image("file:resource/textures/Enemy/NormalEnemy.png", Config.TILE_SIZE, Config.TILE_SIZE, true, true);
        fastEnemy = new Image("file:resource/textures/Enemy/FastEnemy.png", Config.TILE_SIZE, Config.TILE_SIZE, true, true);
        tankerEnemy = new Image("file:resource/textures/Enemy/TankerEnemy.png", Config.TILE_SIZE, Config.TILE_SIZE, true, true);
        bossEnemy = new Image("file:resource/textures/Enemy/BossEnemy.png", Config.TILE_SIZE, Config.TILE_SIZE, true, true);
    }
}
