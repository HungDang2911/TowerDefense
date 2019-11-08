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
    private final GraphicsContext graphicsContext;

    public GameField(GameStage gameStage, GraphicsContext graphicsContext) {
        this.tiles = List.copyOf(gameStage.getTiles());
        this.graphicsContext = graphicsContext;
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
