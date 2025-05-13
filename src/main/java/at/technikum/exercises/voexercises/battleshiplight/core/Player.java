package at.technikum.exercises.voexercises.battleshiplight.core;

import at.technikum.exercises.voexercises.battleshiplight.consoleversion.board.Board;
import at.technikum.exercises.voexercises.battleshiplight.consoleversion.board.Field;
import at.technikum.exercises.voexercises.battleshiplight.interfaces.BoardLike;

public class Player {
    private String name;
    private BoardLike<? extends Field> board;
    private PlayerState playerState;

    public Player(String name) {
        this.name = name;
        this.playerState = new PlayerState();
    }

    public Player(String name, BoardLike<? extends Field> board) {
        this.name = name;
        this.board = board;
        this.playerState = new PlayerState();
    }

    public void setBoard(BoardLike<? extends Field> board) {
        this.board = board;
    }
    
    public BoardLike<? extends Field> getBoard() {
        return board;
    }

    public PlayerState getGameState() {
        return playerState;
    }

    public void setPlayerState(PlayerState playerState) {
        this.playerState = playerState;
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
