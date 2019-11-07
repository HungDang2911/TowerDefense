package game;

import Entity.GameTile.GameTile;
import Entity.GameTile.Mountain;
import Entity.LivingEntity.LivingEntity;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public class GameField {
    private List<GameTile> tiles = new ArrayList<>();
    private List<LivingEntity> livingEntities = new ArrayList<>();
    private int width;
    private int height;
    private final GraphicsContext graphicsContext;

    //FOR DEBUG
    public GameField(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
        this.tiles.add(new Mountain(10,10));
    }

    public GameField(GameStage gameStage, GraphicsContext graphicsContext) {
        this.tiles = List.copyOf(gameStage.getTiles());
        this.graphicsContext = graphicsContext;
        this.width = gameStage.width;
        this.height = gameStage.height;

    }

    public void update() {
        for (GameTile element:tiles) element.update();
        for (LivingEntity element:livingEntities) {
            if (element.isDestroyed())  livingEntities.remove(element);
            else element.update();
        }
    }

    public void render() {
        for (GameTile element:tiles) element.render(graphicsContext);
        for (LivingEntity element:livingEntities) element.render(graphicsContext);
    }

}
