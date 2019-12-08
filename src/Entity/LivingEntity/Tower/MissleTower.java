package Entity.LivingEntity.Tower;

import Entity.LivingEntity.Bullet.AbstractBullet;
import Entity.LivingEntity.Bullet.MissleBullet;
import Main.Assets;
import Main.Config;

public class MissleTower extends AbstractTower{
    public MissleTower(double posX, double posY) {
        super(posX, posY, Assets.missleTower, Config.MISSLE_ATTACK_SPEED, Config.MISSLE_RANGE[1], Config.AIR_DAMAGE[1]);
    }

    @Override
    public int getPrice() {
        return Config.MISSLE_PRICE[this.level];
    }

    @Override
    public int getNextLevelPrice() {
        return Config.MISSLE_PRICE[this.level + 1];
    }

    @Override
    public double getNextLevelRange() {
        return Config.MISSLE_RANGE[this.level + 1];
    }

    @Override
    public void upgrade() {
        this.level++;
        if (this.level == 3) this.texture = Assets.missleTowerLv3;
        this.damage = Config.MISSLE_DAMAGE[level];
        this.range = Config.MISSLE_RANGE[level];
    }

    @Override
    protected void playShotSound() {
        Assets.missleShot.play();
    }

    @Override
    protected AbstractBullet getBullet(double posX, double posY, double x, double y) {
        return new MissleBullet(posX, posY, this.damage, x, y);
    }
}
