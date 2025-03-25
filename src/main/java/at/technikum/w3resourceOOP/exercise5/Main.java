package at.technikum.w3resourceOOP.exercise5;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Title 1", "Author 1", "ISBN 1");
        Book book2 = new Book("Title 2", "Author 2", "ISBN 2");

        Book.addBook(book1);
        Book.addBook(book2);

        for (Book b : Book.getBooks()) {
            System.out.println("Title: " + b.getTitle() + ", author: " + b.getAuthor() + ", ISBN: " + b.getIsbn());
        }

        System.out.println();
        System.out.println("Remove book");

        Book.removeBook(book2);

        for (Book b : Book.getBooks()) {
            System.out.println("Title: " + b.getTitle() + ", author: " + b.getAuthor() + ", ISBN: " + b.getIsbn());
        }
    }
}
