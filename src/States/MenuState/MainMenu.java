package States.MenuState;

import Main.Assets;
import Main.Config;
import Main.SaveGame;
import States.GameState.GameField;
import States.GameState.GameStage;
import States.State;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.FontSmoothingType;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Stack;

public class MainMenu extends State {
    private Button startButton;
    private Button creditsButton;
    private Button loadButton;

    public MainMenu(Stack<State> states) throws IOException {
        super(states);
    }

    @Override
    protected void initStyleSheets() {
        scene.getStylesheets().add("file:src/States/MenuState/MainMenu.css");
    }

    @Override
    protected void initBackground() {
        this.background = new ImageView(Assets.mainMenuBackground);
    }

    protected void initCanvas() {
        canvas = new Canvas(Config.MAIN_MENU_HORIZONTAL_LENGTH, Config.MAIN_MENU_VERTICAL_LENGTH);
        canvas.setFocusTraversable(true);
        graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setFontSmoothingType(FontSmoothingType.LCD);
        stackPane.getChildren().add(canvas);
    }

    @Override
    protected void initButtons() {
        initStartButton();
        initLoadButton();
        initCreditsButton();
    }

    private void initLoadButton() {
        loadButton = new Button("Load");
        loadButton.setOnAction(e -> {
            try {
                this.states.push(SaveGame.load(states));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        loadButton.setMinWidth(250);
        loadButton.setMinHeight(69);
        loadButton.setTranslateX(200);
        loadButton.setTranslateY(400);
        stackPane.getChildren().add(loadButton);
    }

    private void initCreditsButton() {
    }

    private void initStartButton() {
        startButton = new Button("Start");
        startButton.setOnAction(e -> {
            try {
                states.push(new GameField(new GameStage("resource/Map/demo.txt"), states));
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        startButton.setMinWidth(250);
        startButton.setMinHeight(69);
        startButton.setTranslateX(200);
        startButton.setTranslateY(320);
        stackPane.getChildren().add(startButton);
    }

    @Override
    public void update() {

    }

    @Override
    public void render() {

    }

}
