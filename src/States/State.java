package States;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;

import java.util.Stack;

public abstract class State {
    protected Pane pane;
    protected final GraphicsContext graphicsContext;
    protected Stack<State> states;

    protected State(Pane pane, GraphicsContext graphicsContext, Stack<State> states) {
        this.states = states;
        this.pane = pane;
        this.graphicsContext = graphicsContext;
    }

    protected abstract void initButtons();

    public abstract void update();
    public abstract void render();
}
