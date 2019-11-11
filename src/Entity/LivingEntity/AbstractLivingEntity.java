package Entity.LivingEntity;

import Entity.AbstractEntity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public abstract class AbstractLivingEntity extends AbstractEntity implements LivingEntity {
    protected boolean destroyed;
    protected Image texture;

    protected AbstractLivingEntity(double posX, double posY, double width, double height, Image texture) {
        super(posX, posY, width, height);
        this.destroyed = false;
        this.texture = texture;
    }


    public boolean isDestroyed() {
        return destroyed;
    }

    protected <T extends AbstractEntity> double getDistance(T target) {
        return Math.sqrt(Math.pow(this.getPosX() - target.getPosX(), 2) + Math.pow(this.getPosX() - target.getPosX(), 2));
    }

    public void render(GraphicsContext graphicsContext) {
        graphicsContext.drawImage(texture, posX, posY);
    }
}
