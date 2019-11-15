package Entity.GameTile.Spawner;

import Entity.AbstractEntity;
import Entity.GameTile.AbstractTile;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class AbstractSpawner extends AbstractTile{


    protected AbstractSpawner(double posX, double posY, Image texture) {
        super(posX, posY, texture);
    }

    public void update() {

    }

    @Override
    public void render(GraphicsContext graphicsContext) {

    }
}
