package game;

import Entity.GameTile.GameTile;
import Entity.GameTile.Mountain;
import Entity.GameTile.Road;
import Entity.LivingEntity.Bullet.AbstractBullet;
import Entity.LivingEntity.Enemy.AbstractEnemy;
import Entity.LivingEntity.Enemy.TestEnemy;
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
        this.tiles = gameStage.getTiles();
        this.graphicsContext = graphicsContext;
        for (GameTile tile:tiles) if (tile instanceof Road) roads.add((Road)tile);
        this.enemies.add(new TestEnemy(32, 0, roads.get(0)));


//        enemies.get(0).move(roads.get(0));
//        System.out.println(roads.get(0).getPosX() + " " + roads.get(0).getPosY());
    }

    public void update() {
        for (AbstractEnemy element:enemies) element.update(roads);
    }

    public void render() {
        for (GameTile element:tiles) element.render(graphicsContext);
        for (AbstractEnemy element:enemies) element.render(graphicsContext);
        for (AbstractTower element:towers) element.render(graphicsContext);
        for (AbstractBullet element:bullets) element.render(graphicsContext);
    }

}
