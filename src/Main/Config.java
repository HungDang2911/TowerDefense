package Main;

public class Config {
    public static final String GAME_NAME = "Tower Defense";
    public static final int TILE_SIZE = 64;
    public static final int GAME_FIELD_HORIZONTAL_LENGTH = 1280;
    public static final int GAME_FIELD_VERTICAL_LENGTH = 960;
    public static final int MAIN_MENU_HORIZONTAL_LENGTH = 1280;
    public static final int MAIN_MENU_VERTICAL_LENGTH = 640;
    public static final int NUM_OF_WAVES = 5;
    public static final int SPAWN_INTERVAL = 60;


    /** ***************************TOWERS***************************** **/

    //MACHINE GUN TOWER
    public static final int MACHINE_GUN_ATTACK_SPEED = 60;
    public static final int[] MACHINE_GUN_DAMAGE = {0, 20, 50, 120, 300, 700};
    public static final double[] MACHINE_GUN_RANGE = {0, TILE_SIZE * 3.5, TILE_SIZE * 3.6, TILE_SIZE * 3.7, TILE_SIZE * 3.8, TILE_SIZE * 3.9};
    public static final double MACHINE_GUN_BULLET_SPEED = 10;
    public static final int[] MACHINE_GUN_PRICE = {0, 20, 50, 120, 300, 700};

    //AIR TOWER
    public static final int AIR_ATTACK_SPEED = 60;
    public static final int[] AIR_DAMAGE = {0, 20, 50, 120, 300, 700};
    public static final double[] AIR_RANGE = {0, TILE_SIZE * 3.5, TILE_SIZE * 3.6, TILE_SIZE * 3.7, TILE_SIZE * 3.8, TILE_SIZE * 3.9};
    public static final double AIR_BULLET_SPEED = 10;
    public static final int[] AIR_PRICE = {0, 20, 50, 120, 300, 700};

    //FREEZE TOWER
    public static final int FREEZE_ATTACK_SPEED = 60;
    public static final int[] FREEZE_DAMAGE = {0, 20, 50, 120, 300, 700};
    public static final double[] FREEZE_RANGE = {0, TILE_SIZE * 3.5, TILE_SIZE * 3.6, TILE_SIZE * 3.7, TILE_SIZE * 3.8, TILE_SIZE * 3.9};
    public static final double FREEZE_BULLET_SPEED = 10;
    public static final int[] FREEZE_PRICE = {0, 20, 50, 120, 300, 700};

    //MISSLE TOWER
    public static final int MISSLE_ATTACK_SPEED = 60;
    public static final int[] MISSLE_DAMAGE = {0, 20, 50, 120, 300, 700};
    public static final double[] MISSLE_RANGE = {0, TILE_SIZE * 3.5, TILE_SIZE * 3.6, TILE_SIZE * 3.7, TILE_SIZE * 3.8, TILE_SIZE * 3.9};
    public static final double MISSLE_BULLET_SPEED = 10;
    public static final int[] MISSLE_PRICE = {0, 20, 50, 120, 300, 700};

    /** ***************************ENEMIES***************************** **/
    //NORMAL ENEMY
    public static final int NORMAL_ENEMY_HITPOINTS = 60;
    public static final double NORMAL_ENEMY_SPEED = 0.7;
    public static final int NORMAL_ENEMY_ARMOR = 5;
    public static final int NORMAL_ENEMY_REWARD = 1;

    //FAST ENEMY
    public static final int FAST_ENEMY_HITPOINTS = 40;
    public static final double FAST_ENEMY_SPEED= 1;
    public static final int FAST_ENEMY_ARMOR = 0;
    public static final int FAST_ENEMY_REWARD = 2;

    //TANKER ENEMY
    public static final int TANKER_ENEMY_HITPOINTS = 150;
    public static final double TANKER_ENEMY_SPEED = 0.3;
    public static final int TANKER_ENEMY_ARMOR = 15;
    public static final int TANKER_ENEMY_REWARD = 5;

    //BOSS ENEMY
    public static final int BOSS_ENEMY_HITPOINTS = 500;
    public static final double BOSS_ENEMY_SPEED = 0.2;
    public static final int BOSS_ENEMY_ARMOR = 50;
    public static final int BOSS_ENEMY_REWARD = 30;
}
