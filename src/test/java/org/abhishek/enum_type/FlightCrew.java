package org.abhishek.enum_type;

public class FlightCrew {
    private String name;
    private FlightCrewJob job;

    public FlightCrew(String name, FlightCrewJob job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public FlightCrewJob getJob() {
        return job;
    }

    @Override
    public String toString() {
        return "FlightCrew{" +
                "name='" + name + '\'' +
                ", job=" + job +
                '}';
    }
}
