package States.GameState;

import Main.Assets;
import Main.Player;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class Information extends StackPane {
    private final ImageView livesIcon = new ImageView(Assets.livesIcon);
    private final ImageView moneyIcon = new ImageView(Assets.moneyIcon);
    private final ImageView waveIcon = new ImageView(Assets.waveIcon);

    private Text lives = new Text();
    private Text money = new Text();
    private Text wave = new Text();

    GameField field;

    public Information(GameField field) {
        this.field = field;
        init();
    }

    public void update() {
        lives.setText("" + Player.getLives());
        money.setText("" + Player.getMoney());
    }

    private void init() {
        this.getStylesheets().add("file:src/States/GameState/Information.css");
        this.setAlignment(Pos.TOP_LEFT);
        this.setMaxSize(300,100);
        field.getStackPane().getChildren().add(this);
        initImageView();
        initText();
    }

    private void initImageView() {
        this.getChildren().add(livesIcon);
        livesIcon.setTranslateX(10);
        livesIcon.setTranslateY(5);
        this.getChildren().add(moneyIcon);
        moneyIcon.setTranslateX(130);
        moneyIcon.setTranslateY(5);
        this.getChildren().add(waveIcon);
        waveIcon.setTranslateX(10);
        waveIcon.setTranslateY(50);
    }

    private void initText() {
        this.getChildren().add(lives);
        lives.setTranslateX(60);
        lives.setTranslateY(10);
        this.getChildren().add(money);
        money.setTranslateX(183);
        money.setTranslateY(10);
    }
}
