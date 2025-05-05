package at.technikum.exercises.voexercises.library;

import at.technikum.exercises.voexercises.library.items.*;

public class Main {
    public static void main(String[] args) {
        Book book1 = new NewBook("1984", "George Orwell", "alkjdsf",1949, true);
        book1.print();
        CD cd1 = new CD("In Place Apart", "Killing The Dream", 10, 2005, true);
        cd1.print();

        Library library = new Library();
        library.rent((IRentable) book1);
        library.rent(cd1);

        EReader eReader = new EReader("Kindle", "Amazon", true);
        library.rent(eReader);

        OldBook oldBook = new OldBook("Bibel", "Gutenberg", 1440, 100, false);
        //library.rent(oldBook);
    }
}
