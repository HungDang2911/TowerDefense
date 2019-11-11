package Entity.GameTile.Spawner;

import Entity.AbstractEntity;
import Entity.GameTile.GameTile;
import javafx.scene.canvas.GraphicsContext;

public class AbstractSpawner extends AbstractEntity implements GameTile{
    protected AbstractSpawner(double posX, double posY, double width, double height) {
        super(posX, posY, width, height);
    }

    public void update() {

    }

    @Override
    public void render(GraphicsContext graphicsContext) {

    }
}
