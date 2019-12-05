package Entity.GameTile;

import Main.Assets;
import States.GameState.GameField;

public class Road extends AbstractTile{
    public Road(double posX, double posY, int directionForEnemy) {
        super(posX, posY, Assets.road);
        this.directionForEnemy = directionForEnemy;
    }

    @Override
    public void update(GameField field) {

    }
}
