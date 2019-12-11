package States;


import Main.Assets;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.Stack;

public class LoseState extends State{
    private Button backToMenuBtn;

    public LoseState(Stack<State> states) throws IOException {
        super(states);
    }

    @Override
    protected void initStyleSheets() {
        scene.getStylesheets().add("file:src/States/MenuState/MainMenu.css");
    }

    @Override
    protected void initBackground() {
        this.background = new ImageView(Assets.loseBackground);
    }

    @Override
    protected void initCanvas() {

    }

    @Override
    protected void initButtons() {
        initBackToMenuBtn();
    }

    private void initBackToMenuBtn() {
        backToMenuBtn = new Button("Back To Menu");
        backToMenuBtn.setOnAction(e -> {
            states.pop();
        });
        backToMenuBtn.setMinWidth(250);
        backToMenuBtn.setMinHeight(69);
        backToMenuBtn.setTranslateX(200);
        backToMenuBtn.setTranslateY(320);
        stackPane.getChildren().add(backToMenuBtn);
    }

    @Override
    public void update() {

    }

    @Override
    public void render() {

    }
}
