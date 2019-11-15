package Entity.GameTile;

import game.Assets;

public class Road extends AbstractTile{
    public Road(double posX, double posY, int directionForEnemy) {
        super(posX, posY, Assets.road);
        this.directionForEnemy = directionForEnemy;
    }

}
