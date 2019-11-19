package Main;

import States.GameState.GameField;
import States.GameState.GameStage;
import States.MenuState.Menu;
import States.State;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;

import java.io.FileNotFoundException;
import java.util.Stack;

public class Game extends AnimationTimer {
    private final GraphicsContext graphicsContext;
    private Pane pane;

    Stack<State> states = new Stack<>();

    GameField field;

    public Game(GraphicsContext graphicsContext, Pane pane) throws FileNotFoundException {
        this.graphicsContext = graphicsContext;
        this.pane = pane;
        Assets.init();
        states.add(new Menu(pane, graphicsContext, states));
//        states.add(new GameField(pane, new GameStage("resource/Map/demo.txt"), graphicsContext));
    }

    private void update() {
        this.states.peek().update();
    }

    public void render() {
        this.states.peek().render();
    }

    @Override
    public void handle(long l) {
        update();
        render();
    }
}
