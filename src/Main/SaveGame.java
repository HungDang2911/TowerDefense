package Main;

import Entity.GameTile.*;
import Entity.LivingEntity.Bullet.*;
import Entity.LivingEntity.Enemy.*;
import Entity.LivingEntity.Tower.*;
import States.GameState.GameField;
import States.State;
import com.google.gson.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SaveGame {
    private static final String FILE_PATH = "resource/SaveGame/save.json";

    private static Gson gson = new GsonBuilder().create();

    public static void save(GameField field) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH));

        JsonObject result = new JsonObject();

        result.addProperty("lives", Player.getLives());
        result.addProperty("money", Player.getMoney());

        result.addProperty("changingWave", field.isChangingWave());
        result.addProperty("currentWave", field.getCurrentWave());

        result.add("Tiles", convertTilesToJson(field.getTiles()));
        result.add("Enemies", convertEnemiesToJson(field.getEnemies()));
        result.add("Towers", convertTowersToJson(field.getTowers()));
        result.add("Bullets", convertBulletsToJson(field.getBullets()));

        gson.toJson(result, bw);
        bw.flush();
        bw.close();
    }

    public static GameField load(Stack<State> states) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));

        String JsonString = br.readLine();

        JSONObject fieldJson = new JSONObject(JsonString);

        GameField field = new GameField(states);

        List<AbstractTower> towers = loadTowers(fieldJson.getJSONArray("Towers"));
        List<AbstractBullet> bullets = loadBullets(fieldJson.getJSONArray("Bullets"));
        AbstractTile[][] tiles = loadTiles(fieldJson.getJSONArray("Tiles"), field.getTowers());

        Player.setLives(fieldJson.getInt("lives"));
        Player.setMoney(fieldJson.getInt("money"));
        field.setCurrentWave(fieldJson.getInt("currentWave"));
        field.setChangingWave(fieldJson.getBoolean("changingWave"));
        field.setTowers(towers);
        field.setTiles(tiles);
        field.setBullets(bullets);
        field.setEnemies(loadEnemies(fieldJson.getJSONArray("Enemies"), tiles));

        br.close();

        return field;
    }

    private static AbstractTile[][] loadTiles(JSONArray tilesJson, List<AbstractTower> towers) {
        AbstractTile[][] tiles = new AbstractTile[15][20];

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 20; j++) {
                JSONObject tileJson = tilesJson.getJSONObject(i*20 + j);

                String type = tileJson.getString("type");
                if (type.equals("Grass")) tiles[i][j] = new Grass(j * Config.TILE_SIZE, i * Config.TILE_SIZE);
                if (type.equals("Target")) tiles[i][j] = new Target(j * Config.TILE_SIZE, i * Config.TILE_SIZE);
                if (type.equals("Road")) {
                    int directionForEnemy = tileJson.getInt("directionForEnemy");
                    tiles[i][j] = new Road(j * Config.TILE_SIZE, i * Config.TILE_SIZE, directionForEnemy);
                }
                if (type.equals("Mountain")) {
                    Mountain mountain = new Mountain(j * Config.TILE_SIZE, i * Config.TILE_SIZE);
                    boolean isContainingTower = tileJson.getBoolean("isContainingTower");
                    mountain.setContainingTower(isContainingTower);
                    if (isContainingTower) {
                        for (AbstractTower tower:towers) {
                            if (tower.getPosX() == j * Config.TILE_SIZE && tower.getPosY() == i * Config.TILE_SIZE) mountain.setTower(tower);
                        }
                    }
                    tiles[i][j] = mountain;
                }
                if (type.equals("Spawner")) {
                    List<AbstractEnemy> incomingWaveEnemies = loadEnemies(tileJson.getJSONArray("incomingWaveEnemies"), null);
                    int directionForEnemy = tileJson.getInt("directionForEnemy");

                    JSONArray allEnemiesJson = tileJson.getJSONArray("allEnemies");
                    List<List<AbstractEnemy>> allEnemies = new ArrayList<>();

                    for (int idx = 0; i < allEnemiesJson.length(); i++) {
                        List<AbstractEnemy> waveEnemies = loadEnemies(allEnemiesJson.getJSONArray(idx), null);
                        allEnemies.add(waveEnemies);
                    }

                    Spawner spawner = new Spawner(j * Config.TILE_SIZE, i * Config.TILE_SIZE, directionForEnemy, allEnemies);
                    spawner.setIncomingWaveEnemies(incomingWaveEnemies);
                    tiles[i][j] = spawner;
                }
            }
        }

        return tiles;
    }

    private static List<AbstractEnemy> loadEnemies(JSONArray enemiesJson, AbstractTile[][] tiles) {
        List<AbstractEnemy> enemies = new ArrayList<>();

        for (int i = 0; i < enemiesJson.length(); i++) {
            JSONObject enemyJson = enemiesJson.getJSONObject(i);

            AbstractEnemy enemy = null;

            double PosX = enemyJson.getDouble("PosX");
            double PosY = enemyJson.getDouble("PosY");
            int hitPoints = enemyJson.getInt("hitPoints");
            double speed = enemyJson.getDouble("speed");
            String type = enemyJson.getString("type");
            if (type.equals("BossEnemy")) enemy = new BossEnemy(PosX, PosY);
            if (type.equals("NormalEnemy")) enemy = new NormalEnemy(PosX, PosY);
            if (type.equals("TankerEnemy")) enemy = new TankerEnemy(PosX, PosY);
            if (type.equals("FastEnemy")) enemy = new FastEnemy(PosX, PosY);
            if (tiles != null) {
                double nextRoadPosX = enemyJson.getDouble("nextRoadPosX");
                double nextRoadPosY = enemyJson.getDouble("nextRoadPosY");
                for (int j = 0; j < 15; j++) {
                    for (int k = 0; k < 20; k++) {
                        if (tiles[j][k].getPosX() == nextRoadPosX && tiles[j][k].getPosY() == nextRoadPosY) {
                            enemy.setNextRoad(tiles[j][k]);
                        }
                    }
                }
            }
            enemy.setHitPoints(hitPoints);
            enemy.setSpeed(speed);
            enemies.add(enemy);
        }

        return enemies;
    }

    private static List<AbstractTower> loadTowers(JSONArray towersJson) {
        List<AbstractTower> towers = new ArrayList<>();

        for (int i = 0; i < towersJson.length(); i++) {
            JSONObject towerJson = towersJson.getJSONObject(i);

            AbstractTower tower = null;

            double PosX = towerJson.getDouble("PosX");
            double PosY = towerJson.getDouble("PosY");

            int damage = towerJson.getInt("damage");
            int attackSpeed = towerJson.getInt("attackSpeed");
            int level = towerJson.getInt("level");
            double range = towerJson.getDouble("range");
            int ticks = towerJson.getInt("ticks");

            String type = towerJson.getString("type");
            if (type.equals("AirTower")) tower = new AirTower(PosX, PosY);
            if (type.equals("FreezeTower")) tower = new FreezeTower(PosX, PosY);
            if (type.equals("MachineGunTower")) tower = new MachineGunTower(PosX, PosY);
            if (type.equals("MissleTower")) tower = new MissleTower(PosX, PosY);
            tower.setDamage(damage);
            tower.setTicks(ticks);
            tower.setLevel(level);
            tower.setAttackSpeed(attackSpeed);
            tower.setRange(range);

            towers.add(tower);
        }

        return towers;
    }

    private static List<AbstractBullet> loadBullets(JSONArray bulletsJson) {
        List<AbstractBullet> bullets = new ArrayList<>();

        for (int i = 0; i < bulletsJson.length(); i++) {
            JSONObject bulletJson = bulletsJson.getJSONObject(i);

            AbstractBullet bullet = null;

            double PosX = bulletJson.getDouble("PosX");
            double PosY = bulletJson.getDouble("PosY");

            int damage = bulletJson.getInt("damage");
            double deltaX = bulletJson.getDouble("deltaX");
            double deltaY = bulletJson.getDouble("deltaY");

            String type = bulletJson.getString("type");
            if (type.equals("AirBullet")) bullet = new AirBullet(PosX, PosY, damage, deltaX, deltaY);
            if (type.equals("FreezeBullet")) bullet = new FreezeBullet(PosX, PosY, damage, deltaX, deltaY);
            if (type.equals("MachineGunBullet")) bullet = new MachineGunBullet(PosX, PosY, damage, deltaX, deltaY);
            if (type.equals("MissleBullet")) bullet = new MissleBullet(PosX, PosY, damage, deltaX, deltaY);

            bullets.add(bullet);
        }

        return bullets;
    }

    private static JsonArray convertTilesToJson(AbstractTile[][] tiles) {
        JsonArray tilesJson = new JsonArray();
        for (AbstractTile[] tile : tiles)
            for (int j = 0; j < tiles[0].length; j++)
            {
                JsonObject tileJson = new JsonObject();
                if (tile[j] instanceof Grass) tileJson.addProperty("type", "Grass");
                if (tile[j] instanceof Target) tileJson.addProperty("type", "Target");
                if (tile[j] instanceof Mountain) {
                    Mountain mountain = (Mountain)tile[j];
                    tileJson.addProperty("type", "Mountain");
                    tileJson.addProperty("isContainingTower", mountain.isContainingTower());
                }
                if (tile[j] instanceof Road) {
                    tileJson.addProperty("type", "Road");
                    tileJson.addProperty("directionForEnemy", tile[j].getDirectionForEnemy());
                }
                if (tile[j] instanceof Spawner) {
                    Spawner spawner = (Spawner)tile[j];
                    tileJson.addProperty("type", "Spawner");
                    tileJson.addProperty("ticks", spawner.getTicks());
                    tileJson.addProperty("directionForEnemy", spawner.getDirectionForEnemy());
                    tileJson.add("incomingWaveEnemies", convertEnemiesToJson(spawner.getIncomingWaveEnemies()));

                    JsonArray allEnemiesJson = new JsonArray();

                    for (int i = 0; i < spawner.getAllEnemies().size(); i++) allEnemiesJson.add(convertEnemiesToJson(spawner.getAllEnemies().get(i)));
                    tileJson.add("allEnemies", allEnemiesJson);
                }

                tilesJson.add(tileJson);
            }
        return tilesJson;
    }

    private static JsonArray convertEnemiesToJson(List<AbstractEnemy> enemyList) {
        JsonArray enemiesJson = new JsonArray();
        for (AbstractEnemy enemy:enemyList) {
            JsonObject enemyJson = new JsonObject();
            if (enemy instanceof BossEnemy) enemyJson.addProperty("type", "BossEnemy");
            if (enemy instanceof FastEnemy) enemyJson.addProperty("type", "FastEnemy");
            if (enemy instanceof NormalEnemy) enemyJson.addProperty("type", "NormalEnemy");
            if (enemy instanceof TankerEnemy) enemyJson.addProperty("type", "TankerEnemy");
            enemyJson.addProperty("PosX", enemy.getPosX());
            enemyJson.addProperty("PosY", enemy.getPosY());
            enemyJson.addProperty("hitPoints", enemy.getHitPoints());
            enemyJson.addProperty("speed", enemy.getSpeed());
            if (enemy.getNextRoad() != null) {
                enemyJson.addProperty("nextRoadPosX", enemy.getNextRoad().getPosX());
                enemyJson.addProperty("nextRoadPosY", enemy.getNextRoad().getPosY());
            }
            enemiesJson.add(enemyJson);
        }
        return enemiesJson;
    }

    private static JsonArray convertTowersToJson(List<AbstractTower> towerList) {
        JsonArray towersJson = new JsonArray();
        for (AbstractTower tower:towerList) {
            JsonObject towerJson = new JsonObject();
            if (tower instanceof AirTower) towerJson.addProperty("type", "AirTower");
            if (tower instanceof FreezeTower) towerJson.addProperty("type", "FreezeTower");
            if (tower instanceof MachineGunTower) towerJson.addProperty("type", "MachineGunTower");
            if (tower instanceof MissleTower) towerJson.addProperty("type", "MissleTower");
            towerJson.addProperty("PosX", tower.getPosX());
            towerJson.addProperty("PosY", tower.getPosY());
            towerJson.addProperty("attackSpeed", tower.getAttackSpeed());
            towerJson.addProperty("level", tower.getLevel());
            towerJson.addProperty("range", tower.getRange());
            towerJson.addProperty("damage", tower.getDamage());
            towerJson.addProperty("ticks", tower.getTicks());
            towersJson.add(towerJson);
        }
        return towersJson;
    }

    private static JsonArray convertBulletsToJson(List<AbstractBullet> bulletList) {
        JsonArray bulletsJson = new JsonArray();
        for (AbstractBullet bullet:bulletList) {
            JsonObject bulletJson = new JsonObject();
            if (bullet instanceof AirBullet) bulletJson.addProperty("type", "AirBullet");
            if (bullet instanceof FreezeBullet) bulletJson.addProperty("type", "FreezeBullet");
            if (bullet instanceof MachineGunBullet) bulletJson.addProperty("type", "MachineGunBullet");
            if (bullet instanceof MissleBullet) bulletJson.addProperty("type", "MissleBullet");
            bulletJson.addProperty("PosX", bullet.getPosX());
            bulletJson.addProperty("PosY", bullet.getPosY());
            bulletJson.addProperty("damage", bullet.getDamage());
            bulletJson.addProperty("deltaX", bullet.getDeltaX());
            bulletJson.addProperty("deltaY", bullet.getDeltaY());
            bulletsJson.add(bulletJson);
        }
        return bulletsJson;
    }
}
