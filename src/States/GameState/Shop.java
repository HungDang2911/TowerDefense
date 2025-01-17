package States.GameState;

import Entity.GameTile.Mountain;
import Entity.LivingEntity.Tower.*;
import Main.Config;
import Main.Player;
import javafx.scene.control.Button;

public class Shop extends InteractBar {
    private Button machineGunTowerBtn;
    private Button missleTowerBtn;
    private Button airTowerBtn;
    private Button freezeTowerBtn;

    Shop(double posX, double posY, GameField field, Mountain mountain) {
        super(posX, posY, field, mountain);
    }

    @Override
    protected void initPosition() {
        this.setTranslateX(posX - 68);
        this.setTranslateY(posY - Config.TILE_SIZE);
    }

    @Override
    protected void initSize() {
        this.setMinWidth(199);
        this.setMaxWidth(199);
        this.setMinHeight(55);
        this.setMaxHeight(55);
        this.setHgap(3);
    }

    @Override
    protected void initButtons() {
        initMachineGunTowerBtn();
        initMissleTowerBtn();
        initAirTowerBtn();
        initFreezeTowerBtn();
    }

    private void initAirTowerBtn() {
        airTowerBtn = new Button();
        airTowerBtn.setId("air-tower-btn");
        airTowerBtn.setMinSize(45,45);
        airTowerBtn.setOnMouseEntered(e -> showRange(posX + Config.TILE_SIZE / 2.0, posY + Config.TILE_SIZE / 2.0, Config.AIR_RANGE[1]));
        airTowerBtn.setOnMouseExited(e -> root.getChildren().remove(towerRange));
        airTowerBtn.setOnAction(e -> {
            if (Player.getMoney() >= Config.AIR_PRICE[1]) {
                root.getChildren().remove(towerRange);
                AirTower airTower = new AirTower(mountain.getPosX(), mountain.getPosY());
                towers.add(airTower);
                mountain.setContainingTower(true);
                mountain.setTower(airTower);
                root.getChildren().remove(this);
                Player.decreaseMoney(Config.AIR_PRICE[1]);
                field.setOpeningShop(false);
            }
        });
        this.getChildren().add(airTowerBtn);
    }

    private void initMissleTowerBtn() {
        missleTowerBtn = new Button();
        missleTowerBtn.setId("missle-tower-btn");
        missleTowerBtn.setMinSize(45,45);
        missleTowerBtn.setOnMouseEntered(e -> showRange(posX + Config.TILE_SIZE / 2.0, posY + Config.TILE_SIZE / 2.0, Config.MISSLE_RANGE[1]));
        missleTowerBtn.setOnMouseExited(e -> root.getChildren().remove(towerRange));
        missleTowerBtn.setOnAction(e -> {
            if (Player.getMoney() >= Config.MISSLE_PRICE[1]) {
                root.getChildren().remove(towerRange);
                MissleTower missleTower = new MissleTower(mountain.getPosX(), mountain.getPosY());
                towers.add(missleTower);
                mountain.setContainingTower(true);
                mountain.setTower(missleTower);
                root.getChildren().remove(this);
                Player.decreaseMoney(Config.MISSLE_PRICE[1]);
                field.setOpeningShop(false);
            }
        });

        this.getChildren().add(missleTowerBtn);
    }

    private void initFreezeTowerBtn() {
        freezeTowerBtn = new Button();
        freezeTowerBtn.setId("freeze-tower-btn");
        freezeTowerBtn.setMinSize(45,45);
        freezeTowerBtn.setOnMouseEntered(e -> showRange(posX + Config.TILE_SIZE / 2.0, posY + Config.TILE_SIZE / 2.0, Config.FREEZE_RANGE[1]));
        freezeTowerBtn.setOnMouseExited(e -> root.getChildren().remove(towerRange));
        freezeTowerBtn.setOnAction(e -> {
            if (Player.getMoney() >= Config.FREEZE_PRICE[1]) {
                root.getChildren().remove(towerRange);
                FreezeTower freezeTower = new FreezeTower(mountain.getPosX(), mountain.getPosY());
                towers.add(freezeTower);
                mountain.setContainingTower(true);
                mountain.setTower(freezeTower);
                root.getChildren().remove(this);
                Player.decreaseMoney(Config.FREEZE_PRICE[1]);
                field.setOpeningShop(false);
            }
        });
        this.getChildren().add(freezeTowerBtn);
    }

    private void initMachineGunTowerBtn() {
        machineGunTowerBtn = new Button();
        machineGunTowerBtn.setId("machine-gun-tower-btn");
        machineGunTowerBtn.setMinSize(45,45);
        machineGunTowerBtn.setOnMouseEntered(e -> showRange(posX + Config.TILE_SIZE / 2.0, posY + Config.TILE_SIZE / 2.0, Config.MACHINE_GUN_RANGE[1]));
        machineGunTowerBtn.setOnMouseExited(e -> root.getChildren().remove(towerRange));
        machineGunTowerBtn.setOnAction(e -> {
            if (Player.getMoney() >= Config.MACHINE_GUN_PRICE[1]) {
                root.getChildren().remove(towerRange);
                MachineGunTower machineGunTower = new MachineGunTower(mountain.getPosX(), mountain.getPosY());
                towers.add(machineGunTower);
                mountain.setContainingTower(true);
                mountain.setTower(machineGunTower);
                root.getChildren().remove(this);
                Player.decreaseMoney(Config.MACHINE_GUN_PRICE[1]);
                field.setOpeningShop(false);
            }
        });
        this.getChildren().add(machineGunTowerBtn);
    }

}
