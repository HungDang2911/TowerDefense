package Main;

import States.GameState.GameField;
import States.GameState.GameStage;
import States.MenuState.Menu;
import States.State;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

import java.io.FileNotFoundException;
import java.util.Stack;

public class Game extends AnimationTimer {
    private final GraphicsContext graphicsContext;

    Stack<State> states;

    GameField field;

    public Game(GraphicsContext graphicsContext) throws FileNotFoundException {
        Assets.init();
        this.graphicsContext = graphicsContext;
        this.field = new GameField(new GameStage("resource/Map/demo.txt"), graphicsContext);
    }

    public void initStates() {
        this.states.push(new Menu());
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
