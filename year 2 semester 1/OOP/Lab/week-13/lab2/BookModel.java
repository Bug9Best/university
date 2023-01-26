package lab2;

import java.util.*;

public class BookModel {
    private Book book = new Book("", 0, "");
    private ArrayList books = new ArrayList();

    public BookModel() {
        books.add(this.book);
    }

    public void addBook(Book book) {
        if (!books.contains(book)) {
            books.add(book);
        }
    }

    public ArrayList getBooks() {
        return books;
    }

    public void setBooks(ArrayList books) {
        this.books = books;
    }

}
