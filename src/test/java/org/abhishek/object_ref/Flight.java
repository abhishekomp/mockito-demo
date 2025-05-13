package org.abhishek.object_ref;

public class Flight {
    private String flightNumber;

    public Flight(String flightNumber) {
        this.flightNumber = flightNumber;
    }
    public String getFlightNumber() {
        return flightNumber;
    }


    @Override
    public String toString() {
        return String.format("Flight number: %s", flightNumber);
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
}
