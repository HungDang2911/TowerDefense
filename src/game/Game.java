package game;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

public class Game extends AnimationTimer {
    private final GraphicsContext graphicsContext;

    GameField field;

    public Game(GraphicsContext graphicsContext) {
        Assets.init();
        this.graphicsContext = graphicsContext;
        this.field = new GameField(new GameStage("file:resource/Map/demo.txt"), graphicsContext);
//        this.field = new GameField(graphicsContext);
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
