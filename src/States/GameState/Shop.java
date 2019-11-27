package States.GameState;

import Entity.GameTile.Mountain;
import Entity.LivingEntity.Tower.*;
import Main.Config;
import Main.Player;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.List;

public class Shop extends FlowPane {
    private double posX;
    private double posY;

    private StackPane root;
    private List<AbstractTower> towers;
    private GameField field;
    private Mountain mountain;

    private Button machineGunTowerBtn;
    private Button missleTowerBtn;
    private Button airTowerBtn;
    private Button freezeTowerBtn;

    private Circle towerRange;

    public Shop(double posX, double posY, GameField field, Mountain mountain) {
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

    private void initPosition() {
        this.setTranslateX(posX);
        this.setTranslateY(posY);
    }

    private void initSize() {
        this.setMinWidth(147);
        this.setMaxWidth(147);
        this.setMinHeight(42);
        this.setMaxHeight(42);
        this.setHgap(3);
    }

    private void initStyleSheets() {
        this.getStylesheets().add("file:src/States/GameState/InteractBar.css");
        this.getStyleClass().add("pane");
    }

    private void initButtons() {
        initMachineGunTowerBtn();
        initMissleTowerBtn();
        initAirTowerBtn();
        initFreezeTowerBtn();
    }

    private void initAirTowerBtn() {
        airTowerBtn = new Button();
        airTowerBtn.setId("air-tower-btn");
        airTowerBtn.setMinSize(32,32);
//        airTowerBtn.setOnMouseEntered(e -> showRange(posX + Config.TILE_SIZE / 2, posY + Config.TILE_SIZE / 2, Config.AIR_RANGE));
        airTowerBtn.setOnMouseExited(e -> root.getChildren().remove(towerRange));
        airTowerBtn.setOnAction(e -> {
            AirTower airTower = new AirTower(mountain.getPosX(), mountain.getPosY());
            towers.add(airTower);
            mountain.setContainingTower(true);
            mountain.setTower(airTower);
            root.getChildren().remove(this);
            Player.decreaseMoney(Config.AIR_PRICE[1]);
            field.setOpeningShop(false);
        });
        this.getChildren().add(airTowerBtn);
    }

    private void initMissleTowerBtn() {
        missleTowerBtn = new Button();
        missleTowerBtn.setId("missle-tower-btn");
        missleTowerBtn.setMinSize(32,32);
//        airTowerBtn.setOnMouseEntered(e -> showRange(posX + Config.TILE_SIZE / 2, posY + Config.TILE_SIZE / 2, Config.AIR_RANGE));
        missleTowerBtn.setOnMouseEntered(e -> {

        });
        missleTowerBtn.setOnAction(e -> {
            MissleTower missleTower = new MissleTower(mountain.getPosX(), mountain.getPosY());
            towers.add(missleTower);
            mountain.setContainingTower(true);
            mountain.setTower(missleTower);
            root.getChildren().remove(this);
            Player.decreaseMoney(Config.MISSLE_PRICE[1]);
            field.setOpeningShop(false);
        });

        this.getChildren().add(missleTowerBtn);
    }

    private void initFreezeTowerBtn() {
        freezeTowerBtn = new Button();
        freezeTowerBtn.setId("freeze-tower-btn");
        freezeTowerBtn.setMinSize(32,32);
//        airTowerBtn.setOnMouseEntered(e -> drawRange(posX + Config.TILE_SIZE / 2, posY + Config.TILE_SIZE / 2, Config.AIR_RANGE));
        freezeTowerBtn.setOnAction(e -> {
            FreezeTower freezeTower = new FreezeTower(mountain.getPosX(), mountain.getPosY());
            towers.add(freezeTower);
            mountain.setContainingTower(true);
            mountain.setTower(freezeTower);
            root.getChildren().remove(this);
            Player.decreaseMoney(Config.FREEZE_PRICE[1]);
            field.setOpeningShop(false);
        });
        this.getChildren().add(freezeTowerBtn);
    }

    private void initMachineGunTowerBtn() {
        machineGunTowerBtn = new Button();
        machineGunTowerBtn.setId("machine-gun-tower-btn");
        machineGunTowerBtn.setMinSize(32,32);
//        airTowerBtn.setOnMouseEntered(e -> drawRange(posX + Config.TILE_SIZE / 2, posY + Config.TILE_SIZE / 2, Config.AIR_RANGE));
        machineGunTowerBtn.setOnAction(e -> {
            MachineGunTower machineGunTower = new MachineGunTower(mountain.getPosX(), mountain.getPosY());
            towers.add(machineGunTower);
            mountain.setContainingTower(true);
            mountain.setTower(machineGunTower);
            root.getChildren().remove(this);
            Player.decreaseMoney(Config.MACHINE_GUN_PRICE[1]);
            field.setOpeningShop(false);
        });
        this.getChildren().add(machineGunTowerBtn);
    }

    private void showRange(double posX, double posY, double range) {
        towerRange = new Circle(0, 0, range, Color.rgb(255, 0, 0, 0.5));
        root.getChildren().add(towerRange);
        towerRange.setTranslateX(posX);
        towerRange.setTranslateY(posY);
    }
}
