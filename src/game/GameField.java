package game;

import Entity.GameTile.GameTile;
import Entity.GameTile.Mountain;
import Entity.GameTile.Road;
import Entity.LivingEntity.Bullet.AbstractBullet;
import Entity.LivingEntity.Enemy.AbstractEnemy;
import Entity.LivingEntity.Enemy.TestEnemy;
import Entity.LivingEntity.LivingEntity;
import Entity.LivingEntity.Tower.AbstractTower;
import Entity.LivingEntity.Tower.MachineGunTower;
import javafx.scene.canvas.GraphicsContext;


import java.util.ArrayList;
import java.util.List;

public class GameField {
    private List<GameTile> tiles;
    private List<Road> roads = new ArrayList<>();
    private List<AbstractEnemy> enemies = new ArrayList<>();
    private List<AbstractTower> towers = new ArrayList<>();
    private List<AbstractBullet> bullets = new ArrayList<>();
    //private List<List<Double>> coordinates = new ArrayList<>();
    public static double[][] cocoordinates = new double[6][2];
    private final GraphicsContext graphicsContext;

    public GameField(GameStage gameStage, GraphicsContext graphicsContext) {

        this.tiles = gameStage.getTiles();
        this.graphicsContext = graphicsContext;
        for (GameTile tile:tiles) if (tile instanceof Road) roads.add((Road)tile);
        this.enemies.add(new TestEnemy(Config.TILE_SIZE * 2, Config.TILE_SIZE * 15));

        cocoordinates[0][0] = Config.TILE_SIZE * 2;
        cocoordinates[0][1] = Config.TILE_SIZE * 3;
        cocoordinates[1][0] = Config.TILE_SIZE * 8;
        cocoordinates[1][1] = Config.TILE_SIZE * 3;
        cocoordinates[2][0] = Config.TILE_SIZE * 8;
        cocoordinates[2][1] = Config.TILE_SIZE * 14;
        cocoordinates[3][0] = Config.TILE_SIZE * 13;
        cocoordinates[3][1] = Config.TILE_SIZE * 14;
        cocoordinates[4][0] = Config.TILE_SIZE * 13;
        cocoordinates[4][1] = Config.TILE_SIZE * 1;
        cocoordinates[5][0] = Config.TILE_SIZE * 19;
        cocoordinates[5][1] = Config.TILE_SIZE * 1;

    }

    public void update() {
        for (AbstractEnemy element:enemies) element.update(cocoordinates);
    }

    public void render() {
        for (GameTile element:tiles) element.render(graphicsContext);
        for (AbstractEnemy element:enemies) element.render(graphicsContext);
        for (AbstractTower element:towers) element.render(graphicsContext);
        for (AbstractBullet element:bullets) element.render(graphicsContext);
    }

}
