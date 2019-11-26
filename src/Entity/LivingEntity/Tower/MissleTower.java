package Entity.LivingEntity.Tower;

import Entity.LivingEntity.Bullet.AbstractBullet;
import Entity.LivingEntity.Bullet.MissleBullet;
import Main.Assets;
import Main.Config;

public class MissleTower extends AbstractTower{
    public MissleTower(double posX, double posY) {
        super(posX, posY, Assets.missleTower, Config.MISSLE_ATTACK_SPEED, Config.MISSLE_RANGE, Config.AIR_DAMAGE[1]);
    }

    @Override
    public void upgrade() {
        this.level++;
        if (this.level == 3) this.texture = Assets.missleTowerLv3;
        this.damage = Config.MISSLE_DAMAGE[level];
    }

    @Override
    protected AbstractBullet getBullet(double posX, double posY, double x, double y) {
        return new MissleBullet(posX, posY, this.damage, x, y);
    }
}
