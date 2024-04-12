package org.abhishek.espresso.exception;

/**
 * @author : Abhishek
 * @since : 2024-03-26, Tuesday
 **/
public class CoffeeNotFoundException extends RuntimeException {
    public CoffeeNotFoundException(String msg) {
        super(msg);
    }
}
