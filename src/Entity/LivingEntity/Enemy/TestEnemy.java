package Entity.LivingEntity.Enemy;

import Entity.GameTile.Road;
import game.Assets;
import javafx.scene.image.Image;

public class TestEnemy extends AbstractEnemy {

    public TestEnemy(double posX, double posY) {
        super(posX, posY, 1, 1, Assets.enemy, 100, 1, 50, 50);
    }
}
