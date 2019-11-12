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
    private int count;

    public AbstractEnemy(double posX, double posY, double width, double height, Image texture, int hitPoint, double speed, int armor, int reward) {
        super(posX, posY, width, height, texture);
        this.hitPoint = hitPoint;
        this.armor = armor;
        this.reward = reward;
        this.speed = speed;
        this.count = 0;

    }


    public void onHit(int damage){
        this.hitPoint -= (damage - this.armor);
        if (this.hitPoint < 0) {
            destroyed = true;
            Player.addMoney(this.reward);
        }
    }

    public void update(double[][] a) {
//        for (Road road:roads) {
//            if (getDistance(road) <= (Config.TILE_SIZE + 1) && road != prevRoad && road != currentRoad) {
//                this.move(road);
//            }
//
//            if (getDistance(road) < 1) {
//                this.prevRoad = currentRoad;
//                currentRoad = road;
//           }
//        }
                int i = this.count;
                double distance = Math.sqrt(Math.pow(this.getPosX() - a[i][0], 2) + Math.pow(this.getPosY() - a[i][1], 2));
                this.move(a[i][0], a[i][1]);
                if (distance < 2) this.count ++;
    }

    public void move(double tX, double tY) {
        double distance = Math.sqrt(Math.pow(this.getPosX() - tX,2) + Math.pow(this.getPosY() - tY, 2));
        System.out.println(distance);
        posX += (tX - posX) * speed / distance;
        posY += (tY - posY) * speed / distance;
        System.out.println(posX + " " + posY);
        System.out.println(tX + " " + tY);
    }

    @Override
    public void render(GraphicsContext graphicsContext) {
        graphicsContext.drawImage(texture, posX, posY);
    }


}
