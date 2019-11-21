package Main;

import States.MenuState.MainMenu;
import States.State;
import javafx.animation.AnimationTimer;
import javafx.stage.Stage;

import java.util.Stack;

public class Game extends AnimationTimer {
    Stage window;
    Stack<State> states = new Stack<>();

    public Game(Stage window) {
        Assets.init();
        this.window = window;
        states.push(new MainMenu(states));
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
