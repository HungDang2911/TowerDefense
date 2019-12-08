package States;

import javafx.scene.control.Button;

import java.util.Stack;

public class WinState extends State{
    private Button backToMenuBtn;

    public WinState(Stack<State> states) {
        super(states);
    }

    @Override
    protected void initStyleSheets() {

    }

    @Override
    protected void initBackground() {

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
        backToMenuBtn.setId("start-btn");
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
