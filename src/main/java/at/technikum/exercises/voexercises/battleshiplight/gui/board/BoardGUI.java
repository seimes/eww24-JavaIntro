package at.technikum.exercises.voexercises.battleshiplight.gui.board;

import at.technikum.exercises.voexercises.battleshiplight.consoleversion.board.Field;
import at.technikum.exercises.voexercises.battleshiplight.core.Player;
import at.technikum.exercises.voexercises.battleshiplight.core.State;
import at.technikum.exercises.voexercises.battleshiplight.interfaces.BoardLike;

import java.awt.*;
import java.util.Random;

public class BoardGUI implements BoardLike<FieldGUI> {
    private double cellSize;
    private int size;
    private FieldGUI[][] fields;

    public BoardGUI(int size, double cellSize, boolean isComputer) {
        this.size = size;
        this.cellSize = cellSize;
        this.fields = new FieldGUI[size][size];
        this.init();  // Initialize GUI components
        if (isComputer) this.placeRandomShips();  // Place ships via Board logic
    }

    protected void init() {
        // Initializes the GUI fields with their visual properties
        for (int y = 0; y < this.fields.length; y++) {
            for (int x = 0; x < this.fields.length; x++) {
                this.fields[y][x] = new FieldGUI(this.cellSize, new Point(50, 60), new Point(x, y));
            }
        }
    }

    // Reuses the Board's ship placement logic
    protected void placeRandomShips() {
        for (int i = 0; i < this.fields.length; i++) {
            this.placeRandomShip(); // Delegate to the logic board
        }
    }

    protected void placeRandomShip() {
        int freeFieldsAmount = this.getFreeFieldsAmount();
        FieldGUI[] emptyFields = new FieldGUI[freeFieldsAmount];

        int i = 0;
        for (int y = 0; y < fields.length; y++) {
            for (int x = 0; x < fields.length; x++) {
                FieldGUI field = this.fields[y][x];

                if (field.getState() == State.NO_SHIP_NO_HIT) {
                    emptyFields[i++] = field;
                }
            }
        }

        Random random = new Random();
        int randomFieldNumber = random.nextInt(emptyFields.length);
        emptyFields[randomFieldNumber].placeShip();
    }

    protected int getFreeFieldsAmount() {
        int freeFieldsCounter = 0;

        for (int y = 0; y < this.fields.length; y++) {
            for (int x = 0; x < this.fields.length; x++) {
                Field field = this.fields[y][x];

                if (field.getState() == State.NO_SHIP_NO_HIT) {
                    freeFieldsCounter++;
                }
            }
        }
        return freeFieldsCounter;
    }

    public double getCellSize() {
        return cellSize;
    }

    public void setCellSize(double cellSize) {
        this.cellSize = cellSize;
    }

    @Override
    public FieldGUI[][] getFields() {
        return fields;
    }

    @Override
    public int getSize() {
        return size;
    }

    public void updateStateAndScore(Point fieldCoordinate, Player player) {
        // TODO
    }
}
