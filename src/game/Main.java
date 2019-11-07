package game;

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
        final Canvas canvas = new Canvas(500, 500);
        final GraphicsContext graphicsContext = canvas.getGraphicsContext2D();


//        graphicsContext.drawImage(Assets.mountain, 0, 0);

        Game game = new Game(graphicsContext);

        canvas.setFocusTraversable(true);
        graphicsContext.setFontSmoothingType(FontSmoothingType.LCD);

        primaryStage.setResizable(false);
        primaryStage.setTitle(Config.GAME_NAME);
        primaryStage.setScene(new Scene(new StackPane(canvas)));
        primaryStage.show();
    }
}
