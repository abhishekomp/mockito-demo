package org.abhishek.enum_type;

public class _05_App {
    // Enums has methods for example values()
    public static void main(String[] args) {
        // Print all enum values
        System.out.println("All Flight Crew Jobs:");
        for (FlightCrewJob job : FlightCrewJob.values()) {
            System.out.println(job);
        }

        // Print enum value by name
        // valueOf() method is case-sensitive. It returns the enum constant of the specified name if it exists.
        // If not, it throws IllegalArgumentException.
        String jobName = "PILOT";
        FlightCrewJob jobByName = FlightCrewJob.valueOf(jobName);
        System.out.println("Job by name: " + jobByName);
    }
}
