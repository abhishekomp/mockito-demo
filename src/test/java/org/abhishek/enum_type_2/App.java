package org.abhishek.enum_type_2;

public class App {
    public static void main(String[] args) {
        FlightCrew crew1 = new FlightCrew("John Doe", FlightCrewJob.FLIGHT_ATTENDANT);
        FlightCrew crew2 = new FlightCrew("Jane Smith", FlightCrewJob.PILOT);

        System.out.println(crew1);
        System.out.println(crew2);

        whoIsInCharge(crew1, crew2);

    }

    private static void whoIsInCharge(FlightCrew crewMember1, FlightCrew crewMember2) {
        if (crewMember1.getJob().compareTo(crewMember2.getJob()) < 0) {
            System.out.println(crewMember1.getName() + " (" + crewMember1.getJob().getTitle() + ") has a lower rank than " + crewMember2.getName() + " (" + crewMember2.getJob().getTitle() + ")");
        } else if (crewMember1.getJob().compareTo(crewMember2.getJob()) > 0) {
            System.out.println(crewMember1.getName() + " (" + crewMember1.getJob().getTitle() + ") has a higher rank than " + crewMember2.getName() + " (" + crewMember2.getJob().getTitle() + ")");
        } else {
            System.out.println(crewMember1.getName() + " and " + crewMember2.getName() + " have the same rank.");
        }
    }
}
