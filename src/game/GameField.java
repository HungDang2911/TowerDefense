package game;

import Entity.GameTile.GameTile;
import Entity.GameTile.Mountain;
import Entity.GameTile.Road;
import Entity.LivingEntity.Bullet.AbstractBullet;
import Entity.LivingEntity.Enemy.AbstractEnemy;
import Entity.LivingEntity.LivingEntity;
import Entity.LivingEntity.Tower.AbstractTower;
import javafx.scene.canvas.GraphicsContext;


import java.util.ArrayList;
import java.util.List;

public class GameField {
    private List<GameTile> tiles;
    private List<Road> roads = new ArrayList<>();
    private List<AbstractEnemy> enemies = new ArrayList<>();
    private List<AbstractTower> towers = new ArrayList<>();
    private List<AbstractBullet> bullets = new ArrayList<>();

    private final GraphicsContext graphicsContext;

    public GameField(GameStage gameStage, GraphicsContext graphicsContext) {
        this.tiles = List.copyOf(gameStage.getTiles());
        this.graphicsContext = graphicsContext;
    }

    public void update() {
    }

    public void render() {
        for (GameTile element:tiles) element.render(graphicsContext);
        for (LivingEntity element:enemies) element.render(graphicsContext);
        for (LivingEntity element:towers) element.render(graphicsContext);
        for (LivingEntity element:bullets) element.render(graphicsContext);
    }

}
