package Entity.LivingEntity.Enemy;

import Entity.GameTile.AbstractTile;
import Entity.LivingEntity.AbstractLivingEntity;
import game.Config;
import game.Player;
import javafx.scene.image.Image;

public abstract class AbstractEnemy extends AbstractLivingEntity {
    private int hitPoint;
    private double speed;
    private int armor;
    private int reward;
    private AbstractTile nextRoad;

    public AbstractEnemy(double posX, double posY, Image texture, int hitPoint, double speed, int armor, int reward) {
        super(posX, posY, 1, 1, texture);
        this.hitPoint = hitPoint;
        this.armor = armor;
        this.reward = reward;
        this.speed = speed;
    }


    public void onHit(int damage) {
        this.hitPoint -= (damage - this.armor);
        if (this.hitPoint <= 0) {
            destroyed = true;
            Player.addMoney(this.reward);
        }
    }

    public void update(AbstractTile[][] tiles) {
        int currentColumn = (int)(posX / Config.TILE_SIZE);
        int currentRow = (int)(posY / Config.TILE_SIZE);

        if (getDistance(tiles[currentRow][currentColumn]) == 0) {
            if (tiles[currentRow][currentColumn].getDirectionForEnemy() == 1) nextRoad = tiles[currentRow - 1][currentColumn];
            else if (tiles[currentRow][currentColumn].getDirectionForEnemy() == 2) nextRoad = tiles[currentRow][currentColumn + 1];
            else if (tiles[currentRow][currentColumn].getDirectionForEnemy() == 3) nextRoad = tiles[currentRow + 1][currentColumn];
            else if (tiles[currentRow][currentColumn].getDirectionForEnemy() == 4) nextRoad = tiles[currentRow][currentColumn - 1];
        }
        move(nextRoad);
    }

    private void move(AbstractTile target) {
        double distance = getDistance(target);
        if (getDistance(target) < speed) {
            posX = target.getPosX();
            posY = target.getPosY();
        }
        else {
            posX += (target.getPosX() - posX) * speed / distance;
            posY += (target.getPosY() - posY) * speed / distance;
        }
    }
}