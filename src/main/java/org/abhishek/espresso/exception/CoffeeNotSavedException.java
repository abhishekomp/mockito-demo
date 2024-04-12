package org.abhishek.espresso.exception;

/**
 * @author : Abhishek
 * @since : 2024-03-27, Wednesday
 **/
public class CoffeeNotSavedException extends RuntimeException {
    public CoffeeNotSavedException(String msg) {
        super(msg);
    }
}
