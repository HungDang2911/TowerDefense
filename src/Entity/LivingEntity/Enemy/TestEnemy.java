package Entity.LivingEntity.Enemy;

import Entity.GameTile.Road;
import game.Assets;
import javafx.scene.image.Image;

public class TestEnemy extends AbstractEnemy {

    public TestEnemy(double posX, double posY, Road road) {
        super(posX, posY, 1, 1, Assets.enemy, 100, 0.05, 50, 50, road);
    }
}
