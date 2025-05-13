package at.technikum.exercises.voexercises.battleshiplight.gui.board;

import at.technikum.exercises.voexercises.battleshiplight.consoleversion.board.Field;
import at.technikum.exercises.voexercises.battleshiplight.gui.AssetLoader;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.awt.*;

public class FieldGUI extends Field  {
    private Button button;
    private double size;
    private Point startCoordinate;
    private Point coordinate;
    private FieldGUI linkedTargetCell;

    public FieldGUI(double size, Point startCoordinate, Point coordinate) {
        super();
        this.size = size;
        this.startCoordinate = startCoordinate;
        this.coordinate = coordinate;
        this.button = new Button();
        this.initButton();
    }

    public FieldGUI(FieldGUI other) {
        this.state = other.state;
        this.size = other.size;
        this.startCoordinate = other.startCoordinate;
        this.coordinate = other.coordinate;
        this.button = other.button;
    }

    private void initButton() {
        this.button.setPrefSize(this.size, this.size);
        this.button.setMinSize(this.size, this.size);
        this.button.setMaxSize(this.size, this.size);
        this.button.setLayoutX(this.startCoordinate.getX() + this.coordinate.getX() * (this.size + 5));
        this.button.setLayoutY(this.startCoordinate.getY() + this.coordinate.getY() * (this.size + 5));
        this.button.setGraphic(AssetLoader.convertToImageView(AssetLoader.SEA_IMG, size - 10));
    }

    public FieldGUI getLinkedTargetCell() {
        return linkedTargetCell;
    }

    public void setLinkedTargetCell(FieldGUI linkedTargetCell) {
        this.linkedTargetCell = linkedTargetCell;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public Point getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Point coordinate) {
        this.coordinate = coordinate;
    }
}
