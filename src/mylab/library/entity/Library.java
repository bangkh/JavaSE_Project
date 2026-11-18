package mylab.library.entity;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private String name;
    private final List<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<Book>();
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public void addBook(Book book) {
        if (book == null) throw new IllegalArgumentException("도서가 없습니다.");
        books.add(book);
        System.out.println("도서가 추가되었습니다: " + book.getTitle());
    }

    public Book findByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) return book;
        }
        return null;
    }

    public List<Book> findByAuthor(String author) {
        List<Book> found = new ArrayList<Book>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) found.add(book);
        }
        return found;
    }

    public Book findByISBN(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) return book;
        }
        return null;
    }

    public Book findBookByTitle(String title) { return findByTitle(title); }
    public List<Book> findBooksByAuthor(String author) { return findByAuthor(author); }
    public Book findBookByISBN(String isbn) { return findByISBN(isbn); }

    public boolean checkOutBook(String isbn) {
        Book book = findByISBN(isbn);
        return book != null && book.checkOut();
    }

    public boolean returnBook(String isbn) {
        Book book = findByISBN(isbn);
        if (book == null || book.isAvailable()) return false;
        book.returnBook();
        return true;
    }

    public List<Book> getAvailableBooks() {
        List<Book> available = new ArrayList<Book>();
        for (Book book : books) {
            if (book.isAvailable()) available.add(book);
        }
        return available;
    }

    public List<Book> getAllBooks() { return new ArrayList<Book>(books); }
    public int getTotalBooks() { return books.size(); }
    public int getAvailableBooksCount() { return getAvailableBooks().size(); }
    public int getBorrowedBooksCount() { return books.size() - getAvailableBooksCount(); }
}
