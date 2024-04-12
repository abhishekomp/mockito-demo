package org.abhishek.mylibrary.service;

import org.abhishek.mylibrary.exceptions.BookNotFoundException;
import org.abhishek.mylibrary.model.Book;
import org.abhishek.mylibrary.repository.BookRepository;

import java.util.Optional;

/**
 * @author : Abhishek
 * @since : 2024-03-26, Tuesday
 **/
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book getBookByBookNumber(long bookNumber){
        Optional<Book> book = bookRepository.findBookByBookNumber(bookNumber);
        return book.orElseThrow(() -> new BookNotFoundException(String.format("Book with book number %d not found", bookNumber)));
    }

    public long getNumberOfPagesForBook(long bookNumber){
        return 0L;
    }
}
