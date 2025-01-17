package States.GameState;

import Entity.GameTile.Mountain;
import Main.Config;
import Main.Player;
import javafx.scene.control.Button;


public class TowerModifier extends InteractBar {
    private Button upgradeTowerBtn;
    private Button sellTowerBtn;

    public TowerModifier(double posX, double posY, GameField field, Mountain mountain) {
        super(posX, posY, field, mountain);
    }

    protected void initPosition() {
        this.setTranslateX(posX - 15);
        this.setTranslateY(posY - Config.TILE_SIZE);
    }

    protected void initSize() {
        this.setMinWidth(103);
        this.setMaxWidth(103);
        this.setMinHeight(55);
        this.setMaxHeight(55);
        this.setHgap(3);
    }

    protected void initButtons() {
        initUpgradeTowerButton();
        initSellButton();
    }


    private void initUpgradeTowerButton() {
        upgradeTowerBtn = new Button();
        upgradeTowerBtn.setId("upgrade-tower-btn");
        upgradeTowerBtn.setMinSize(45,45);
        upgradeTowerBtn.setOnMouseEntered(e -> showRange(posX + Config.TILE_SIZE / 2.0, posY + Config.TILE_SIZE / 2.0, mountain.getTower().getNextLevelRange()));
        upgradeTowerBtn.setOnMouseExited(e -> root.getChildren().remove(towerRange));
        upgradeTowerBtn.setOnAction(e -> {
            root.getChildren().remove(towerRange);
            if (Player.getMoney() >= mountain.getTower().getNextLevelPrice()) {
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
        sellTowerBtn.setMinSize(45,45);
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
