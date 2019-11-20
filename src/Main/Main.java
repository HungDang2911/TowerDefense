package Main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    Stage window;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Scene scene = new Scene(new StackPane());
        window = primaryStage;


        Game game = new Game(window);
        game.start();

//        canvas.setFocusTraversable(true);
//        graphicsContext.setFontSmoothingType(FontSmoothingType.LCD);

        window.setResizable(false);
        window.setTitle(Config.GAME_NAME);
//        window.setScene(scene);
        window.show();
    }
}
