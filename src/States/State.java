package States;

import Main.Config;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.text.FontSmoothingType;

import java.util.Stack;

public abstract class State {
    protected Stack<State> states;
    protected Scene scene;
    protected StackPane stackPane;
    protected Canvas canvas;
    protected GraphicsContext graphicsContext;
    protected boolean quit;

    protected State(Stack<State> states) {
        this.states = states;

        initBackground();
        initCanvas();
        initStackPane();
        initScene();
        initStyleSheets();
        initButtons();
    }

    protected abstract void initStyleSheets();

    public Scene getScene() {
        return scene;
    }

    protected abstract void initBackground();

    protected abstract void initCanvas();


    protected void initStackPane() {
        stackPane = new StackPane(canvas);
        stackPane.setAlignment(Pos.TOP_LEFT);
    }

    protected void initScene() {
        scene = new Scene(stackPane);
    }

    protected abstract void initButtons();

    public boolean isQuit() {
        return quit;
    }

    public abstract void update();
    public abstract void render();
}
