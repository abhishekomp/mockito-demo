package org.abhishek.espresso.repository;

import org.abhishek.espresso.model.Coffee;
import org.abhishek.espresso.model.Strength;

import java.util.List;
import java.util.Optional;

/**
 * @author : Abhishek
 * @since : 2024-03-26, Tuesday
 **/
public interface CoffeeRepository {

    List<Coffee> findAll();
    Optional<Coffee> findById(int coffeeId);
    Optional<Coffee> findByName(String coffeeName);
    List<Coffee> findByStrength(Strength strength);

    Optional<Coffee> updatePrice(int coffeeId, double newPrice);
    Optional<Coffee> updateStrength(int coffeeId, Strength newStrength);


    Coffee saveNewCoffee(Coffee coffee);

    void deactivateCoffee(int coffeeId);
}
