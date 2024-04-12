package org.abhishek.mylibrary.repository;

import org.abhishek.mylibrary.model.Book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author  : Abhishek
 * @since   : 2024-03-26, Tuesday
 **/
public class BookRepositoryImpl implements BookRepository{

    private List<Book> books;

    public BookRepositoryImpl(){
        this.books = initializeBooks();
    }

    private static List<Book> initializeBooks() {
        Book bookOne = new Book(1000L, "Core Java", 600, LocalDate.of(2024, 10, 20));
        Book bookTwo = new Book(1001L, "Java Generics", 400, LocalDate.of(2024, 06, 30));
        List<Book> bookList = new ArrayList<>(Arrays.asList(bookOne, bookTwo));
        return bookList;
    }

    @Override
    public Optional<Book> findBookByBookNumber(long bookNumber) {
        return this.books.stream().filter(book -> book.getBookNumber() == bookNumber).findFirst();
    }
}
