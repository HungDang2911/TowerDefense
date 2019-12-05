package Entity.GameTile;

import Entity.AbstractEntity;
import States.GameState.GameField;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class AbstractTile extends AbstractEntity{
    private Image texture;
    int directionForEnemy;

    AbstractTile(double posX, double posY, Image texture) {
        super(posX, posY);
        this.texture = texture;
    }

    public int getDirectionForEnemy() {
        return directionForEnemy;
    }

    public abstract void update(GameField field);

    public void render(GraphicsContext graphicsContext) {
        graphicsContext.drawImage(texture, posX, posY);
    }
}
