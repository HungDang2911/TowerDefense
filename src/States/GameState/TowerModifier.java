package States.GameState;

import Entity.GameTile.Mountain;
import Entity.LivingEntity.Tower.*;
import Main.Config;
import Main.Player;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;

import java.util.List;

public class TowerModifier extends FlowPane {
    private double posX;
    private double posY;

    private StackPane root;
    private List<AbstractTower> towers;
    private Mountain mountain;

    private Button upgradeTowerBtn;
    private Button sellTowerBtn;

    public TowerModifier(double posX, double posY, StackPane root, List<AbstractTower> towers, Mountain mountain) {
        this.posX = posX;
        this.posY = posY;
        this.root = root;
        this.towers = towers;
        this.mountain = mountain;

        root.getChildren().add(this);

        initSize();
        initStyleSheets();
        initButtons();
        initPosition();
    }

    private void initPosition() {
        this.setTranslateX(posX);
        this.setTranslateY(posY);
    }

    private void initSize() {
        this.setMinWidth(157);
        this.setMaxWidth(157);
        this.setMinHeight(100);
        this.setMaxHeight(100);
        this.setHgap(3);
    }

    private void initStyleSheets() {
        this.getStylesheets().add("file:src/States/GameState/InteractBar.css");
        this.getStyleClass().add("pane");
    }

    private void initButtons() {
        initUpgradeTowerButton();
        initSellButton();
    }


    private void initUpgradeTowerButton() {
        upgradeTowerBtn = new Button();
        upgradeTowerBtn.setId("upgrade-tower-btn");
        upgradeTowerBtn.setMinSize(32,32);
        upgradeTowerBtn.setOnAction(e -> {
            towers.add(new AirTower(mountain.getPosX(), mountain.getPosY()));
            mountain.setContainingTower(true);
            root.getChildren().remove(this);
            Player.decreaseMoney(Config.AIR_PRICE);
        });
        this.getChildren().add(upgradeTowerBtn);
    }

    private void initSellButton() {
        sellTowerBtn = new Button();
        sellTowerBtn.setId("sell-tower-btn");
        sellTowerBtn.setMinSize(32,32);
        sellTowerBtn.setOnAction(e -> {
            towers.add(new AirTower(mountain.getPosX(), mountain.getPosY()));
            mountain.setContainingTower(true);
            root.getChildren().remove(this);
            Player.decreaseMoney(Config.AIR_PRICE);
        });
        this.getChildren().add(sellTowerBtn);
    }
}
