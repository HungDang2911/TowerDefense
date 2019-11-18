package Entity.GameTile;

import Main.Assets;

public class Road extends AbstractTile{
    public Road(double posX, double posY, int directionForEnemy) {
        super(posX, posY, Assets.road);
        this.directionForEnemy = directionForEnemy;
    }

}
