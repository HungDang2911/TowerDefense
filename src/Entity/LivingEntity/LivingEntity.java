package Entity.LivingEntity;

import Entity.GameEntity;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public interface LivingEntity extends GameEntity {
    public <T> void update(T t);
    public void render(GraphicsContext graphicsContext);
    public boolean isDestroyed();
}
