package Main;

import javafx.scene.canvas.GraphicsContext;

public class Player {

    private static final int STARTING_LIVES = 30;
    private static final int STARTING_MONEY = 50;

    private static int money = 30;
    private static int lives = 50;

    public static void reset() {
        money = STARTING_MONEY;
        lives = STARTING_LIVES;
    }

    public static void addMoney(int amount) {
        money += amount;
    }

    public static void decreaseLife() {
        lives--;
    }

    public static void decreaseMoney(int amount) {
        money -= amount;
    }

    public static int getLives() {
        return lives;
    }

    public static long getMoney() {
        return money;
    }

    public static void render(GraphicsContext graphicsContext) {

    }
}
