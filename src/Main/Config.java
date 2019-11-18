package Main;

public class Config {
    public static final String GAME_NAME = "Tower Defense";
    public static final int TILE_SIZE = 64;
    public static final int GAME_HORIZONTAL_LENGTH = 1280;
    public static final int GAME_VERTICAL_LENGTH = 960;


    /** ***************************TOWERS***************************** **/

    //MACHINE GUN TOWER
    public static final int MACHINE_GUN_ATTACK_SPEED = 60;
    public static final int MACHINE_GUN_DAMAGE = 20;
    public static final double MACHINE_GUN_RANGE = TILE_SIZE * 3.5;
    public static final double MACHINE_GUN_BULLET_SPEED = 10;

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
