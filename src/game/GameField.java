package game;

import Entity.GameTile.GameTile;
import Entity.LivingEntity.LivingEntity;
import Entity.AbstractEntity;
import Entity.GameEntity;

import java.util.ArrayList;
import java.util.List;

public class GameField {
    private List<GameTile> tiles = new ArrayList<>();
    private List<LivingEntity> livingEntities = new ArrayList<>();
    private int width;
    private int height;

    public GameField(GameStage gameStage) {
        this.tiles = List.copyOf(gameStage.getTiles());
        this.width = width;
        this.height = height;
    }

    public void update() {
        for (GameTile element:tiles) element.update();
        for (LivingEntity element:livingEntities) element.update();
    }

    public void render() {
        for (GameTile element:tiles) element.render();
        for (LivingEntity element:livingEntities) element.render();
    }

}
