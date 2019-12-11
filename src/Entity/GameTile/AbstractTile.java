package Entity.GameTile;

import Entity.AbstractEntity;
import States.GameState.GameField;

import java.io.IOException;

public abstract class AbstractTile extends AbstractEntity{
    int directionForEnemy;

    AbstractTile(double posX, double posY) {
        super(posX, posY);
    }

    public int getDirectionForEnemy() {
        return directionForEnemy;
    }

    public abstract void update(GameField field) throws IOException;
}
