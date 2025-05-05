package at.technikum.exercises.voexercises.library;

import at.technikum.exercises.voexercises.library.items.Book;
import at.technikum.exercises.voexercises.library.items.CD;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("1984", "George Orwell", 1949, true);
        book1.print();
        CD cd1 = new CD("In Place Apart", "Killing The Dream", 10, 2005, true);
        cd1.print();

        Library library = new Library();
        library.rent(book1);
        library.rent(cd1);

    }
}
