package at.technikum.exercises.voexercises.battleshiplight;

import java.util.Random;

public class Board {
    private Field[][] fields;

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

        for(int y=0; y < fields.length; y++) {
            for(int x=0; x < fields.length; x++) {
                Field field = this.fields[x][y];

                if (field.getState() == State.NO_SHIP_NO_HIT) {
                    freeFieldsCounter++;
                }
            }
        }
        return freeFieldsCounter;
    }

    public void print() {
        this.printRepeatedChars('#', fields.length+2, true);

        for(int y=0; y < fields.length; y++) {
            System.out.print("#");
            for (int x = 0; x < fields.length; x++) {
                if (fields[x][y].getState() == State.SHIP_NO_HIT)
                    System.out.print("S");
                else if(fields[x][y].getState() == State.SHIP_HIT)
                    System.out.print("X");
                else
                    System.out.print(" ");
            }
            System.out.println("#");
        }
        this.printRepeatedChars('#', fields.length+2, false);
    }

    private void printRepeatedChars(char symbol, int amount, boolean trailingNewline) {
        for (int i = 0; i < amount; i++) {
            System.out.print(symbol);
        }

        if (trailingNewline) System.out.println();
    }
}
