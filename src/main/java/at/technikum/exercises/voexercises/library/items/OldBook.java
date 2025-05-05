package at.technikum.exercises.voexercises.library.items;

public class OldBook extends Book implements IDonatable {
    private int value;

    public OldBook(String title, String author, int year, int value, boolean available) {
        super(title, author, year, available);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean isNeeded() {
        return true;
    }
}
