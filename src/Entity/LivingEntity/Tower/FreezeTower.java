package Entity.LivingEntity.Tower;

import Entity.LivingEntity.Bullet.AbstractBullet;
import Entity.LivingEntity.Bullet.FreezeBullet;
import Main.Assets;
import Main.Config;


public class FreezeTower extends AbstractTower{
    public FreezeTower(double posX, double posY) {
        super(posX, posY, Assets.freezeTower, Config.FREEZE_ATTACK_SPEED, Config.FREEZE_RANGE[1], Config.FREEZE_DAMAGE[1]);
    }

    @Override
    public int getPrice() {
        return Config.FREEZE_PRICE[this.level];
    }

    @Override
    public int getNextLevelPrice() {
        return Config.FREEZE_PRICE[this.level + 1];
    }

    @Override
    public double getNextLevelRange() {
        return Config.FREEZE_RANGE[this.level + 1];
    }

    @Override
    public void upgrade() {
        this.level++;
        this.damage = Config.FREEZE_DAMAGE[level];
        this.range = Config.FREEZE_RANGE[level];
    }

    @Override
    protected AbstractBullet getBullet(double posX, double posY, double x, double y) {
        return new FreezeBullet(posX, posY, this.damage, x, y);
    }
}
