package game;

import javafx.scene.image.Image;

public class Assets {
    public static Image mountain, road, target;
    public static void init() {
        mountain = new Image("file:resource/textures/Tiles/Mountain.png");
        road = new Image("file:resource/textures/Tiles/Road.png");
    }
}
