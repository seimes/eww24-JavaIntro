package at.technikum.exercises.voexercises.battleshiplight;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BattleshipGame {
    private int points;
    private int size;
    private Board board;
    private boolean isGameOver;
    private final Scanner scanner;

    public BattleshipGame() {
        this.points = 0;
        this.size = 0;
        this.isGameOver = false;
        this.scanner = new Scanner(System.in);
        // TODO: refactor
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPoints() {
        return this.points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void start() {
        // TODO: ask player how big the game board should be
        this.setSize(this.readPlayerSize());
        this.board = new Board(this.getSize());

        // TODO: print board
        //while (!isGameOver) {
        this.board.print(); //or this.visualizer.visualize(this.board)

        // TODO: ask player for coordinates
        Point attackCoordinates = this.readPlayerAttackCoordinates();

        // TODO: change state accordingly

        // TODO: check score

        // TODO: do game loop until won

        // TODO: maybe ask if game should be started again or not
        //}
    }

    private int readPlayerSize() {
        System.out.print("Please enter a board size: ");
        return this.scanner.nextInt();
    }

    private Point readPlayerAttackCoordinates() {
        System.out.println("Please provide the coordinates to attack.");
        int x = readInteger("x");
        int y = readInteger("y");

        return new Point(x, y);
    }

    private int readInteger(String label) {
        int x = -1;

        do {
            try {
                if (x < 0) {
                    System.out.printf("%s: ", label);
                    x = scanner.nextInt();
                }
            } catch (InputMismatchException ime) {
                System.out.printf("Wrong input data type for %s!\n", label);
                this.scanner.nextLine();
            }
        } while (x < 0);

        return x;
    }
}
