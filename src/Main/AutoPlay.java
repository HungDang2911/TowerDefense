package Main;

import Entity.GameTile.AbstractTile;
import Entity.GameTile.Mountain;
import Entity.LivingEntity.Tower.AbstractTower;
import Entity.LivingEntity.Tower.MachineGunTower;
import States.GameState.GameField;

public class AutoPlay {
    private static int ticks = 0;

    public static void update(GameField field) {
        if (ticks++ < 2) return;

        if (field.getNextWaveBtn().isVisible()) field.getNextWaveBtn().fire();

        for (AbstractTile[] tile : field.getTiles())
            for (int j = 0; j < field.getTiles()[0].length; j++) {
                if (tile[j] instanceof Mountain) {
                    Mountain mountain = (Mountain)tile[j];
                    if (mountain.isContainingTower() && Player.getMoney() >= mountain.getTower().getNextLevelPrice()) {
                        Player.decreaseMoney(mountain.getTower().getNextLevelPrice());
                        mountain.getTower().upgrade();
                    }
                    if (!mountain.isContainingTower() && Player.getMoney() >= Config.MACHINE_GUN_PRICE[1]) {
                        AbstractTower tower = new MachineGunTower(mountain.getPosX(), mountain.getPosY());
                        mountain.setTower(tower);
                        mountain.setContainingTower(true);
                        Player.decreaseMoney(Config.MACHINE_GUN_PRICE[1]);
                        field.getTowers().add(tower);
                    }
                }
            }

        ticks = 0;
    }
}
