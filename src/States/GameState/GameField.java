package States.GameState;

import Entity.GameTile.AbstractTile;
import Entity.GameTile.Mountain;
import Entity.GameTile.Spawner;
import Entity.LivingEntity.AbstractLivingEntity;
import Entity.LivingEntity.Bullet.AbstractBullet;
import Entity.LivingEntity.Enemy.AbstractEnemy;
import Entity.LivingEntity.Tower.AbstractTower;
import Main.*;
import States.LoseState;
import States.SettingsState;
import States.State;
import States.WinState;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.FontSmoothingType;

import java.io.IOException;
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
    private Button settingsBtn;
    private Button autoPlayBtn;

    //OTHERS
    private boolean openingShop;
    private Shop shop;
    private boolean openingTowerModifier;
    private TowerModifier towerModifier;
    private boolean autoPlaying;

    private Information info;

    public GameField(Stack<State> states) throws IOException {
        super(states);
        this.autoPlaying = false;
        this.openingShop = false;
        this.openingTowerModifier = false;
        this.info = new Information(this);
        autoPlaying = false;

        initMouseEventHandlers();
    }

    public GameField(GameStage gameStage, Stack<State> states) throws IOException {
        super(states);
        this.tiles = gameStage.getTiles();
        this.openingShop = false;
        this.openingTowerModifier = false;
        this.info = new Information(this);
        this.changingWave = true;
        this.autoPlaying = false;

        initWaves();
        initMouseEventHandlers();
    }

    private void initWaves() {
        this.changingWave = true;
        currentWave = 0;
    }

    //SETTER AND GETTERS


    public int getCurrentWave() {
        return currentWave;
    }

    public void setCurrentWave(int currentWave) {
        this.currentWave = currentWave;
    }

    public boolean isChangingWave() {
        return changingWave;
    }

    public void setChangingWave(boolean changingWave) {
        this.changingWave = changingWave;
    }

    public AbstractTile[][] getTiles() {
        return tiles;
    }

    public void setTiles(AbstractTile[][] tiles) {
        this.tiles = tiles;
    }

    public List<AbstractEnemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<AbstractEnemy> enemies) {
        this.enemies = enemies;
    }

    public List<AbstractTower> getTowers() {
        return towers;
    }

    public void setTowers(List<AbstractTower> towers) {
        this.towers = towers;
    }

    public List<AbstractBullet> getBullets() {
        return bullets;
    }

    public void setBullets(List<AbstractBullet> bullets) {
        this.bullets = bullets;
    }

    public Button getNextWaveBtn() {
        return nextWaveBtn;
    }


    void setOpeningShop(boolean openingShop) {
        this.openingShop = openingShop;
    }

    void setOpeningTowerModifier(boolean openingTowerModifier) {
        this.openingTowerModifier = openingTowerModifier;
    }

    StackPane getStackPane() {
        return this.stackPane;
    }

    //INITIALIZATION
    @Override
    protected void initStyleSheets() {
        scene.getStylesheets().add("file:src/States/GameState/GameField.css");
    }

    @Override
    protected void initBackground() {
        this.background = new ImageView(Assets.map1);
    }

    @Override
    protected void initCanvas() {
        canvas = new Canvas(Config.GAME_FIELD_HORIZONTAL_LENGTH, Config.GAME_FIELD_VERTICAL_LENGTH);
        canvas.setFocusTraversable(true);
        graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setFontSmoothingType(FontSmoothingType.LCD);
        stackPane.getChildren().add(canvas);
    }

    @Override
    protected void initButtons() {
        initNextWaveBtn();
        initSettingsBtn();
        initAutoPlayBtn();
    }

    private void initAutoPlayBtn() {
        autoPlayBtn = new Button("AutoPlay: Off");
        autoPlayBtn.setId("auto-play-btn");
        autoPlayBtn.setMinSize(126,57);
        autoPlayBtn.setTranslateX( Config.GAME_FIELD_HORIZONTAL_LENGTH - 380);
        autoPlayBtn.setOnAction(e -> {
            if (autoPlaying) {
                autoPlaying = false;
                autoPlayBtn.setText("AutoPlay: Off");
            }
            else {
                autoPlaying = true;
                autoPlayBtn.setText("AutoPlay: On");
            }
        });
        stackPane.getChildren().add(autoPlayBtn);
    }

    private void initNextWaveBtn() {
        nextWaveBtn = new Button();
        nextWaveBtn.setId("next-wave-btn");
        nextWaveBtn.setMinSize(123,57);
        nextWaveBtn.setTranslateX( Config.GAME_FIELD_HORIZONTAL_LENGTH - 230);
        nextWaveBtn.setOnAction(e -> {
            currentWave++;
            changingWave = false;
            nextWaveBtn.setVisible(false);
        });
        stackPane.getChildren().add(nextWaveBtn);
    }

    private void initSettingsBtn() {
        settingsBtn = new Button();
        settingsBtn.setId("settings-btn");
        settingsBtn.setMinSize(60,60);
        settingsBtn.setTranslateX( Config.GAME_FIELD_HORIZONTAL_LENGTH - 80);
        settingsBtn.setOnAction(e -> {
            try {
                this.states.push(new SettingsState(states));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        stackPane.getChildren().add(settingsBtn);
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
    public void win() throws IOException {
        states.pop();
        states.push(new WinState(states));
    }

    private void lose() throws IOException {
        states.pop();
        states.push(new LoseState(states));
    }

    private void updateEntities() throws IOException {
        if (Player.getLives() <= 0) lose();

        enemies.removeIf(AbstractLivingEntity::isDestroyed);
        bullets.removeIf(AbstractLivingEntity::isDestroyed);
        towers.removeIf(AbstractLivingEntity::isDestroyed);

        if (autoPlaying) AutoPlay.update(this);

        for (AbstractTile[] tile : tiles)
            for (int j = 0; j < tiles[0].length; j++)
                if (tile[j] instanceof Spawner)
                    tile[j].update(this);
        for (AbstractBullet element:bullets) element.update(enemies);
        for (AbstractEnemy element:enemies) element.update(tiles);
        for (AbstractTower element:towers) element.update(enemies, bullets);
    }

    private void updateInfo() {
        info.update(this);
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


    public void update() throws IOException {
        if (isQuit()) states.pop();
        updateEntities();
        updateInfo();
    }

    public void render() {
        graphicsContext.clearRect(0,0, Config.GAME_FIELD_HORIZONTAL_LENGTH, Config.GAME_FIELD_VERTICAL_LENGTH);
        for (AbstractEnemy element:enemies) element.render(graphicsContext);
        for (AbstractTower element:towers) element.render(graphicsContext);
        for (AbstractBullet element:bullets) element.render(graphicsContext);
    }

}
