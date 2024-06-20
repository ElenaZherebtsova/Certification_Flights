package com.gridnine.testing.service;

import com.gridnine.testing.models.Flight;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FligtSortService {

    public List<Flight> deleteDublicates (List<Flight> list) {
        List<Flight> newList = new ArrayList<>();
        for (Flight element : list) {
            if (!newList.contains(element)) {
                newList.add(element);
            }
        }
        return newList;
    }

    public List<Flight> sortBeforeNow(List<Flight> flights) {
        List<Flight> sortedFlightsBeforeNow = flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getDepartureDate().isBefore(LocalDateTime.now())))
                .collect(Collectors.toList());
        return sortedFlightsBeforeNow;
    }



}
