package org.abhishek.espresso.model;

import lombok.*;

import java.time.LocalDate;

/**
 * @author  : Abhishek
 * @since   : 2024-03-26, Tuesday
 **/
@Getter
//@Setter
@EqualsAndHashCode
@ToString
//@RequiredArgsConstructor
@Builder
//@Data
public class Coffee {
    private int coffeeId;
    private final String coffeeName;
    private Strength coffeeStrength;
    private double price;
    private final LocalDate introductionDate;
    private LocalDate deactivationDate;

    public void setPrice(double newPrice) {
        this.price = newPrice;
    }

    public void setCoffeeId(int coffeeId) {
        this.coffeeId = coffeeId;
    }

    public void setDeactivationDate(LocalDate deactivationDate) {
        this.deactivationDate = deactivationDate;
    }

    public void setStrength(Strength newStrength) {
        this.coffeeStrength = newStrength;
    }
}

