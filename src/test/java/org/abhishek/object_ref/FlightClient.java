package org.abhishek.object_ref;

public class FlightClient {
    public static void main(String[] args) {
        Flight flight1 = new Flight("AI101");
        System.out.println("Flight 1: " + flight1);

        Flight flight2 = new Flight("AI102");
        System.out.println("Flight 2: " + flight2);

//        Flight flight3 = flight1;
//        flight3.setFlightNumber("AI103");
//
//        System.out.println("After changing");
//
//        System.out.println("Flight 1: " + flight1);
//        System.out.println("Flight 2: " + flight2);
//        System.out.println("Flight 3: " + flight3);


        //swapFlight(flight1, flight2);
        swapFlightNumber(flight1, flight2);

        System.out.println("After swapFlight() call");
        System.out.println("Flight 1: " + flight1);
        System.out.println("Flight 2: " + flight2);
        //System.out.println("Flight 3: " + flight3);
    }

    // This method swaps the references of two Flight objects, but the changes are not reflected in the original objects.
    public static void swapFlight(Flight a, Flight b) {
        Flight temp = a;
        a = b;
        b = temp;
    }

    // This method swaps the flight numbers of two Flight objects and the changes are reflected in the original objects.
    public static void swapFlightNumber(Flight a, Flight b) {
        String temp = a.getFlightNumber();
        a.setFlightNumber(b.getFlightNumber());
        b.setFlightNumber(temp);
    }
}
