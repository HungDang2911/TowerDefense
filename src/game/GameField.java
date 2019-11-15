package game;

import Entity.GameTile.AbstractTile;
import Entity.LivingEntity.Bullet.AbstractBullet;
import Entity.LivingEntity.Bullet.MachineGunBullet;
import Entity.LivingEntity.Enemy.AbstractEnemy;
import Entity.LivingEntity.Enemy.TestEnemy;
import Entity.LivingEntity.Tower.AbstractTower;
import Entity.LivingEntity.Tower.MachineGunTower;
import javafx.scene.canvas.GraphicsContext;


import java.util.ArrayList;
import java.util.List;

public class GameField {
    private AbstractTile[][] tiles;
    private List<AbstractEnemy> enemies = new ArrayList<>();
    private List<AbstractTower> towers = new ArrayList<>();
    private List<AbstractBullet> bullets = new ArrayList<>();
    private final GraphicsContext graphicsContext;

    public GameField(GameStage gameStage, GraphicsContext graphicsContext) {

        this.tiles = gameStage.getTiles();
        this.graphicsContext = graphicsContext;

        //FOR DEBUGS
        this.enemies.add(new TestEnemy(Config.TILE_SIZE * 2, Config.TILE_SIZE * 14));
//        this.bullets.add(new MachineGunBullet(0,0, 0.11, 0.11));
    }

    public void update() {
        enemies.removeIf(element -> element.isDestroyed());
        bullets.removeIf(element -> element.isDestroyed());
        towers.removeIf(element -> element.isDestroyed());

        for (AbstractEnemy element:enemies) element.update(tiles);
        for (AbstractBullet element:bullets) element.update(enemies);
//        for (AbstractTower element:towers) element.update(enemies);
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
