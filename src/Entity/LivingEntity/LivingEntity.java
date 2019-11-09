package Entity.LivingEntity;

import Entity.GameEntity;

import java.util.List;

public interface LivingEntity <E> extends GameEntity {
    public boolean isDestroyed();
}
