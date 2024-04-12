package org.abhishek.mylibrary.exceptions;

/**
 * @author : Abhishek
 * @since : 2024-03-26, Tuesday
 **/
public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(String msg) {
        super(msg);
    }
}
