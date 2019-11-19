package Main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
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
        StackPane stackPane = new StackPane((canvas));

        Scene scene = new Scene(stackPane);
        scene.getStylesheets().add("file:src/Main/style.css");

        Game game = new Game(graphicsContext, stackPane);
        game.start();

        canvas.setFocusTraversable(true);
        graphicsContext.setFontSmoothingType(FontSmoothingType.LCD);

        primaryStage.setResizable(false);
        primaryStage.setTitle(Config.GAME_NAME);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
