package Entity.GameTile;

import game.Assets;
import javafx.scene.canvas.GraphicsContext;

public class Mountain extends AbstractTile implements GameTile{
    public Mountain(double posX, double posY) {
        super(posX, posY, Assets.mountain);
    }
}
