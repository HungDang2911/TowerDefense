package States.MenuState;

import Main.Assets;
import States.GameState.GameField;
import States.GameState.GameStage;
import States.State;
import javafx.scene.control.Button;
import javafx.scene.image.Image;

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
    protected void initBackground() {
        this.background = Assets.mainMenuBackground;
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
