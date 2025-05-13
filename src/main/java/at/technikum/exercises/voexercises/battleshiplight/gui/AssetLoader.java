package at.technikum.exercises.voexercises.battleshiplight.gui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class AssetLoader {
    private static final String imagesPath = "/images/";
    public static Image SEA_IMG = load(imagesPath + "sea.png");
    public static Image SHIP_IMG = load(imagesPath + "battleship_green.png");
    public static Image MISS_IMG = load(imagesPath + "red_x.png");
    public static Image HIT_IMG = load(imagesPath + "checkmark.png");
    public static Image ATTACK_IMG = load(imagesPath + "bomb.png");

    private static Image load(String path) {
        return new Image(Objects.requireNonNull(AssetLoader.class.getResource(path)).toString());
    }

    public static ImageView convertToImageView(Image image, double size) {
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(size);
        imageView.setFitWidth(size);

        return imageView;
    }
}
