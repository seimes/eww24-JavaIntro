package at.technikum.exercises.voexercises.battleshiplight;

import java.awt.*;
import java.util.Random;

public class Board {
    private Field[][] fields;
    private static final int scoreUpdate = 100;

    public Board(int size) {
        this.fields = new Field[size][size];
        this.init();
        this.placeRandomShips();
    }

    private void init() {
        for(int y=0; y < fields.length; y++) {
            for(int x=0; x<fields.length; x++) {
                this.fields[x][y] = new Field();
            }
        }
    }

    private void placeRandomShips() {
        for (int i = 0; i < this.fields.length; i++) {
            this.placeRandomShip();
        }
    }

    private void placeRandomShip() {
        int freeFieldsAmount = this.getFreeFieldsAmount();
        Field[] emptyFields = new Field[freeFieldsAmount];

        int i = 0;
        for(int y=0; y < fields.length; y++) {
            for(int x=0; x<fields.length; x++) {
                Field field = this.fields[x][y];

                if (field.getState() == State.NO_SHIP_NO_HIT) {
                    emptyFields[i++] = field;
                }
            }
        }

        Random random = new Random();
        int randomFieldNumber = random.nextInt(emptyFields.length);
        emptyFields[randomFieldNumber].placeShip();
    }

    private int getFreeFieldsAmount() {
        int freeFieldsCounter = 0;

        for(int y=0; y < this.fields.length; y++) {
            for(int x=0; x < this.fields.length; x++) {
                Field field = this.fields[x][y];

                if (field.getState() == State.NO_SHIP_NO_HIT) {
                    freeFieldsCounter++;
                }
            }
        }
        return freeFieldsCounter;
    }

    public void updateStateAndScore(Point fieldCoordinate, Player player) {
        Field field = this.getFields()[fieldCoordinate.x][fieldCoordinate.y];

        if (field.getState() == State.NO_SHIP_NO_HIT) {
            field.setState(State.NO_SHIP_HIT);
            return;
        }
        if (field.getState() == State.SHIP_NO_HIT) {
            field.setState(State.SHIP_HIT);
            player.updateScore(Board.scoreUpdate);
        }
    }

    public void print() {
        //this.printRepeatedChars('#', fields.length+2, true);
        System.out.print("   ");
        this.printNumbers(fields.length);
        System.out.println();

        for(int y=0; y < this.fields.length; y++) {
            System.out.print(y + " ");

            for (int x = 0; x < this.fields.length; x++) {
                if (fields[x][y].getState() == State.SHIP_NO_HIT)
                    System.out.print("⛵ ");
                else if(fields[x][y].getState() == State.SHIP_HIT)
                    System.out.print("☠\uFE0F ");
                else if(fields[x][y].getState() == State.NO_SHIP_HIT) {
                    System.out.print(ANSIIColors.GRAY + "~~ " + ANSIIColors.RESET);
                }
                else
                    //System.out.print("\uD83C\uDF0A");
                    System.out.print(ANSIIColors.BLUE + "~~ " + ANSIIColors.RESET);
            }
            System.out.println();
        }
        //this.printRepeatedChars('#', fields.length+2, false);
        System.out.println();
    }

    private void printRepeatedChars(char symbol, int amount, boolean trailingNewline) {
        for (int i = 0; i < amount; i++) {
            System.out.print(symbol);
        }

        if (trailingNewline) System.out.println();
    }

    private void printNumbers(int start, int end, int step) {
        for (int i = start; i < end; i+=step) {
            if(i == 0)
                System.out.printf("%d ", i);
            else
                System.out.printf(" %d ", i);
        }
    }

    private void printNumbers(int start, int end) {
        this.printNumbers(start, end, 1);
    }

    private void printNumbers(int end) {
        this.printNumbers(0, end);
    }

    public Field[][] getFields() {
        return fields;
    }

    public void setFields(Field[][] fields) {
        this.fields = fields;
    }

    public void resetBoard() {
        this.init();
        this.placeRandomShips();
    }
}
