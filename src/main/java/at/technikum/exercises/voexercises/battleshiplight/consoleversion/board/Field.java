package at.technikum.exercises.voexercises.battleshiplight;

public class Field {
    /*
    private boolean isHit;
    private boolean hasShip;
    */

    protected State state;

    public Field() {
        this.state = State.NO_SHIP_NO_HIT;
    }

    public void placeShip() {
        this.state = State.SHIP_NO_HIT;
    }

    public void handleHit() {
        if (this.state == State.NO_SHIP_NO_HIT) {
            this.state = State.NO_SHIP_HIT;
        }
        if (this.state == State.SHIP_NO_HIT) {
            this.state = State.SHIP_HIT;
        }
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
