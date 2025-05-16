package org.abhishek.static_nested_car;

public class Main {
    public static void main(String[] args) {
        // Create a Car object using the builder pattern
        Car car = new Car.CarBuilder("V8", "Alloy")
                .withAirbags(true)
                .withSunroof(false)
                .build();

        car = new Car.CarBuilder("V8", "Alloy")
                .build();

        System.out.println("Car created with engine: " + car.getEngine() + ", wheels: " + car.getWheels() +
                ", hasAirbags: " + car.hasAirbags() + ", hasSunroof: " + car.hasSunroof());
    }
}
