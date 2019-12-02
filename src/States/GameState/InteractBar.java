package States.GameState;

import Entity.GameTile.Mountain;
import Entity.LivingEntity.Tower.*;
import Main.Config;
import Main.Player;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.List;

public abstract class InteractBar extends FlowPane {
    protected double posX;
    protected double posY;

    protected StackPane root;
    protected List<AbstractTower> towers;
    protected GameField field;
    protected Mountain mountain;

    protected Circle towerRange;

    public InteractBar(double posX, double posY, GameField field, Mountain mountain) {
        this.posX = posX;
        this.posY = posY;
        this.root = field.getStackPane();
        this.towers = field.getTowers();
        this.field = field;
        this.mountain = mountain;

        root.getChildren().add(this);

        initSize();
        initStyleSheets();
        initButtons();
        initPosition();
    }

    protected abstract void initPosition();

    protected abstract void initSize();

    protected void initStyleSheets() {
        this.getStylesheets().add("file:src/States/GameState/InteractBar.css");
        this.getStyleClass().add("pane");
    }

    protected abstract void initButtons();


    protected void showRange(double posX, double posY, double range) {
        towerRange = new Circle(0, 0, range, Color.rgb(255, 0, 0, 0.5));
        root.getChildren().add(towerRange);
        towerRange.setTranslateX(-range + posX);
        towerRange.setTranslateY(-range + posY);
    }
}
