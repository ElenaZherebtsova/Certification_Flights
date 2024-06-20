package com.gridnine.testing;

import com.gridnine.testing.models.Flight;
import com.gridnine.testing.service.FlightBuilder;
import com.gridnine.testing.service.FligtSortService;


import java.util.List;


public class Main {
    public static void main(String[] args) {
// создание и печать списка полетов.
        FlightBuilder flightBuilder = new FlightBuilder();
        List<Flight> flights = flightBuilder.createFlights();

        System.out.println("Список всех полетов:");
//        System.out.println(flights);
        flights.forEach(System.out::println);
        // удаление дубликатов и печать нового списка
        FligtSortService fligtSortService = new FligtSortService();

//        System.out.println("Список полетов без дубликатов:");
//        fligtSortService.deleteDublicates(flights).forEach(System.out::println);


        System.out.println();
        System.out.println("Список полётов до текущего момента времени:");
        fligtSortService.sortBeforeNow(flights).forEach(System.out::println);
    }

}