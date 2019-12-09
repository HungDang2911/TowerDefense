package Main;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

public class Assets {
    public static Image mainMenuBackground, map1;
    public static Image livesIcon, moneyIcon, waveIcon;
    public static Image mountain, road, target, spawner;
    public static Image machineGunTower, machineGunTowerLv3, airTower, freezeTower, missleTower, missleTowerLv3;
    public static Image normalEnemy, fastEnemy, tankerEnemy, bossEnemy;
    public static Image machineGunBullet, freezeBullet, airBullet, missleBullet;
    public static AudioClip click, music, machineGunShot, airShot, freezeShot, missleShot;
    public static void init() {
        //Backgrounds
        mainMenuBackground = new Image("file:resource/Background/MainMenuBackground.png", Config.MAIN_MENU_HORIZONTAL_LENGTH, Config.MAIN_MENU_VERTICAL_LENGTH, true, true);
        map1 = new Image("file:resource/Map/demo.png", Config.GAME_FIELD_HORIZONTAL_LENGTH, Config.GAME_FIELD_VERTICAL_LENGTH, true, true);

        //Icons
        livesIcon = new Image("file:resource/Icon/livesIcon.png", 96, 96, true, true);
        moneyIcon = new Image("file:resource/Icon/moneyIcon.png", 96, 96,true, true);
        waveIcon = new Image("file:resource/Icon/waveIcon.png", 96, 96, true, true);

        //Tiles
        mountain = new Image("file:resource/textures/Tiles/Mountain.png", Config.TILE_SIZE, Config.TILE_SIZE, true, true);
        road = new Image("file:resource/textures/Tiles/Road.png", Config.TILE_SIZE, Config.TILE_SIZE, true, true);
        target = new Image("file:resource/textures/Tiles/Target.png", Config.TILE_SIZE, Config.TILE_SIZE, true, true);
        spawner = new Image("file:resource/textures/Tiles/Spawner.png", Config.TILE_SIZE, Config.TILE_SIZE, true, true);

        //Towers
        machineGunTower = new Image("file:resource/textures/Tower/MachineGunTower.png", Config.TILE_SIZE, Config.TILE_SIZE, true, true);
        machineGunTowerLv3 = new Image("file:resource/textures/Tower/MachineGunTowerLv3.png", Config.TILE_SIZE, Config.TILE_SIZE, true, true);
        freezeTower = new Image("file:resource/textures/Tower/FreezeTower.png", Config.TILE_SIZE, Config.TILE_SIZE, true, true);
        missleTower = new Image("file:resource/textures/Tower/MissleTower.png", Config.TILE_SIZE, Config.TILE_SIZE, true, true);
        missleTowerLv3 = new Image("file:resource/textures/Tower/MissleTowerLv3.png", Config.TILE_SIZE, Config.TILE_SIZE, true, true);
        airTower = new Image("file:resource/textures/Tower/AirTower.png", Config.TILE_SIZE, Config.TILE_SIZE, true, true);

        //Bullets
        machineGunBullet = new Image("file:resource/textures/Bullet/MachineGunBullet.png", Config.TILE_SIZE, Config.TILE_SIZE, true, true);
        freezeBullet = new Image("file:resource/textures/Bullet/FreezeBullet.png", Config.TILE_SIZE, Config.TILE_SIZE, true, true);
        airBullet = new Image("file:resource/textures/Bullet/AirBullet.png", Config.TILE_SIZE, Config.TILE_SIZE, true, true);
        missleBullet = new Image("file:resource/textures/Bullet/MissleBullet.png", Config.TILE_SIZE, Config.TILE_SIZE, true, true);

        //Enemies
        normalEnemy = new Image("file:resource/textures/Enemy/NormalEnemy.png", Config.TILE_SIZE, Config.TILE_SIZE, true, true);
        fastEnemy = new Image("file:resource/textures/Enemy/FastEnemy.png", Config.TILE_SIZE, Config.TILE_SIZE, true, true);
        tankerEnemy = new Image("file:resource/textures/Enemy/TankerEnemy.png", Config.TILE_SIZE, Config.TILE_SIZE, true, true);
        bossEnemy = new Image("file:resource/textures/Enemy/BossEnemy.png", Config.TILE_SIZE, Config.TILE_SIZE, true, true);

        //Audio
        click = new AudioClip("file:resource/Sounds/Click.mp3");
        music = new AudioClip("file:resource/Sounds/Music.mp3");
        machineGunShot = new AudioClip("file:resource/Sounds/MachineGunShot.mp3");
        airShot = new AudioClip("file:resource/Sounds/AirShot.mp3");
        missleShot = new AudioClip("file:resource/Sounds/MissleShot.mp3");
        freezeShot = new AudioClip("file:resource/Sounds/FreezeShot.mp3");
    }
}
