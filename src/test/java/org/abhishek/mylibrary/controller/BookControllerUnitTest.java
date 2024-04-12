package org.abhishek.mylibrary.controller;

import org.abhishek.mylibrary.exceptions.BookNotFoundException;
import org.abhishek.mylibrary.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

/**
 * @author  : Abhishek
 * @since   : 2024-03-26, Tuesday
 **/
class BookControllerUnitTest {
    private BookController bookController;
    private BookService bookService;

    @BeforeEach
    void setUp() {
        bookService = mock(BookService.class);
        bookController = new BookController(bookService);
    }

    @Test
    void getBookByBookNumber() {
        when(bookService.getBookByBookNumber(anyLong())).thenThrow(BookNotFoundException.class);
        assertThrows(BookNotFoundException.class, () -> bookController.getBookByBookNumber(2000L));
        //verify(bookService).getBookByBookNumber(anyLong());
        verify(bookService, times(1)).getBookByBookNumber(anyLong());
        verify(bookService, times(0)).getNumberOfPagesForBook(anyLong());
    }
}