package Entity.GameTile;

import Main.Assets;
import States.GameState.GameField;

public class Grass extends AbstractTile {
    public Grass(double posX, double posY) {
        super(posX, posY, Assets.mountain);
    }

    @Override
    public void update(GameField field) {

    }
}
