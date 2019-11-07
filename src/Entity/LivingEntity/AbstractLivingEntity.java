package Entity.LivingEntity;

import Entity.AbstractEntity;

public abstract class AbstractLivingEntity extends AbstractEntity implements LivingEntity {
    protected boolean destroyed;

    protected AbstractLivingEntity(double posX, double posY, double width, double height) {
        super(posX, posY, width, height);
        this.destroyed = false;
    }

    public boolean isDestroyed() {
        return destroyed;
    }
}
