package Main;

public class Player {

    private static final int STARTING_LIVES = 30;
    private static final int STARTING_MONEY = 50;

    private static int lives = 30;
    private static int money = 50;

    public static int getLives() {
        return lives;
    }

    public static void setLives(int lives) {
        Player.lives = lives;
    }

    public static long getMoney() {
        return money;
    }

    public static void setMoney(int money) {
        Player.money = money;
    }

    public static void reset() {
        money = STARTING_MONEY;
        lives = STARTING_LIVES;
    }

    public static void increaseMoney(int amount) {
        money += amount;
    }

    public static void decreaseLife() {
        lives--;
    }

    public static void decreaseMoney(int amount) {
        money -= amount;
    }


}
