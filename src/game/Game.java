package game;

import javafx.scene.canvas.GraphicsContext;

public class Game {
    private final GraphicsContext graphicsContext;

    GameField field;

    public Game(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
        this.field = new GameField(new GameStage("demo.txt"));
    }


    public void run() {
        long lastTime = System.nanoTime();
        double delta = 0;

        while (true) {
            long now = System.nanoTime();
            delta += (now - lastTime) / Config.NANOSECONDS_PER_TICK;
            if (delta >= 1) {
                update();
                render();
            }
        }
    }

    private void update() {

    }

    private void render() {

    }
}
