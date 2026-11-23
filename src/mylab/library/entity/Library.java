package mylab.library.entity;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private String name;
    private List<Book> books;

    public Library(String name) {
        this.name = name;
        books = new ArrayList<Book>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("도서가 추가되었습니다: " + book.getTitle());
    }

    public Book findByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    public List<Book> findByAuthor(String author) {
        List<Book> result = new ArrayList<Book>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public Book findByISBN(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public Book findBookByTitle(String title) {
        return findByTitle(title);
    }

    public List<Book> findBooksByAuthor(String author) {
        return findByAuthor(author);
    }

    public Book findBookByISBN(String isbn) {
        return findByISBN(isbn);
    }

    public boolean checkOutBook(String isbn) {
        Book book = findByISBN(isbn);
        if (book != null) {
            return book.checkOut();
        }
        return false;
    }

    public boolean returnBook(String isbn) {
        Book book = findByISBN(isbn);
        if (book != null && book.isAvailable() == false) {
            book.returnBook();
            return true;
        }
        return false;
    }

    public List<Book> getAvailableBooks() {
        List<Book> result = new ArrayList<Book>();
        for (Book book : books) {
            if (book.isAvailable()) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> getAllBooks() {
        return new ArrayList<Book>(books);
    }

    public int getTotalBooks() {
        return books.size();
    }

    public int getAvailableBooksCount() {
        return getAvailableBooks().size();
    }

    public int getBorrowedBooksCount() {
        return getTotalBooks() - getAvailableBooksCount();
    }
}
