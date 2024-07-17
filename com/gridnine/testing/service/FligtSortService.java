package com.gridnine.testing.service;

import com.gridnine.testing.models.Flight;
import com.gridnine.testing.models.Segment;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FligtSortService {

    //  Исключение вылетов раньше текущего момента.
    public List<Flight> sortBeforeNow(List<Flight> flights) {
        List<Flight> sortedFlightsBeforeNow = flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getDepartureDate()
                                .isAfter(LocalDateTime.now())))
                .collect(Collectors.toList());
        return sortedFlightsBeforeNow;
    }

    //  Исключение полетов с прибытием раньше отправления.
    public List<Flight> sortArrivalBeforeDeparture(List<Flight> flights) {
        List<Flight> sortedFlightsArrivalBeforeDepart = flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getArrivalDate()
                                .isAfter(segment.getDepartureDate())))
                .collect(Collectors.toList());
        return sortedFlightsArrivalBeforeDepart;
    }


    //  Исключение полетов более 2-х часов.
    public List<Flight> sortFlightTimeMoreTwoHours(List<Flight> flights) {
        List<Flight> filteredFlightsTransferExceedsTwoHours = flights.stream()
                .filter(flight -> summFlightTime(flight) <= Duration.ofHours(2).toHours())
                .collect(Collectors.toList());
        return filteredFlightsTransferExceedsTwoHours;
    }


    // Расчет времени полёта
    private long summFlightTime(Flight flight) {
        List<Segment> segments = flight.getSegments();
        long totalFlightTime = 0;
        for (int i = 1; i < segments.size(); i++) {
            LocalDateTime currentArrival = segments.get(i - 1).getArrivalDate();
            LocalDateTime nextDeparture = segments.get(i).getDepartureDate();
            totalFlightTime += Duration.between(currentArrival, nextDeparture).toHours();
        }
        return totalFlightTime;
    }

}
