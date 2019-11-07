package Entity;

import javafx.scene.canvas.GraphicsContext;

public interface GameEntity {
    public void update();
    public void render(GraphicsContext graphicsContext);

}
