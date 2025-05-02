package at.technikum.exercises.voexercises.battleshiplight;

public class Player {
    private String name;
    private Board board;
    private int score;

    public Player(String name, Board board) {
        this.name = name;
        this.board = board;
        this.score = 0;
    }

    public int getScore() {
        return score;
    }

    public void updateScore(int amount) {
        this.score += amount;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
