package at.technikum.w3resourceOOP.exercise5;

import java.util.ArrayList;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private static ArrayList<Book> books;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        books = new ArrayList<Book>();
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public static ArrayList<Book> getBooks() {
        return books;
    }

    public static void addBook(Book book) {
        books.add(book);
    }

    public static void removeBook(Book book) {
        books.remove(book);
    }
}
