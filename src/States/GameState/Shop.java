package States.GameState;

import Entity.LivingEntity.Tower.AbstractTower;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

import java.util.List;

public class Shop extends Group {
    private double posX;
    private double posY;

    private StackPane root;
    private List<AbstractTower> towers;

    private Button machineGunTowerBtn;
    private Button missleTowerBtn;
    private Button airTowerBtn;
    private Button freezeTowerBtn;

    public Shop(double posX, double posY, StackPane root, List<AbstractTower> towers) {
        this.posX = posX;
        this.posY = posY;
        this.root = root;
        this.towers = towers;

        initStyleSheets();
        initButtons();
    }

    private void initStyleSheets() {
        this.getStylesheets().add("Shop.css");
    }

    private void initButtons() {
        initMachineGunTowerBtn();
        initMissleTowerBtn();
        initAirTowerBtn();
        initFreezeTowerBtn();
    }

    private void initAirTowerBtn() {
        airTowerBtn = new Button();
        airTowerBtn.getStyleClass().add("btn");
        airTowerBtn.setId("air-tower-btn");
    }

    private void initMissleTowerBtn() {
        missleTowerBtn = new Button();
        airTowerBtn.getStyleClass().add("btn");
        missleTowerBtn.setId("missle-tower-btn");
    }

    private void initFreezeTowerBtn() {
        freezeTowerBtn = new Button();
        airTowerBtn.getStyleClass().add("btn");
        freezeTowerBtn.setId("freeze-tower-btn");
    }

    private void initMachineGunTowerBtn() {
        machineGunTowerBtn = new Button();
        airTowerBtn.getStyleClass().add("btn");
        machineGunTowerBtn.setId("machine-gun-tower-btn");
    }
}
