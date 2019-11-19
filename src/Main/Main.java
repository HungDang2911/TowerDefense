package Main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.text.FontSmoothingType;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        final Canvas canvas = new Canvas(Config.GAME_HORIZONTAL_LENGTH, Config.GAME_VERTICAL_LENGTH);
        final GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

        Game game = new Game(graphicsContext);
        game.start();

        canvas.setFocusTraversable(true);
        graphicsContext.setFontSmoothingType(FontSmoothingType.LCD);

        primaryStage.setResizable(false);
        primaryStage.setTitle(Config.GAME_NAME);
        primaryStage.setScene(new Scene(new StackPane(canvas)));
        primaryStage.show();
    }
}
