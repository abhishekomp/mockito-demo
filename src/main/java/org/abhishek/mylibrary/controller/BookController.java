package org.abhishek.mylibrary.controller;

import org.abhishek.mylibrary.model.Book;
import org.abhishek.mylibrary.service.BookService;

/**
 * @author  : Abhishek
 * @since   : 2024-03-26, Tuesday
 **/
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    public Book getBookByBookNumber(long bookNumber){
        return bookService.getBookByBookNumber(bookNumber);
    }
}
