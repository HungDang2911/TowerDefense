package game;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

import java.io.FileNotFoundException;

public class Game extends AnimationTimer {
    private final GraphicsContext graphicsContext;

    GameField field;

    public Game(GraphicsContext graphicsContext) throws FileNotFoundException {
        Assets.init();
        this.graphicsContext = graphicsContext;
        this.field = new GameField(new GameStage("resource/Map/demo.txt"), graphicsContext);
    }

    private void update() {
        field.update();
    }

    public void render() {
        field.render();
    }

    @Override
    public void handle(long l) {
        update();
        render();
    }
}
