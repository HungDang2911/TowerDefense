package Entity.LivingEntity.Enemy;

import Entity.GameTile.Road;
import Entity.LivingEntity.AbstractLivingEntity;
import game.Config;
import game.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.List;


public abstract class AbstractEnemy extends AbstractLivingEntity{
    private int hitPoint;
    private double speed;
    private int armor;
    private int reward;
    private Road prevRoad, currentRoad, nextRoad;


    public AbstractEnemy(double posX, double posY, double width, double height, Image texture, int hitPoint, double speed, int armor, int reward, Road road) {
        super(posX, posY, width, height, texture);
        this.hitPoint = hitPoint;
        this.armor = armor;
        this.reward = reward;
        this.speed = speed;
        this.currentRoad = road;
        this.nextRoad = road;
        this.prevRoad = road;
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
            double currentX = posX;
            double currentY = posY;
            posX = Math.floor(posX);
            posY = Math.floor(posY);

            System.out.println(posX +" " + posY);

            if (getDistance(road) == 32 && road != currentRoad && road != nextRoad && road != prevRoad) {
                if (currentRoad == nextRoad) nextRoad = road;
                else {
                    prevRoad = currentRoad;
                    currentRoad = nextRoad;
                    nextRoad = road;
                }
            }

            posX = currentX;
            posY = currentY;
        }
        move(nextRoad);
    }

    private void move(Road road) {
        System.out.println(getDistance(road));
        System.out.println(road.getPosX() + " " + road.getPosY());
        posX += (road.getPosX() - posX) * speed / getDistance(road);
        posY += (road.getPosX() - posY) * speed / getDistance(road);
        System.out.println(posX + " " + posY);
    }

    @Override
    public void render(GraphicsContext graphicsContext) {
        graphicsContext.drawImage(texture, posX, posY);
    }


}
