package States;

import Main.Config;
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

    protected State(Stack<State> states) {
        this.states = states;

        initBackground();
        initCanvas();
        initStackPane();
        initScene();
        initButtons();
    }

    public Scene getScene() {
        return scene;
    }

    protected abstract void initBackground();

    protected void initCanvas() {
        canvas = new Canvas(Config.GAME_HORIZONTAL_LENGTH, Config.GAME_VERTICAL_LENGTH);
        canvas.setFocusTraversable(true);
        graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setFontSmoothingType(FontSmoothingType.LCD);
    }


    protected void initStackPane() {
        stackPane = new StackPane(canvas);
    }

    protected void initScene() {
        scene = new Scene(stackPane);
    }

    protected abstract void initButtons();

    public abstract void update();
    public abstract void render();
}
