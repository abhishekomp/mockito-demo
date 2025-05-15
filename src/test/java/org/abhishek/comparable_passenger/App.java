package org.abhishek.comparable_passenger;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Passenger passenger1 = new Passenger("John Doe", 3, 100);
        Passenger passenger2 = new Passenger("Jane Smith", 1, 200);
        Passenger passenger3 = new Passenger("Alice Johnson", 3, 150);
        Passenger passenger4 = new Passenger("Bob Brown", 2, 50);
        Passenger passenger5 = new Passenger("Charlie Smith", 1, 100);

        System.out.println(passenger1);
        System.out.println(passenger2);
        System.out.println(passenger3);

        // Compare passengers
        System.out.println("Comparing passengers:");
        System.out.println(passenger1.compareTo(passenger2));
        System.out.println(passenger2.compareTo(passenger3));
        System.out.println(passenger3.compareTo(passenger1));


        // Sort passengers using compareTo method of Comparable interface implemented in Passenger class
        Passenger[] passengers = {passenger1, passenger2, passenger3, passenger4, passenger5};
        Arrays.sort(passengers);
        System.out.println("Sorted passengers:");
        for (Passenger passenger : passengers) {
            System.out.println(passenger);
        }
        // Expected output:
/*        Sorted passengers:
        Passenger{name='Jane Smith', memberLevel=1, memberDays=200}
        Passenger{name='Charlie Smith', memberLevel=1, memberDays=100}
        Passenger{name='Bob Brown', memberLevel=2, memberDays=50}
        Passenger{name='Alice Johnson', memberLevel=3, memberDays=150}
        Passenger{name='John Doe', memberLevel=3, memberDays=100}*/
    }
}
