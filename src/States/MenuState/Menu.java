package States.MenuState;

import Main.Assets;
import States.GameState.GameField;
import States.GameState.GameStage;
import States.State;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.FileNotFoundException;
import java.util.Stack;

public class Menu extends State {
    private Image background;
    private GraphicsContext graphicsContext;
    private Button startGameButton;

    public Menu(Pane pane, GraphicsContext graphicsContext, Stack<State> states) {
        super(pane, graphicsContext, states);
        this.graphicsContext = graphicsContext;
        initBackground();
        initButtons();
    }

    private void initBackground() {
        this.background = Assets.menuBackground;
        this.graphicsContext.drawImage(background, 0 ,0);
    }

    @Override
    protected void initButtons() {
        this.startGameButton = new Button("start");
        startGameButton.setId("start");
        startGameButton.setOnAction((actionEvent -> {
            try {
                states.add(new GameField(pane, new GameStage("resource/Map/demo.txt"), graphicsContext, states));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }));
        pane.getChildren().add(startGameButton);
    }

    @Override
    public void update() {

    }

    @Override
    public void render() {

    }
}
