package States.GameState;

import Entity.GameTile.Mountain;
import Entity.LivingEntity.Tower.*;
import Main.Config;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;

import java.util.List;

public class Shop extends FlowPane {
    private double posX;
    private double posY;

    private StackPane root;
    private List<AbstractTower> towers;
    private Mountain mountain;

    private Button machineGunTowerBtn;
    private Button missleTowerBtn;
    private Button airTowerBtn;
    private Button freezeTowerBtn;

    public Shop(double posX, double posY, StackPane root, List<AbstractTower> towers, Mountain mountain) {
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
        this.getStylesheets().add("file:src/States/GameState/Shop.css");
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
        airTowerBtn.setOnAction(e -> {
            towers.add(new AirTower(mountain.getPosX(), mountain.getPosY()));
            mountain.setContainingTower(true);
            root.getChildren().remove(this);
        });
        this.getChildren().add(airTowerBtn);
    }

    private void initMissleTowerBtn() {
        missleTowerBtn = new Button();
        missleTowerBtn.setId("missle-tower-btn");
        missleTowerBtn.setMinSize(32,32);
        missleTowerBtn.setOnAction(e -> {
            towers.add(new MissleTower(mountain.getPosX(), mountain.getPosY()));
            mountain.setContainingTower(true);
            root.getChildren().remove(this);
        });
        this.getChildren().add(missleTowerBtn);
    }

    private void initFreezeTowerBtn() {
        freezeTowerBtn = new Button();
        freezeTowerBtn.setId("freeze-tower-btn");
        freezeTowerBtn.setMinSize(32,32);
        freezeTowerBtn.setOnAction(e -> {
            towers.add(new FreezeTower(mountain.getPosX(), mountain.getPosY()));
            mountain.setContainingTower(true);
            root.getChildren().remove(this);
        });
        this.getChildren().add(freezeTowerBtn);
    }

    private void initMachineGunTowerBtn() {
        machineGunTowerBtn = new Button();
        machineGunTowerBtn.setId("machine-gun-tower-btn");
        machineGunTowerBtn.setMinSize(32,32);
        machineGunTowerBtn.setOnAction(e -> {
            towers.add(new MachineGunTower(mountain.getPosX(), mountain.getPosY()));
            mountain.setContainingTower(true);
            root.getChildren().remove(this);
        });
        this.getChildren().add(machineGunTowerBtn);
    }
}
