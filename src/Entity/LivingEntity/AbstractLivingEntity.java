package Entity.LivingEntity;

import Entity.AbstractEntity;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;


public abstract class AbstractLivingEntity extends AbstractEntity{
    protected boolean destroyed;
    protected Image texture;
    protected double textureAngle;

    protected AbstractLivingEntity(double posX, double posY, Image texture) {
        super(posX, posY);
        this.destroyed = false;
        this.texture = texture;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    protected <T extends AbstractEntity> double getDistance(T target) {
        System.out.println(Math.sqrt((this.posX - target.getPosX()) * (this.posX - target.getPosX()) + (this.posY - target.getPosY()) * (this.posY - target.getPosY())));
        return Math.sqrt((this.posX - target.getPosX()) * (this.posX - target.getPosX()) + (this.posY - target.getPosY()) * (this.posY - target.getPosY()));
    }

    public void render(GraphicsContext graphicsContext) {
        ImageView iv = new ImageView(texture);
        iv.setRotate(textureAngle);
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        Image rotatedImage = iv.snapshot(params, null);
        graphicsContext.drawImage(rotatedImage, posX, posY);
    }
}
