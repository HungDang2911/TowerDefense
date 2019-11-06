package game;

public class Player {

    private static final int STARTING_LIVES = 30;
    private static final int STARTING_MONEY = 50;

    private static long money;
    private static int lives;

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
}
