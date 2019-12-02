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
        this.setAlignment(Pos.TOP_LEFT);
        this.getStylesheets().add("file:src/States/GameState/Information.css");

        field.getStackPane().getChildren().add(this);

        this.getChildren().add(livesIcon);

        this.getChildren().add(lives);
        lives.getStyleClass().add("text");

//        this.getChildren().add(money);
    }
}
