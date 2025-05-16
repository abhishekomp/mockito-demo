package org.abhishek.static_nested_car;

public class Car {
    //Required parameters
    private final String engine;
    private final String wheels;

    //Optional parameters
    private final boolean hasAirbags;
    private final boolean hasSunroof;
    /*private final boolean hasNavigationSystem;
    private final boolean hasLeatherSeats;
    private final boolean hasBluetooth;
    private final boolean hasBackupCamera;*/

    private Car(CarBuilder builder) {
        this.engine = builder.engine;
        this.wheels = builder.wheels;
        this.hasAirbags = builder.hasAirbags;
        this.hasSunroof = builder.hasSunroof;
    }

    public String getEngine() {
        return engine;
    }

    public String getWheels() {
        return wheels;
    }

    public boolean hasAirbags() {
        return hasAirbags;
    }

    public boolean hasSunroof() {
        return hasSunroof;
    }

    // Static nested class
    public static class CarBuilder {
        //Required parameters
        private final String engine;
        private final String wheels;

        //Optional parameters
        private boolean hasAirbags;
        private boolean hasSunroof;
        /*private boolean hasNavigationSystem;
        private boolean hasLeatherSeats;
        private boolean hasBluetooth;
        private boolean hasBackupCamera;*/

        public CarBuilder(String engine, String wheels) {
            this.engine = engine;
            this.wheels = wheels;
        }

        public CarBuilder withAirbags(boolean hasAirbags) {
            this.hasAirbags = hasAirbags;
            return this;
        }

        public CarBuilder withSunroof(boolean hasSunroof) {
            this.hasSunroof = hasSunroof;
            return this;
        }

        /*public CarBuilder setHasNavigationSystem(boolean hasNavigationSystem) {
            this.hasNavigationSystem = hasNavigationSystem;
            return this;
        }

        public CarBuilder setHasLeatherSeats(boolean hasLeatherSeats) {
            this.hasLeatherSeats = hasLeatherSeats;
            return this;
        }

        public CarBuilder setHasBluetooth(boolean hasBluetooth) {
            this.hasBluetooth = hasBluetooth;
            return this;
        }

        public CarBuilder setHasBackupCamera(boolean hasBackupCamera) {
            this.hasBackupCamera = hasBackupCamera;
            return this;
        }*/

        public Car build() {
            return new Car(this);
        }
    }
    @Override
    public String toString() {
        return "Car{" +
                "engine='" + engine + '\'' +
                ", wheels='" + wheels + '\'' +
                ", hasAirbags=" + hasAirbags +
                ", hasSunroof=" + hasSunroof +
                '}';
    }

}
