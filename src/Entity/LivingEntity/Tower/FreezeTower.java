package Entity.LivingEntity.Tower;

import Entity.LivingEntity.Bullet.AbstractBullet;
import Entity.LivingEntity.Bullet.FreezeBullet;
import Main.Assets;
import Main.Config;


public class FreezeTower extends AbstractTower{
    public FreezeTower(double posX, double posY) {
        super(posX, posY, Assets.freezeTower, Config.FREEZE_ATTACK_SPEED, Config.FREEZE_RANGE, Config.FREEZE_DAMAGE[1]);
    }

    @Override
    public void upgrade() {
        this.level++;
        this.damage = Config.FREEZE_DAMAGE[level];
    }

    @Override
    protected AbstractBullet getBullet(double posX, double posY, double x, double y) {
        return new FreezeBullet(posX, posY, this.damage, x, y);
    }
}
