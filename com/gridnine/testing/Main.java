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

        // Добавление сервисов по сортировке полётов.
        FligtSortService fligtSortService = new FligtSortService();

        // Сортировка по дате вылета: до текущего момента.
        System.out.println();
        System.out.println("Список полётов до текущего момента времени:");
        fligtSortService.sortBeforeNow(flights).forEach(System.out::println);

        // Сортировка по времени: прибытие раньше отправления.
        System.out.println();
        System.out.println("Список полётов с временем прилёта раньше времени вылета:");
        fligtSortService.sortArrivalBeforeDeparture(flights).forEach(System.out::println);


    }

}