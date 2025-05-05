package at.technikum.exercises.voexercises.library.items;

public class NewBook extends Book implements IRentable, IDonatable {
    private String isbn;

    public NewBook(String title, String author, String isbn, int year, boolean available) {
        super(title, author, year, available);
        this.isbn = isbn;
    }

    @Override
    public boolean isNeeded() {
        return false;
    }
}
