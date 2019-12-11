package States;

import Main.Assets;
import Main.SaveGame;
import States.GameState.GameField;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.Stack;

public class SettingsState extends State {
    private Button backToMenuBtn;
    private Button saveBtn;
    private Button resumeBtn;

    public SettingsState(Stack<State> states) throws IOException {
        super(states);
    }

    @Override
    protected void initStyleSheets() {
        scene.getStylesheets().add("file:src/States/MenuState/MainMenu.css");
    }

    @Override
    protected void initBackground() {
        this.background = new ImageView(Assets.settingsBackground);
    }

    @Override
    protected void initCanvas() {

    }

    @Override
    protected void initButtons() throws IOException {
        initBackToMenuBtn();
        initSaveBtn();
        initResumeBtn();
    }

    private void initResumeBtn() {
        resumeBtn = new Button("Resume");
        resumeBtn.setOnAction(e -> {
            states.pop();
        });
        resumeBtn.setMinWidth(250);
        resumeBtn.setMinHeight(69);
        resumeBtn.setTranslateX(200);
        resumeBtn.setTranslateY(100);
        stackPane.getChildren().add(resumeBtn);
    }

    private void initSaveBtn() throws IOException {
        saveBtn = new Button("Save");
        saveBtn.setOnAction(e -> {
            states.pop();
            try {
                SaveGame.save((GameField)states.peek());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        saveBtn.setMinWidth(250);
        saveBtn.setMinHeight(69);
        saveBtn.setTranslateX(200);
        saveBtn.setTranslateY(200);
        stackPane.getChildren().add(saveBtn);
    }

    private void initBackToMenuBtn() {
        backToMenuBtn = new Button("Back To Menu");
        backToMenuBtn.setOnAction(e -> {
            states.pop();
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