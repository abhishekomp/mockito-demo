package org.abhishek.mylibrary.model;

import java.time.LocalDate;

/**
 * @author : Abhishek
 * @since : 2024-03-26, Tuesday
 **/
public class Book {
    private final long bookNumber;
    private final String bookName;
    private final int numOfPages;
    private final LocalDate purchaseDate;

    public Book(long bookNumber, String bookName, int numOfPages, LocalDate purchaseDate) {
        this.bookNumber = bookNumber;
        this.bookName = bookName;
        this.numOfPages = numOfPages;
        this.purchaseDate = purchaseDate;
    }

    public String getBookName() {
        return bookName;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public long getBookNumber() {
        return bookNumber;
    }
}
