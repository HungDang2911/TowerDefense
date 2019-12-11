package Main;

import States.MenuState.MainMenu;
import States.State;
import javafx.animation.AnimationTimer;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Stack;

public class Game extends AnimationTimer {
    Stage window;
    Stack<State> states = new Stack<>();

    public Game(Stage window) throws IOException {
        Assets.init();
        this.window = window;
        states.push(new MainMenu(states));
        Assets.music.play();
    }


    private void update() throws IOException {
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
        try {
            update();
        } catch (IOException e) {
            e.printStackTrace();
        }
        render();
    }
}
