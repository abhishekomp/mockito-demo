package org.abhishek.enum_type;

public class _03_App {
    //enums support relational operators
    // first value is the lowest
    // last value is the highest
    public static void main(String[] args) {
        FlightCrew crewMember1 = new FlightCrew("John Doe", FlightCrewJob.PILOT);
        FlightCrew crewMember2 = new FlightCrew("Jane Smith", FlightCrewJob.FLIGHT_ATTENDANT);

        System.out.println(crewMember1);
        System.out.println(crewMember2);

        // Enums support relational operators
        if (crewMember1.getJob().ordinal() < crewMember2.getJob().ordinal()) {
            System.out.println(crewMember1.getName() + " " + crewMember1.getJob() + " has a lower rank than " + crewMember2.getName() + " " + crewMember2.getJob());
        } else {
            System.out.println(crewMember1.getName() + " " + crewMember1.getJob() + " has a higher rank than " + crewMember2.getName() + " " + crewMember2.getJob());
        }

        // Enums support comparison using compareTo method
        if (crewMember1.getJob().compareTo(crewMember2.getJob()) < 0) {
            System.out.println(crewMember1.getName() + " " + crewMember1.getJob() + " has a lower rank than " + crewMember2.getName() + " " + crewMember2.getJob());
        } else if (crewMember1.getJob().compareTo(crewMember2.getJob()) > 0) {
            System.out.println(crewMember1.getName() + " " + crewMember1.getJob() + " has a higher rank than " + crewMember2.getName() + " " + crewMember2.getJob());
        } else {
            System.out.println(crewMember1.getName() + " and " + crewMember2.getName() + " have the same rank.");
        }
    }
}
