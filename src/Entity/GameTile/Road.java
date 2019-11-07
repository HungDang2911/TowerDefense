package Entity.GameTile;

import game.Assets;
import javafx.scene.canvas.GraphicsContext;

public class Road extends AbstractTile implements GameTile{
    public Road(double posX, double posY) {
        super(posX, posY, Assets.road);
    }

    public double getPosX() {
        return 0;
    }

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
