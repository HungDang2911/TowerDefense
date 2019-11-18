package Entity.GameTile;

import Main.Assets;

public class Mountain extends AbstractTile{
    public Mountain(double posX, double posY) {
        super(posX, posY, Assets.mountain);
    }
}
