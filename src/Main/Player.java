package Main;

public class Player {

    private static final int STARTING_LIVES = 30;
    private static final int STARTING_MONEY = 50;

    private static long money = 30;
    private static int lives = 50;

    public static void addMoney(long amount) {
        money += amount;
    }

    public static void decreaseLife() {
        lives--;
    }

    public static int getLives() {
        return lives;
    }

    public static long getMoney() {
        return money;
    }

    public static void render() {

    }
}
