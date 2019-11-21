package States.GameState;

import Entity.GameTile.AbstractTile;
import Entity.GameTile.Mountain;
import Entity.GameTile.Road;
import Entity.LivingEntity.Bullet.AbstractBullet;
import Entity.LivingEntity.Enemy.AbstractEnemy;
import Entity.LivingEntity.Enemy.FastEnemy;
import Entity.LivingEntity.Tower.AbstractTower;
import Entity.LivingEntity.Tower.MachineGunTower;
import Main.Config;
import States.State;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GameField extends State{
    //ENTITES
    private AbstractTile[][] tiles;
    private List<AbstractEnemy> enemies = new ArrayList<>();
    private List<AbstractTower> towers = new ArrayList<>();
    private List<AbstractBullet> bullets = new ArrayList<>();

    //MOUSE
    private double mousePosX;
    private double mousePosY;

    //OTHERS
    private boolean openingShop;

    public GameField(GameStage gameStage, Stack<State> states) {
        super(states);

        this.tiles = gameStage.getTiles();
        this.openingShop = false;

        //FOR DEBUGS
        this.towers.add(new MachineGunTower(Config.TILE_SIZE * 5, Config.TILE_SIZE * 5));
        this.enemies.add(new FastEnemy(Config.TILE_SIZE * 2, Config.TILE_SIZE * 14));

    }

    @Override
    protected void initBackground() { }

    @Override
    protected void initButtons() {

    }

    private void updateEntities() {
        enemies.removeIf(element -> element.isDestroyed());
        bullets.removeIf(element -> element.isDestroyed());
        towers.removeIf(element -> element.isDestroyed());

        for (AbstractBullet element:bullets) element.update(enemies);
        for (AbstractEnemy element:enemies) element.update(tiles);
        for (AbstractTower element:towers) element.update(enemies, bullets);
    }

    private void updateMouseEvents() {
        stackPane.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mousePosX = event.getSceneX();
                mousePosY = event.getSceneY();
            }
        });

        stackPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                int column = (int)event.getSceneX() * Config.TILE_SIZE;
                int row = (int)event.getSceneY()/32;
                if (!openingShop && tiles[row][column] instanceof Mountain) {
                    Mountain clickedMountain = (Mountain)tiles[row][column];
                    if (!clickedMountain.isContainingTower()) openShop(column * Config.TILE_SIZE, row * Config.TILE_SIZE);
                }
            }
        });
    }

    private void openShop(double posX, double posY) {

    }


    public void update() {
        if (isQuit()) states.pop();
        updateMouseEvents();
        updateEntities();
    }

    public void render() {
        for (int i = 0; i < tiles.length; i++)
            for (int j = 0; j < tiles[0].length; j++)
                tiles[i][j].render(graphicsContext);
        for (AbstractEnemy element:enemies) element.render(graphicsContext);
        for (AbstractTower element:towers) element.render(graphicsContext);
        for (AbstractBullet element:bullets) element.render(graphicsContext);
    }

}
