package Entity.GameTile;

import Entity.LivingEntity.Tower.AbstractTower;
import Main.Assets;

public class Mountain extends AbstractTile{
    private boolean isContainingTower;
    private AbstractTower tower;

    public Mountain(double posX, double posY) {
        super(posX, posY, Assets.mountain);
    }

    public boolean isContainingTower() {
        return isContainingTower;
    }

    public void setContainingTower(boolean containingTower) {
        isContainingTower = containingTower;
    }

    public void setTower(AbstractTower tower) {
        this.tower = tower;
    }

    public AbstractTower getTower() {
        return tower;
    }
}
