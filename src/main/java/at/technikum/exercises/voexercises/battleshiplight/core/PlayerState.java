package at.technikum.exercises.voexercises.battleshiplight.core;

public class PlayerState {
    private static final int SCORE_INCREMENT = 100;

    private boolean isBoardSubmitted;
    private int shipsPlaced;
    private int score;
    private boolean isComputerPlayer;
    private int turnCount;

    public PlayerState() {
        this.isBoardSubmitted = false;
        this.shipsPlaced = 0;
        this.score = 0;
        this.isComputerPlayer = false;
        this.turnCount = 1;
    }

    public int getTurnCount() {
        return turnCount;
    }

    public void setTurnCount(int turnCount) {
        this.turnCount = turnCount;
    }

    public void incrementTurnCount() {
        this.turnCount++;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void updateScore(int amount) {
        this.score += amount;
    }

    public void incrementScore() {
        this.updateScore(SCORE_INCREMENT);
    }

    public boolean isBoardSubmitted() {
        return isBoardSubmitted;
    }

    public void setBoardSubmitted(boolean boardSubmitted) {
        isBoardSubmitted = boardSubmitted;
    }

    public int getShipsPlaced() {
        return shipsPlaced;
    }

    public void setShipsPlaced(int shipsPlaced) {
        this.shipsPlaced = shipsPlaced;
    }

    public void incrementPlacedShips() {
        this.shipsPlaced++;
    }

    public void decrementPlacedShips() {
        this.shipsPlaced--;
    }

    public boolean isComputerPlayer() {
        return isComputerPlayer;
    }

    public void setComputerPlayer(boolean computerPlayer) {
        isComputerPlayer = computerPlayer;
    }
}
