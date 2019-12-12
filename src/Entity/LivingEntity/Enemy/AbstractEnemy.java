package Entity.LivingEntity.Enemy;

import Entity.GameTile.AbstractTile;
import Entity.GameTile.Target;
import Entity.LivingEntity.AbstractLivingEntity;
import Main.Config;
import Main.Player;
import javafx.scene.image.Image;

public abstract class AbstractEnemy extends AbstractLivingEntity {
    private int hitPoints;
    private double speed;
    private int armor;
    private int reward;
    private AbstractTile nextRoad;

    public AbstractEnemy(double posX, double posY, Image texture, int hitPoints, double speed, int armor, int reward) {
        super(posX, posY, texture);
        this.hitPoints = hitPoints;
        this.armor = armor;
        this.reward = reward;
        this.speed = speed;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public AbstractTile getNextRoad() {
        return nextRoad;
    }

    public void setNextRoad(AbstractTile nextRoad) {
        this.nextRoad = nextRoad;
    }

    public void onHit(int damage) {
        this.hitPoints -= (damage - this.armor);
        if (this.hitPoints <= 0) {
            destroyed = true;
            Player.increaseMoney(this.reward);
        }
    }

    private boolean isOnTarget(AbstractTile tile) {
        return posX == tile.getPosX() && posY == tile.getPosY() && tile instanceof Target;
    }

    public void update(AbstractTile[][] tiles) {
        int currentColumn = (int)(posX / Config.TILE_SIZE);
        int currentRow = (int)(posY / Config.TILE_SIZE);

        if (getDistance(tiles[currentRow][currentColumn]) == 0) {
            if (tiles[currentRow][currentColumn].getDirectionForEnemy() == 1) {
                textureAngle = -90;
                nextRoad = tiles[currentRow - 1][currentColumn];
            }
            else if (tiles[currentRow][currentColumn].getDirectionForEnemy() == 2) {
                textureAngle = 0;
                nextRoad = tiles[currentRow][currentColumn + 1];
            }
            else if (tiles[currentRow][currentColumn].getDirectionForEnemy() == 3) {
                textureAngle = 90;
                nextRoad = tiles[currentRow + 1][currentColumn];
            }
            else if (tiles[currentRow][currentColumn].getDirectionForEnemy() == 4) {
                textureAngle = 180;
                nextRoad = tiles[currentRow][currentColumn - 1];
            }
        }

        move(nextRoad);

        if (isOnTarget(tiles[(int)(posY / Config.TILE_SIZE)][(int)(posX / Config.TILE_SIZE)])) {
            Player.decreaseLife();
            this.destroyed = true;
        }
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