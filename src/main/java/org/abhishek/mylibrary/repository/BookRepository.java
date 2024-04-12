package org.abhishek.mylibrary.repository;

import org.abhishek.mylibrary.model.Book;

import java.util.Optional;

/**
 * @author : Abhishek
 * @since : 2024-03-26, Tuesday
 **/
public interface BookRepository {
    Optional<Book> findBookByBookNumber(long bookNumber);
}
