package Main;

import States.GameState.GameField;
import States.MenuState.MainMenu;
import States.State;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.Stack;

public class Game extends AnimationTimer {
    Stage window;
    Stack<State> states = new Stack<>();
    GameField field;

    public Game(Stage window) throws FileNotFoundException {
        Assets.init();
        this.window = window;
        states.push(new MainMenu(states));

//        this.field = new GameField(new GameStage("resource/Map/demo.txt"), graphicsContext);
    }


    private void update() {
        if (states.isEmpty()) this.stop();
        else {
            window.setScene(states.peek().getScene());
            states.peek().update();
        }
    }

    public void render() {
        states.peek().render();
    }

    @Override
    public void handle(long l) {
        update();
        render();
    }
}
