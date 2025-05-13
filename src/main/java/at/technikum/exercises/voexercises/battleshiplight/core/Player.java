package at.technikum.exercises.voexercises.battleshiplight;

import at.technikum.exercises.voexercises.battleshiplight.interfaces.BoardLike;

public class Player {
    private String name;
    private BoardLike<? extends Field> board;
    private int score;

    public Player() {}

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public Player(String name, BoardLike<? extends Field> board) {
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

    public BoardLike<? extends Field> getBoard() {
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
