package Entity.GameTile;

import Main.Assets;
import States.GameState.GameField;

public class Target extends AbstractTile{
    public Target(double posX, double posY) {
        super(posX, posY, Assets.target);
    }

    @Override
    public void update(GameField field) {

    }
}
