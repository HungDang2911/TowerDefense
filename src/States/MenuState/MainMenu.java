package States.MenuState;

import Main.Assets;
import Main.Config;
import States.GameState.GameField;
import States.GameState.GameStage;
import States.State;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.text.FontSmoothingType;

import java.io.FileNotFoundException;
import java.util.Stack;

public class MainMenu extends State {
    private Image background;

    private Button startButton;
    private Button creditsButton;

    public MainMenu(Stack<State> states) {
        super(states);
    }

    @Override
    protected void initStyleSheets() {
        scene.getStylesheets().add("file:src/States/MenuState/MainMenu.css");
    }

    @Override
    protected void initBackground() {
        this.background = Assets.mainMenuBackground;
    }

    protected void initCanvas() {
        canvas = new Canvas(Config.MAIN_MENU_HORIZONTAL_LENGTH, Config.MAIN_MENU_VERTICAL_LENGTH);
        canvas.setFocusTraversable(true);
        graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setFontSmoothingType(FontSmoothingType.LCD);
    }

    @Override
    protected void initButtons() {
        initStartButton();
        initCreditsButton();
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
            }
        });
        startButton.setMinWidth(250);
        startButton.setMinHeight(69);
        startButton.setId("start-btn");
        startButton.setTranslateX(200);
        startButton.setTranslateY(320);
        stackPane.getChildren().add(startButton);
    }

    @Override
    public void update() {

    }

    @Override
    public void render() {
        graphicsContext.drawImage(background, 0 , 0);
    }

}
