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
        flights.forEach(System.out::println);

        FligtSortService fligtSortService = new FligtSortService();

        // Сортировка по дате вылета: после текущего момента.
        System.out.println();
        System.out.println("Список полётов после текущего момента времени:");
        fligtSortService.sortBeforeNow(flights).forEach(System.out::println);

        // Сортировка по времени: прибытие позже отправления.
        System.out.println();
        System.out.println("Список полётов с временем прилёта позже времени вылета:");
        fligtSortService.sortArrivalBeforeDeparture(flights).forEach(System.out::println);


        // Сортировка по времени полёта более 2-х часов.
        System.out.println();
        System.out.println("Список полётов с временем пути не более 2-х часов:");
        fligtSortService.sortFlightTimeMoreTwoHours(flights).forEach(System.out::println);

    }

}