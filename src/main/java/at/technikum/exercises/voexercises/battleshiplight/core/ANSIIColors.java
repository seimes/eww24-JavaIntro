package at.technikum.exercises.voexercises.battleshiplight;

public enum ANSIIColors {
    RESET ("\u001B[0m"),
    BLACK ("\u001B[30m"),
    GRAY ("\u001B[38;2;150;150;150m"),
    RED ("\u001B[31m"),
    GREEN ("\u001B[32m"),
    YELLOW ("\u001B[33m"),
    BLUE ("\u001B[34m"),
    PURPLE ("\u001B[35m"),
    CYAN ("\u001B[36m"),
    WHITE ("\u001B[37m");

    private final String name;

    ANSIIColors(String name) {
        this.name = name;
    }

    public boolean equalsName(String otherName) {
        // (otherName == null) check is not needed because name.equals(null) returns false
        return this.name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}
