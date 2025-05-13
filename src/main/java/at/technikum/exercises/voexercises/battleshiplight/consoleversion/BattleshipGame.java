package at.technikum.exercises.voexercises.battleshiplight;

import javafx.application.Application;
import javafx.stage.Stage;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BattleshipGame extends Application {
    protected int points;
    protected int size;
    protected Board board;
    protected boolean isGameOver;
    protected final Scanner scanner;
    protected ArrayList<Player> players;
    protected int maxScore;

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    public BattleshipGame() {
        this.points = 0;
        this.size = 0;
        this.isGameOver = false;
        this.scanner = new Scanner(System.in);
        this.players = new ArrayList<Player>();
        this.maxScore = this.size * 100;
        // TODO: refactor
    }

    @Override
    public void start(Stage stage) throws Exception {}

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
        this.initGame();

        boolean isTurnOfPlayer1 = true;
        int winningID = -1;

        // TODO: print board
        while (winningID < 0) {
            int playerID = isTurnOfPlayer1 ? 0 : 1;
            int attackingPlayerID = playerID == 0 ? 1 : 0;
            Player player = this.players.get(playerID);
            Player attackingPlayer = this.players.get(attackingPlayerID);

            System.out.println("\nTurn of player " + attackingPlayer.getName());
            System.out.printf("Board of player %s:\n", player.getName());
            ((Board) player.getBoard()).print(); //or this.visualizer.visualize(this.board)

            // TODO: ask player for coordinates
            Point attackCoordinates = this.readPlayerAttackCoordinates();

            // TODO: change state accordingly
            player.getBoard().updateStateAndScore(attackCoordinates, attackingPlayer);

            if (attackingPlayer.getScore() >= this.maxScore) {
                winningID = attackingPlayerID;
            }

            // TODO: do game loop until won
            System.out.printf("Board of player %s:\n", player.getName());
            ((Board) player.getBoard()).print();
            System.out.printf("Player %s Score: %d\n", attackingPlayer.getName(), attackingPlayer.getScore());
            // TODO: maybe ask if game should be started again or not
            isTurnOfPlayer1 = !isTurnOfPlayer1;

            if(winningID >= 0) {
                Player winningPlayer = this.players.get(winningID);
                System.out.println("\nGame Over!");
                System.out.printf("Player %s won!\n", winningPlayer.getName());
                System.out.printf("Final score of player %s: %d\n", winningPlayer.getName(), this.players.get(winningID).getScore());

                if (this.checkForRestart()) {
                    winningID = -1;
                    isTurnOfPlayer1 = true;
                    this.restartGame();
                } else {
                    break;
                }
            }
        }
    }

    protected boolean checkForRestart() {
        System.out.println("Should the game be restarted? y/n?");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();

        return answer.equalsIgnoreCase("Y");
    }

    protected void initGame() {
        this.setSize(this.readBoardSize());
        this.maxScore = this.getSize() * 100;
        //this.board = new Board(this.getSize());
        System.out.print("Player 1, please enter your name: ");
        Scanner scanner = new Scanner(System.in);
        String player1Name = scanner.nextLine();
        this.players.add(new Player(player1Name, new Board(this.getSize(), false)));
        System.out.print("Player 2, please enter your name: ");
        String player2Name = scanner.nextLine();
        this.players.add(new Player(player2Name, new Board(this.getSize(), true)));
    }

    protected void restartGame() {
        this.players = new ArrayList<Player>();
        this.initGame();
    }

    protected int readBoardSize() {
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

        while (x < 0) {
            System.out.printf("%s: ", label);
            //String input = scanner.nextLine();
            try {
                x = scanner.nextInt();
                if (x < 0) {
                    System.out.println("Please insert a non-negative number.");
                }
            } catch (NumberFormatException nfe) {
                System.out.printf("Wrong input data type for %s!\n", label);
                scanner.nextLine();
            }
        }
        return x;
    }
}
