package at.technikum.exercises.voexercises.battleshiplight.core;

public class PlayerState {
    private boolean isBoardSubmitted;
    private int shipsPlaced;
    private int score;
    private boolean isComputerPlayer;

    public PlayerState() {
        this.isBoardSubmitted = false;
        this.shipsPlaced = 0;
        this.score = 0;
        this.isComputerPlayer = false;
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
