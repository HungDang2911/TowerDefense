package Entity.GameTile;

import game.Assets;
import javafx.scene.canvas.GraphicsContext;

public class Mountain extends AbstractTile implements GameTile{
    public Mountain(double posX, double posY) {
        super(posX, posY, Assets.mountain);
    }

    @Override
    public double getPosX() {
        return 0;
    }

    @Override
    public double getPosY() {
        return 0;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(GraphicsContext graphicsContext) {

    }
}
