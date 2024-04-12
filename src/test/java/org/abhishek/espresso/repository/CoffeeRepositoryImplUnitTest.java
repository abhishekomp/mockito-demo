package org.abhishek.espresso.repository;

import org.abhishek.espresso.model.Coffee;
import org.abhishek.espresso.model.Strength;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author  : Abhishek
 * @since   : 2024-03-26, Tuesday
 **/
class CoffeeRepositoryImplUnitTest {

    private CoffeeRepository coffeeRepository;

    @BeforeEach
    void setUp() {
        coffeeRepository = new CoffeeRepositoryImpl();
    }

    @Test
    void findAll() {
        Coffee espresso = Coffee.builder().coffeeId(1).coffeeName("Espresso").coffeeStrength(Strength.LIGHT).price(3.9).introductionDate(LocalDate.of(2024, 01, 15)).build();
        Coffee macchiato = Coffee.builder().coffeeId(2).coffeeName("Macchiato").coffeeStrength(Strength.STRONG).price(4.9).introductionDate(LocalDate.of(2024, 02, 15)).build();
        assertIterableEquals(List.of(espresso, macchiato), coffeeRepository.findAll());
    }

    @Test
    void findById() {
        //Coffee macchiato = Coffee.builder().coffeeId(2).coffeeName("Macchiato").coffeeStrength(Strength.STRONG).price(4.9).introductionDate(LocalDate.of(2024, 02, 15)).build();
        Optional<Coffee> byId = coffeeRepository.findById(2);
        assertEquals("Macchiato", byId.get().getCoffeeName());
    }

    @Test
    void findByName() {
        Optional<Coffee> byId = coffeeRepository.findByName("Espresso");
        assertEquals("Espresso", byId.get().getCoffeeName());
    }

    @Test
    void findByStrength() {
        List<Coffee> byStrength = coffeeRepository.findByStrength(Strength.LIGHT);
        assertEquals(1, byStrength.size());
        assertEquals("Espresso", byStrength.get(0).getCoffeeName());
    }

    @Test
    void updatePrice() {
        Coffee espresso = Coffee.builder().coffeeId(1).coffeeName("Espresso").coffeeStrength(Strength.LIGHT).price(10.99).introductionDate(LocalDate.of(2024, 01, 15)).build();
        Optional<Coffee> updatedCoffee = coffeeRepository.updatePrice(1, 10.99);
        assertEquals(Optional.of(espresso), updatedCoffee);
    }

    @Test
    void updateCoffeeStrength() {
        Coffee expectedCoffee = Coffee.builder().coffeeId(1).coffeeName("Espresso").coffeeStrength(Strength.STRONG).price(3.9).introductionDate(LocalDate.of(2024, 01, 15)).build();
        Optional<Coffee> updatedCoffee = coffeeRepository.updateStrength(1, Strength.STRONG);
        assertEquals(Optional.of(expectedCoffee), updatedCoffee);
    }

    @Test
    void saveNewCoffee() {
        Coffee espressoNew = Coffee.builder().coffeeId(3).coffeeName("Espresso").coffeeStrength(Strength.LIGHT).price(1.9).introductionDate(LocalDate.of(2024, 01, 15)).build();
        Coffee coffee = coffeeRepository.saveNewCoffee(espressoNew);
        assertEquals(espressoNew, coffee);
    }

    @Test
    void deleteCoffee() {
        Coffee deletedMacchiato = Coffee.builder().coffeeId(2).coffeeName("Macchiato").coffeeStrength(Strength.STRONG).price(4.9).introductionDate(LocalDate.of(2024, 02, 15)).deactivationDate(LocalDate.now()).build();
        coffeeRepository.deactivateCoffee(2);
        assertEquals(Optional.of(deletedMacchiato), coffeeRepository.findById(2));
    }
}