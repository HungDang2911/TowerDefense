package States.GameState;

import Entity.GameTile.AbstractTile;
import Entity.LivingEntity.Bullet.AbstractBullet;
import Entity.LivingEntity.Enemy.AbstractEnemy;
import Entity.LivingEntity.Enemy.FastEnemy;
import Entity.LivingEntity.Tower.AbstractTower;
import Entity.LivingEntity.Tower.MachineGunTower;
import Main.Config;
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
        this.towers.add(new MachineGunTower(Config.TILE_SIZE * 5, Config.TILE_SIZE * 5));
        this.enemies.add(new FastEnemy(Config.TILE_SIZE * 2, Config.TILE_SIZE * 14));

    }

    public void update() {
        enemies.removeIf(element -> element.isDestroyed());
        bullets.removeIf(element -> element.isDestroyed());
        towers.removeIf(element -> element.isDestroyed());

        for (AbstractBullet element:bullets) element.update(enemies);
        for (AbstractEnemy element:enemies) element.update(tiles);
        for (AbstractTower element:towers) element.update(enemies, bullets);

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
