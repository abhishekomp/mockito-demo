package org.abhishek.enum_type;

public class _01_App {
    public static void main(String[] args) {
        FlightCrew crewMember1 = new FlightCrew("John Doe", FlightCrewJob.PILOT);
        FlightCrew crewMember2 = new FlightCrew("Jane Smith", FlightCrewJob.FLIGHT_ATTENDANT);

        System.out.println(crewMember1);
        System.out.println(crewMember2);

        // Enums support equality checks (== and !=)
        if (crewMember1.getJob() == FlightCrewJob.PILOT) {
            System.out.println(crewMember1.getName() + " is a pilot.");
        } else {
            System.out.println(crewMember1.getName() + " is not a pilot.");
        }
        FlightCrewJob job1 = FlightCrewJob.PILOT;
        FlightCrewJob job2 = FlightCrewJob.CO_PILOT;
        if(job1 == FlightCrewJob.PILOT) {
            System.out.println("job1 is a pilot.");
        }
        if(job1 != job2) {
            System.out.println("job1 and job2 are not the same.");
        }
    }
}
