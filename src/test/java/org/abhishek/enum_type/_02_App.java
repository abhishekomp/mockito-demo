package org.abhishek.enum_type;

public class _02_App {
    //enums support switch statements
    public static void main(String[] args) {
        FlightCrew crewMember1 = new FlightCrew("John Doe", FlightCrewJob.PILOT);
        FlightCrew crewMember2 = new FlightCrew("Jane Smith", FlightCrewJob.FLIGHT_ATTENDANT);

        System.out.println(crewMember1);
        System.out.println(crewMember2);

        // Enums support switch statements
        switch (crewMember1.getJob()) {
            case PILOT:
                System.out.println(crewMember1.getName() + " is a pilot.");
                break;
            case CO_PILOT:
                System.out.println(crewMember1.getName() + " is a co-pilot.");
                break;
            case FLIGHT_ATTENDANT:
                System.out.println(crewMember1.getName() + " is a flight attendant.");
                break;
                //default case is not required because enums are exhaustive
        }
    }
}
