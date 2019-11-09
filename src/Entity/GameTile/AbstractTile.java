package Entity.GameTile;

import Entity.AbstractEntity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class AbstractTile extends AbstractEntity implements GameTile{
    protected Image texture;

    protected AbstractTile(double posX, double posY, Image texture) {
        super(posX, posY, 1, 1);
        this.texture = texture;
    }

    @Override
    public void render(GraphicsContext graphicsContext) {
        graphicsContext.drawImage(texture, posX, posY);
    }
}
