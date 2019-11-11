package Entity.LivingEntity.Enemy;

import Entity.GameTile.Road;
import Entity.LivingEntity.AbstractLivingEntity;
import game.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.List;


public abstract class AbstractEnemy extends AbstractLivingEntity{
    private int hitPoint;
    private double speed;
    private int armor;
    private int reward;
    private Road prevRoad;


    public AbstractEnemy(double posX, double posY, double width, double height, Image texture, int hitPoint, double speed, int armor, int reward) {
        super(posX, posY, width, height, texture);
        this.hitPoint = hitPoint;
        this.armor = armor;
        this.reward = reward;
        this.speed = speed;
    }


    public void onHit(int damage){
        this.hitPoint -= (damage - this.armor);
        if (this.hitPoint < 0) {
            destroyed = true;
            Player.addMoney(this.reward);
        }
    }

    public void update(List<Road> roads) {
        for (Road road:roads) {
            if (getDistance(road))
        }
    }

    private void move(Road road) {
        this.posX += (road.getPosX()
    }

    @Override
    public void render(GraphicsContext graphicsContext) {

    }


}
