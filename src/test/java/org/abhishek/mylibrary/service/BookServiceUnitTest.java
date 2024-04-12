package org.abhishek.mylibrary.service;

import org.abhishek.mylibrary.model.Book;
import org.abhishek.mylibrary.repository.BookRepository;
import org.abhishek.mylibrary.repository.BookRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * @author : Abhishek
 * @since : 2024-03-26, Tuesday
 **/
class BookServiceUnitTest {

    private BookRepository bookRepository;
    private BookService bookService;

    @BeforeEach
    void setUp() {
        bookRepository = mock(BookRepositoryImpl.class);
        bookService = new BookService(bookRepository);
    }

    @Test
    void findBookByBookNumber() {
        Book bookOne = new Book(1000L, "Core Java", 600, LocalDate.of(2024, 10, 20));
        when(bookRepository.findBookByBookNumber(1L)).thenReturn(Optional.of(bookOne));
        Book bookByBookNumber = bookService.getBookByBookNumber(1L);
        assertEquals("Core Java", bookByBookNumber.getBookName());
        verify(bookRepository).findBookByBookNumber(1L);
    }


}