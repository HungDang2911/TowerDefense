package game;

import Entity.GameTile.Mountain;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.text.FontSmoothingType;
import javafx.stage.Stage;

import java.io.File;
import java.util.Scanner;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        final Canvas canvas = new Canvas(500, 500);
        final GraphicsContext graphicsContext = canvas.getGraphicsContext2D();


        Mountain mountain = new Mountain(0,0);
        mountain.render(graphicsContext);


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
