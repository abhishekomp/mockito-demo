package org.abhishek.enum_type;

public class _04_App_CompareTo {
    //enums support relational operators
    // first value is the lowest
    // last value is the highest
    public static void main(String[] args) {
        FlightCrew crewMember1 = new FlightCrew("John Doe", FlightCrewJob.PILOT);
        FlightCrew crewMember2 = new FlightCrew("Jane Smith", FlightCrewJob.FLIGHT_ATTENDANT);

        System.out.println(crewMember1);
        System.out.println(crewMember2);

        // Enums support comparison using compareTo method
        whoIsInCharge(crewMember1, crewMember2);
        whoIsInCharge(crewMember2, crewMember1);
    }

    private static void whoIsInCharge(FlightCrew crewMember1, FlightCrew crewMember2) {
        if (crewMember1.getJob().compareTo(crewMember2.getJob()) < 0) {
            System.out.println(crewMember1.getName() + " (" + crewMember1.getJob() + ") has a lower rank than " + crewMember2.getName() + " (" + crewMember2.getJob() + ")");
        } else if (crewMember1.getJob().compareTo(crewMember2.getJob()) > 0) {
            System.out.println(crewMember1.getName() + " (" + crewMember1.getJob() + ") has a higher rank than " + crewMember2.getName() + " (" + crewMember2.getJob() + ")");
        } else {
            System.out.println(crewMember1.getName() + " and " + crewMember2.getName() + " have the same rank.");
        }
    }
}
