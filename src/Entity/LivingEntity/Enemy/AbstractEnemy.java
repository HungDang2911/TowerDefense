package Entity.LivingEntity.Enemy;

import Entity.GameTile.AbstractTile;
import Entity.GameTile.Road;
import Entity.LivingEntity.AbstractLivingEntity;
import game.Player;
import javafx.scene.image.Image;

public abstract class AbstractEnemy extends AbstractLivingEntity {
    private int hitPoint;
    private double speed;
    private int armor;
    private int reward;
    private AbstractTile nextRoad;

    public AbstractEnemy(double posX, double posY, double width, double height, Image texture, int hitPoint, double speed, int armor, int reward) {
        super(posX, posY, width, height, texture);
        this.hitPoint = hitPoint;
        this.armor = armor;
        this.reward = reward;
        this.speed = speed;
    }


    public void onHit(int damage) {
        this.hitPoint -= (damage - this.armor);
        if (this.hitPoint < 0) {
            destroyed = true;
            Player.addMoney(this.reward);
        }
    }

    public void update(AbstractTile[][] tiles) {
        int currentColumn = (int)(posX / 32);
        int currentRow = (int)(posY / 32);

        if (getDistance(tiles[currentRow][currentColumn]) < speed) {
            if (tiles[currentRow][currentColumn].getDirectionForEnemy() == 1) nextRoad = tiles[currentRow - 1][currentColumn];
            else if (tiles[currentRow][currentColumn].getDirectionForEnemy() == 2) nextRoad = tiles[currentRow][currentColumn + 1];
            else if (tiles[currentRow][currentColumn].getDirectionForEnemy() == 3) nextRoad = tiles[currentRow + 1][currentColumn];
            else if (tiles[currentRow][currentColumn].getDirectionForEnemy() == 4) nextRoad = tiles[currentRow][currentColumn - 1];
        }
        move(nextRoad);
    }

    private void move(AbstractTile target) {
        double distance = getDistance(target);
        posX += (target.getPosX() - posX) * speed / distance;
        posY += (target.getPosY() - posY) * speed / distance;
    }

}