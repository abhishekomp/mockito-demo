package org.abhishek.espresso.service;

import lombok.RequiredArgsConstructor;
import org.abhishek.espresso.exception.CoffeeNotFoundException;
import org.abhishek.espresso.exception.CoffeeNotSavedException;
import org.abhishek.espresso.model.Coffee;
import org.abhishek.espresso.model.Strength;
import org.abhishek.espresso.repository.CoffeeRepository;

import java.util.List;

/**
 * @author  : Abhishek
 * @since   : 2024-03-26, Tuesday
 **/
@RequiredArgsConstructor
public class CoffeeService {
    private final CoffeeRepository coffeeRepository;

    public List<Coffee> findAll(){
        return coffeeRepository.findAll();
    }

    public Coffee findById(int coffeeId){
        return coffeeRepository
                .findById(coffeeId)
                .orElseThrow(() -> new CoffeeNotFoundException(String.format("Coffee with id %d not found", coffeeId)));
    }

    public Coffee findByName(String coffeeName){
        return coffeeRepository
                .findByName(coffeeName)
                .orElseThrow(() -> new CoffeeNotFoundException(String.format("Coffee with name %s not found", coffeeName)));
    }

    public List<Coffee> findByStrength(Strength strength){
        return coffeeRepository
                .findByStrength(strength);
    }

    public Coffee updatePrice(int coffeeId, double newPrice){
        return coffeeRepository.updatePrice(coffeeId, newPrice)
                .orElseThrow(() -> new CoffeeNotFoundException(String.format("Coffee with id %d not found", coffeeId)));
    }

    public Coffee updateStrength(int coffeeId, Strength strength){
        return coffeeRepository.updateStrength(coffeeId, strength)
                .orElseThrow(() -> new CoffeeNotFoundException(String.format("Coffee with id %d not found", coffeeId)));
    }

    public Coffee saveNewCoffee(Coffee coffee) throws CoffeeNotSavedException {
        try{
            coffee.setCoffeeId(coffeeRepository.findAll().size());
            Coffee savedCoffee = coffeeRepository.saveNewCoffee(coffee);
            return savedCoffee;
        } catch(Exception ex){
            System.out.println("Exception while saving new coffee: " + ex.getMessage());
            throw new CoffeeNotSavedException("Exception while saving new coffee");
        }
    }
    public void deactivateCoffee(int coffeeId){
        Coffee coffeeObj = coffeeRepository.findById(coffeeId)
                .orElseThrow(() -> new CoffeeNotFoundException(String.format("Coffee with id %d not found", coffeeId)));
        coffeeRepository.deactivateCoffee(coffeeObj.getCoffeeId());
    }
}
