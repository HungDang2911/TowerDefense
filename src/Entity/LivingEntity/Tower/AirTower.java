package Entity.LivingEntity.Tower;

import Entity.LivingEntity.Bullet.AbstractBullet;
import Entity.LivingEntity.Bullet.AirBullet;
import Main.Assets;
import Main.Config;


public class AirTower extends AbstractTower{
    public AirTower(double posX, double posY) {
        super(posX, posY, Assets.airTower, Config.AIR_ATTACK_SPEED, Config.AIR_RANGE[1], Config.AIR_DAMAGE[1]);
    }

    @Override
    public int getPrice() {
        return Config.AIR_PRICE[this.level];
    }

    @Override
    public int getNextLevelPrice() {
        return Config.AIR_PRICE[this.level + 1];
    }

    @Override
    public double getNextLevelRange() {
        return Config.AIR_RANGE[this.level + 1];
    }

    @Override
    public void upgrade() {
        this.level++;
        this.damage = Config.AIR_DAMAGE[level];
        this.range = Config.AIR_RANGE[level];
    }

    @Override
    protected AbstractBullet getBullet(double posX, double posY, double x, double y) {
        return new AirBullet(posX, posY, this.damage, x, y);
    }
}
