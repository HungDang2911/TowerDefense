package States.GameState;

import Entity.GameTile.Mountain;
import Entity.LivingEntity.Tower.*;
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
    private GameField field;
    private Mountain mountain;

    private Button upgradeTowerBtn;
    private Button sellTowerBtn;

    public TowerModifier(double posX, double posY, GameField field, Mountain mountain) {
        this.posX = posX;
        this.posY = posY;
        this.field = field;
        this.root = field.getStackPane();
        this.towers = field.getTowers();
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
            if (Player.getMoney() > mountain.getTower().getNextLevelPrice()) {
                Player.decreaseMoney(mountain.getTower().getNextLevelPrice());
                mountain.getTower().upgrade();
                root.getChildren().remove(this);
                field.setOpeningTowerModifier(false);
            }
        });
        this.getChildren().add(upgradeTowerBtn);
    }

    private void initSellButton() {
        sellTowerBtn = new Button();
        sellTowerBtn.setId("sell-tower-btn");
        sellTowerBtn.setMinSize(32,32);
        sellTowerBtn.setOnAction(e -> {
            Player.increaseMoney(mountain.getTower().getPrice() * 75/100);
            towers.remove(mountain.getTower());
            mountain.setContainingTower(false);
            mountain.setTower(null);
            root.getChildren().remove(this);
            field.setOpeningTowerModifier(false);
        });
        this.getChildren().add(sellTowerBtn);
    }
}
