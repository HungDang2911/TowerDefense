package States.GameState;

import Entity.GameTile.AbstractTile;
import Entity.GameTile.Mountain;
import Entity.GameTile.Spawner;
import Entity.LivingEntity.Bullet.AbstractBullet;
import Entity.LivingEntity.Enemy.AbstractEnemy;
import Entity.LivingEntity.Enemy.FastEnemy;
import Entity.LivingEntity.Tower.AbstractTower;
import Main.Config;
import States.State;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.FontSmoothingType;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GameField extends State{
    //WAVES
    private int currentWave;
    private boolean changingWave;

    //ENTITES
    private AbstractTile[][] tiles;
    private List<AbstractEnemy> enemies = new ArrayList<>();
    private List<AbstractTower> towers = new ArrayList<>();
    private List<AbstractBullet> bullets = new ArrayList<>();

    //BUTTONS
    private Button nextWaveBtn;

    //OTHERS
    private boolean openingShop;
    private Shop shop;
    private boolean openingTowerModifier;
    private TowerModifier towerModifier;

    private Information info;

    public GameField(GameStage gameStage, Stack<State> states) {
        super(states);
        this.tiles = gameStage.getTiles();
        this.openingShop = false;
        this.openingTowerModifier = false;
        this.info = new Information(this);
        this.changingWave = true;

        initMouseEventHandlers();

        //FOR DEBUGS
//        this.towers.add(new MachineGunTower(Config.TILE_SIZE * 5, Config.TILE_SIZE * 5));
        this.enemies.add(new FastEnemy(Config.TILE_SIZE * 2, Config.TILE_SIZE * 14));
    }

    //SETTER AND GETTERS
    public void setChangingWave(boolean changingWave) {
        this.changingWave = changingWave;
    }

    public boolean isChangingWave() {
        return changingWave;
    }

    public List<AbstractEnemy> getEnemies() {
        return enemies;
    }

    public StackPane getStackPane() {
        return this.stackPane;
    }

    public List<AbstractTower> getTowers() {
        return towers;
    }

    public void setOpeningShop(boolean openingShop) {
        this.openingShop = openingShop;
    }

    public void setOpeningTowerModifier(boolean openingTowerModifier) {
        this.openingTowerModifier = openingTowerModifier;
    }

    //INITIALIZATION
    @Override
    protected void initStyleSheets() {
        scene.getStylesheets().add("file:src/States/GameState/GameField.css");
    }

    @Override
    protected void initBackground() { }

    @Override
    protected void initCanvas() {
        canvas = new Canvas(Config.GAME_FIELD_HORIZONTAL_LENGTH, Config.GAME_FIELD_VERTICAL_LENGTH);
        canvas.setFocusTraversable(true);
        graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setFontSmoothingType(FontSmoothingType.LCD);
    }

    @Override
    protected void initButtons() {
        initNextWaveBtn();
    }

    private void initNextWaveBtn() {
        nextWaveBtn = new Button();
        nextWaveBtn.setId("next-wave-btn");
        nextWaveBtn.setMinSize(123,57);
        nextWaveBtn.setTranslateX( Config.GAME_FIELD_HORIZONTAL_LENGTH - 150);
        nextWaveBtn.setOnAction(e -> {
            changingWave = false;
            nextWaveBtn.setVisible(false);
        });
        stackPane.getChildren().add(nextWaveBtn);
    }

    private void initMouseEventHandlers() {
        canvas.setOnMouseClicked(event -> {
            int column = (int)event.getSceneX() / Config.TILE_SIZE;
            int row = (int)event.getSceneY() / Config.TILE_SIZE;
            if (tiles[row][column] instanceof Mountain && !openingShop && !openingTowerModifier) {
                Mountain clickedMountain = (Mountain)tiles[row][column];
                if (!clickedMountain.isContainingTower()) openShop(column * Config.TILE_SIZE, row * Config.TILE_SIZE, clickedMountain);
                else openTowerModifier(column * Config.TILE_SIZE, row * Config.TILE_SIZE, clickedMountain);
            }
            else {
                closeShop();
                closeTowerModifier();
            }
        });
    }

    //UPDATE AND RENDERS
    public void win() {}

    private void updateEntities() {
        enemies.removeIf(element -> element.isDestroyed());
        bullets.removeIf(element -> element.isDestroyed());
        towers.removeIf(element -> element.isDestroyed());

        for (AbstractTile[] tile : tiles)
            for (int j = 0; j < tiles[0].length; j++)
                if (tile[j] instanceof Spawner)
                    tile[j].update(this);
        for (AbstractBullet element:bullets) element.update(enemies);
        for (AbstractEnemy element:enemies) element.update(tiles);
        for (AbstractTower element:towers) element.update(enemies, bullets);
    }

    private void updateInfo() {
        info.update();
    }

    private void openShop(double posX, double posY, Mountain clickedMountain) {
        shop = new Shop(posX, posY,this, clickedMountain);
        openingShop = true;
    }

    private void openTowerModifier(double posX, double posY, Mountain clickedMountain) {
        towerModifier = new TowerModifier(posX, posY,this, clickedMountain);
        openingTowerModifier = true;
    }

    private void closeShop() {
        stackPane.getChildren().remove(shop);
        openingShop = false;
    }

    private void closeTowerModifier() {
        stackPane.getChildren().remove(towerModifier);
        openingTowerModifier = false;
    }


    public void update() {
        if (isQuit()) states.pop();
        updateEntities();
        updateInfo();
    }

    public void render() {
        for (AbstractTile[] tile : tiles)
            for (int j = 0; j < tiles[0].length; j++)
                tile[j].render(graphicsContext);
        for (AbstractEnemy element:enemies) element.render(graphicsContext);
        for (AbstractTower element:towers) element.render(graphicsContext);
        for (AbstractBullet element:bullets) element.render(graphicsContext);
    }

}
