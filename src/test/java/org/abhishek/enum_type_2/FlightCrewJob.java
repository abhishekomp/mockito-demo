package org.abhishek.enum_type_2;

public enum FlightCrewJob {

    FLIGHT_ATTENDANT("Flight Attendant"),
    CO_PILOT("First Officer"),
    PILOT("Captain");

    private final String title;

    FlightCrewJob(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }
}
