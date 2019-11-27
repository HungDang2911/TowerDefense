package Entity.LivingEntity.Tower;

import Entity.LivingEntity.Bullet.AbstractBullet;
import Entity.LivingEntity.Bullet.MachineGunBullet;
import Main.Assets;
import Main.Config;

public class MachineGunTower extends AbstractTower{
    public MachineGunTower(double posX, double posY) {
        super(posX, posY, Assets.machineGunTower, Config.MACHINE_GUN_ATTACK_SPEED, Config.MACHINE_GUN_RANGE[1], Config.MACHINE_GUN_DAMAGE[1]);
    }

    @Override
    public int getPrice() {
        return Config.MACHINE_GUN_PRICE[this.level];
    }

    @Override
    public int getNextLevelPrice() {
        return Config.MACHINE_GUN_PRICE[this.level + 1];
    }

    @Override
    public void upgrade() {
        this.level++;
        if (this.level == 3) this.texture = Assets.machineGunTowerLv3;
        this.damage = Config.MACHINE_GUN_DAMAGE[level];
        this.range = Config.MACHINE_GUN_RANGE[level];
    }

    @Override
    public AbstractBullet getBullet(double posX, double posY, double x, double y) {
        return new MachineGunBullet(posX, posY, this.damage, x, y);
    }

}
