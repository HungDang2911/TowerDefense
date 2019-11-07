package Entity.GameTile.Tower;

import Entity.AbstractEntity;
import Entity.GameTile.GameTile;
import javafx.scene.canvas.GraphicsContext;

public class AbstractTower extends AbstractEntity implements GameTile {

    protected AbstractTower(double posX, double posY, double width, double height) {
        super(posX, posY, width, height);
    }

    public void update() {

    }

    public void render(GraphicsContext graphicsContext) {

    }
}
