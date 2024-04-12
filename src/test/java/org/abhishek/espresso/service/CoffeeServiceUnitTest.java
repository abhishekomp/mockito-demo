package org.abhishek.espresso.service;

import org.abhishek.espresso.exception.CoffeeNotFoundException;
import org.abhishek.espresso.exception.CoffeeNotSavedException;
import org.abhishek.espresso.model.Coffee;
import org.abhishek.espresso.model.Strength;
import org.abhishek.espresso.repository.CoffeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * @author : Abhishek
 * @since : 2024-03-26, Tuesday
 **/
@ExtendWith(MockitoExtension.class)
class CoffeeServiceUnitTest {

    @Mock
    private CoffeeRepository coffeeRepository;
    @InjectMocks
    private CoffeeService coffeeService;

//    @BeforeEach
//    void setUp() {
//
//    }

    @Test
    void findAll() {
        Coffee espresso = Coffee.builder().coffeeId(1).coffeeName("Espresso").coffeeStrength(Strength.LIGHT).price(3.9).introductionDate(LocalDate.of(2024, 01, 15)).build();
        Coffee macchiato = Coffee.builder().coffeeId(2).coffeeName("Macchiato").coffeeStrength(Strength.STRONG).price(4.9).introductionDate(LocalDate.of(2024, 02, 15)).build();
        List<Coffee> expectedList = List.of(espresso, macchiato);
        when(coffeeRepository.findAll()).thenReturn(List.of(espresso, macchiato));
        List<Coffee> coffees = coffeeService.findAll();
        assertIterableEquals(expectedList, coffees);
        verify(coffeeRepository, times(1)).findAll();
    }

    @Test
    void findById() {
        Coffee espresso = Coffee.builder().coffeeId(1).coffeeName("Espresso").coffeeStrength(Strength.LIGHT).price(3.9).introductionDate(LocalDate.of(2024, 01, 15)).build();
        when(coffeeRepository.findById(anyInt())).thenReturn(Optional.of(espresso));
        Coffee byId = coffeeService.findById(1);
        assertEquals(espresso, byId);
    }

    @Test
    void findById_throws_exception() {
        //Coffee espresso = Coffee.builder().coffeeId(1).coffeeName("Espresso").coffeeStrength(Strength.LIGHT).price(3.9).introductionDate(LocalDate.of(2024, 01, 15)).build();
        when(coffeeRepository.findById(anyInt())).thenReturn(Optional.empty());
        CoffeeNotFoundException exception = assertThrows(CoffeeNotFoundException.class, () -> coffeeService.findById(2000));
        assertEquals("Coffee with id 2000 not found", exception.getMessage());
    }

    @Test
    void findByName() {
        Coffee espresso = Coffee.builder().coffeeId(1).coffeeName("Espresso").coffeeStrength(Strength.LIGHT).price(3.9).introductionDate(LocalDate.of(2024, 01, 15)).build();
        when(coffeeRepository.findByName(anyString())).thenReturn(Optional.of(espresso));
        Coffee byName = coffeeService.findByName("Espresso");
        assertEquals(espresso, byName);
    }

    @Test
    void findByName_should_throw_exception_if_resource_not_found() {
        when(coffeeRepository.findByName(anyString())).thenThrow(new CoffeeNotFoundException("Coffee with name Espresso not found"));
        //assertThrows(CoffeeNotFoundException.class, () -> coffeeService.findByName("Espresso"));
        CoffeeNotFoundException exception = assertThrows(CoffeeNotFoundException.class, () -> coffeeService.findByName("Espresso"));
        assertNotNull(exception);
        assertEquals("Coffee with name Espresso not found", exception.getMessage());
        //https://github.com/junit-team/junit5/issues/2128
    }

    @Test
    void findByStrength() {
        Coffee espresso = Coffee.builder().coffeeId(1).coffeeName("Espresso").coffeeStrength(Strength.LIGHT).price(3.9).introductionDate(LocalDate.of(2024, 01, 15)).build();
        Coffee espressoLatte = Coffee.builder().coffeeId(2).coffeeName("Espresso Latte").coffeeStrength(Strength.LIGHT).price(4.9).introductionDate(LocalDate.of(2024, 02, 15)).build();
        List<Coffee> coffees = List.of(espressoLatte, espresso);
        when(coffeeRepository.findByStrength(any(Strength.class))).thenReturn(coffees);
        assertIterableEquals(coffees, coffeeService.findByStrength(Strength.LIGHT));
    }

    @Test
    void findByStrength_should_return_emptyCollection() {
        List<Coffee> coffees = Collections.emptyList();
        when(coffeeRepository.findByStrength(any(Strength.class))).thenReturn(coffees);
        assertIterableEquals(coffees, coffeeService.findByStrength(Strength.LIGHT));
    }

    @Test
    void updatePrice_should_update_the_price() {
        Coffee espresso = Coffee.builder().coffeeId(1).coffeeName("Espresso").coffeeStrength(Strength.LIGHT).price(9.9).introductionDate(LocalDate.of(2024, 01, 15)).build();
        when(coffeeRepository.updatePrice(anyInt(), eq(9.9))).thenReturn(Optional.of(espresso));
        assertEquals(espresso, coffeeService.updatePrice(1, 9.9));
    }

    @Test
    void updatePrice_should_throw_exception_when_matching_record_not_found() {
        //Coffee espresso = Coffee.builder().coffeeId(1).coffeeName("Espresso").coffeeStrength(Strength.LIGHT).price(9.9).introductionDate(LocalDate.of(2024, 01, 15)).build();
        when(coffeeRepository.updatePrice(1, 9.9d)).thenReturn(Optional.empty());
        Exception exception = assertThrows(CoffeeNotFoundException.class, () -> coffeeService.updatePrice(1, 9.9d));
        assertEquals("Coffee with id 1 not found", exception.getMessage());
    }

    @Test
    void updateStrength_should_update_the_strength() {
        Coffee espresso = Coffee.builder().coffeeId(1).coffeeName("Espresso").coffeeStrength(Strength.STRONG).price(9.9).introductionDate(LocalDate.of(2024, 01, 15)).build();
        when(coffeeRepository.updateStrength(anyInt(), any(Strength.class))).thenReturn(Optional.of(espresso));
        assertEquals(espresso, coffeeService.updateStrength(1, Strength.STRONG));
        verify(coffeeRepository, times(1)).updateStrength(1, Strength.STRONG);
    }

    @Test
    void updateStrength_should_throw_exception_when_matching_record_not_found() {
        //Coffee espresso = Coffee.builder().coffeeId(1).coffeeName("Espresso").coffeeStrength(Strength.STRONG).price(9.9).introductionDate(LocalDate.of(2024, 01, 15)).build();
        when(coffeeRepository.updateStrength(anyInt(), any(Strength.class))).thenReturn(Optional.empty());
        Exception exception = assertThrows(CoffeeNotFoundException.class, () -> coffeeService.updateStrength(1, Strength.STRONG));
        assertEquals("Coffee with id 1 not found", exception.getMessage());
        verify(coffeeRepository, times(1)).updateStrength(1, Strength.STRONG);
    }

    @Test
    void deactivateCoffee_should_call_deactivateCoffee_of_coffeeRepository(){
        Coffee espresso = Coffee.builder().coffeeId(1).coffeeName("Espresso").coffeeStrength(Strength.STRONG).price(9.9).introductionDate(LocalDate.of(2024, 01, 15)).deactivationDate(LocalDate.now()).build();
        when(coffeeRepository.findById(anyInt())).thenReturn(Optional.of(espresso));
        coffeeService.deactivateCoffee(1);
        verify(coffeeRepository, times(1)).deactivateCoffee(1);
    }

    @Test
    void deactivateCoffee_should_NOT_call_deactivateCoffee_of_coffeeRepository(){
        when(coffeeRepository.findById(anyInt())).thenReturn(Optional.empty());
        CoffeeNotFoundException exception = assertThrows(CoffeeNotFoundException.class, () -> coffeeService.deactivateCoffee(1));
        assertEquals("Coffee with id 1 not found", exception.getMessage());
        verify(coffeeRepository, times(0)).deactivateCoffee(1);
    }


    @Test
    void saveNewCoffee_should_save_new_coffee() throws CoffeeNotSavedException {
        Coffee espresso = Coffee.builder().coffeeId(1).coffeeName("Espresso").coffeeStrength(Strength.STRONG).price(9.9).introductionDate(LocalDate.of(2024, 01, 15)).build();
        when(coffeeRepository.saveNewCoffee(any(Coffee.class))).thenReturn(espresso);
        assertEquals(espresso, coffeeService.saveNewCoffee(espresso));
        verify(coffeeRepository, times(1)).saveNewCoffee(espresso);
    }

    @Test
    void saveNewCoffee_throws_exception() throws CoffeeNotSavedException {
        Coffee espresso = Coffee.builder().coffeeId(1).coffeeName("Espresso").coffeeStrength(Strength.STRONG).price(9.9).introductionDate(LocalDate.of(2024, 01, 15)).build();
        //when(coffeeRepository.saveNewCoffee(any(Coffee.class))).thenThrow(new SQLException());
        when(coffeeRepository.saveNewCoffee(any(Coffee.class))).thenAnswer(i -> {throw new SQLException("SQL Error");});
        Exception exception = assertThrows(CoffeeNotSavedException.class, () -> coffeeService.saveNewCoffee(espresso));
        assertNotNull(exception);
        assertEquals("Exception while saving new coffee", exception.getMessage());
        verify(coffeeRepository, times(1)).saveNewCoffee(espresso);
    }
}