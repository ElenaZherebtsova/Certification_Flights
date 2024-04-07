package com.gridnine.testing;

import com.gridnine.testing.models.Flight;
import com.gridnine.testing.models.Segment;


import java.time.LocalDateTime;
import java.util.List;


public class Main {
    public static void main(String[] args) {
// создание и печать списка полетов.
        FlightBuilder flightBuilder = new FlightBuilder();

        List<Flight> flights = flightBuilder.createFlights();

        System.out.println("Придуманный список полетов:");
        System.out.println(flights);

        flights.stream().filter()


    }

}