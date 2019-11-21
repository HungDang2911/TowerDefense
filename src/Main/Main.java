package Main;

import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    Stage window;
    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;

        Game game = new Game(window);
        game.start();

        window.setResizable(false);
        window.setTitle(Config.GAME_NAME);
        window.show();
    }
}
