package Entity.GameTile;

import States.GameState.GameField;

public class Road extends AbstractTile{
    public Road(double posX, double posY, int directionForEnemy) {
        super(posX, posY);
        this.directionForEnemy = directionForEnemy;
    }

    @Override
    public void update(GameField field) {

    }
}
