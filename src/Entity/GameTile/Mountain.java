package Entity.GameTile;

import Main.Assets;

public class Mountain extends AbstractTile{
    private boolean isContainingTower;

    public Mountain(double posX, double posY) {
        super(posX, posY, Assets.mountain);
    }

    public boolean isContainingTower() {
        return isContainingTower;
    }

    public void setContainingTower(boolean containingTower) {
        isContainingTower = containingTower;
    }
}
