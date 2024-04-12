package org.abhishek.espresso.repository;

import org.abhishek.espresso.model.Coffee;
import org.abhishek.espresso.model.Strength;

import java.time.LocalDate;
import java.util.*;

import static java.util.stream.Collectors.toList;

/**
 * @author : Abhishek
 * @since : 2024-03-26, Tuesday
 **/
public class CoffeeRepositoryImpl implements CoffeeRepository{

    private List<Coffee> coffeeList;

    public CoffeeRepositoryImpl(){
        this.coffeeList = initializeCoffeeList();
    }
    private List<Coffee> initializeCoffeeList() {
        Coffee espresso = Coffee.builder().coffeeId(1).coffeeName("Espresso").coffeeStrength(Strength.LIGHT).price(3.9).introductionDate(LocalDate.of(2024, 01, 15)).build();
        Coffee macchiato = Coffee.builder().coffeeId(2).coffeeName("Macchiato").coffeeStrength(Strength.STRONG).price(4.9).introductionDate(LocalDate.of(2024, 02, 15)).build();
        return new ArrayList<>(Arrays.asList(espresso, macchiato));
    }

//    private Collection<Coffee> initializeCoffeeMap() {
//        Coffee espresso = Coffee.builder().coffeeId(1).coffeeName("Espresso").coffeeStrength(Strength.LIGHT).price(3.9).introductionDate(LocalDate.of(2024, 01, 15)).build();
//        Coffee macchiato = Coffee.builder().coffeeId(2).coffeeName("Macchiato").coffeeStrength(Strength.STRONG).price(4.9).introductionDate(LocalDate.of(2024, 02, 15)).build();
//
//        HashMap<Integer, Coffee> coffeeHashMap = new HashMap<>();
//        coffeeHashMap.put(espresso.getCoffeeId(), espresso);
//        coffeeHashMap.put(macchiato.getCoffeeId(), macchiato);
//        return coffeeHashMap.values();
//    }

    @Override
    public List<Coffee> findAll() {
        return coffeeList;
    }

    @Override
    public Optional<Coffee> findById(int coffeeId) {
        Optional<Coffee> optionalCoffee = coffeeList.stream().filter(coffee -> coffee.getCoffeeId() == coffeeId).findFirst();
        return optionalCoffee;
    }

    @Override
    public Optional<Coffee> findByName(String coffeeName) {
        Optional<Coffee> optionalCoffee = coffeeList.stream().filter(coffee -> coffee.getCoffeeName() == coffeeName).findFirst();
        return optionalCoffee;
    }

    @Override
    public List<Coffee> findByStrength(Strength strength) {
        return coffeeList.stream().filter(coffee -> coffee.getCoffeeStrength() == strength).collect(toList());
    }

    @Override
    public Optional<Coffee> updatePrice(int coffeeId, double newPrice) {
        coffeeList.stream().filter(coffee -> coffee.getCoffeeId() == coffeeId).forEach(coffee -> coffee.setPrice(newPrice));
        return findById(coffeeId);
    }

    @Override
    public Optional<Coffee> updateStrength(int coffeeId, Strength newStrength) {
        coffeeList.stream().filter(coffee -> coffee.getCoffeeId() == coffeeId).forEach(coffee -> coffee.setStrength(newStrength));
        return findById(coffeeId);
    }

    @Override
    public Coffee saveNewCoffee(Coffee coffee) {
        coffee.setCoffeeId(coffeeList.size());
        coffeeList.add(coffee);
        return coffee;
    }

    @Override
    public void deactivateCoffee(int coffeeId) {
        findById(coffeeId).ifPresent(coffee -> coffee.setDeactivationDate(LocalDate.now()));
        //coffeeList.stream().filter(coffee -> coffee.getCoffeeId() == coffeeId).forEach(coffee -> coffee.setDeactivationDate(LocalDate.now()));
    }
}
