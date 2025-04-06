package com.bootcamp;

import com.bootcamp.models.*;
import com.bootcamp.repositories.ClientRepository;
import com.bootcamp.repositories.LocalizerRepository;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Client laura = new Client("123456", "Laura", "Bte", "26375482");
        ClientRepository.addClient(laura);

        // localizer with all the bookings
        Hotel hotelLaura = new Hotel(LocalDate.of(2025, 03, 01), LocalDate.of(2025, 03, 05), 525.5);
        Travel travelLaura = new Travel(LocalDate.of(2025, 03, 01), LocalDate.of(2025, 03, 05), 1520.0);
        Food foodLaura = new Food(LocalDate.of(2025, 03, 01), LocalDate.of(2025, 03, 05), 870.0);
        Transportation transportationLaura = new Transportation(LocalDate.of(2025, 03, 01), LocalDate.of(2025, 03, 05), 350.0);

        Localizer localizerLauraComplete = new Localizer(List.of(hotelLaura, travelLaura, foodLaura, transportationLaura), laura);
        LocalizerRepository.addLocalizer(localizerLauraComplete);

        // localizer with 2 hotel and 2 travel bookings
        Hotel hotelLaura2 = new Hotel(LocalDate.of(2025, 06, 01), LocalDate.of(2025, 06, 03), 835.8);
        Hotel hotelLaura3 = new Hotel(LocalDate.of(2025, 06, 03), LocalDate.of(2025, 06, 05), 350.8);
        Travel travelLaura2 = new Travel(LocalDate.of(2025, 06, 01), LocalDate.of(2025, 06, 03), 3500.0);
        Travel travelLaura3 = new Travel(LocalDate.of(2025, 06, 03), LocalDate.of(2025, 06, 05), 550.0);

        Localizer localizerLaura2 = new Localizer(List.of(hotelLaura2, hotelLaura3, travelLaura2, travelLaura3), laura);
        LocalizerRepository.addLocalizer(localizerLaura2);

        // localizer with one booking
        Food foodLaura2 = new Food(LocalDate.of(2025, 05, 01), LocalDate.of(2025, 05, 01), 250.0);

        Localizer localizerLaura3 = new Localizer(List.of(foodLaura2), laura);
        LocalizerRepository.addLocalizer(localizerLaura3);

        System.out.println(LocalizerRepository.getTotalSalesAmount());
        System.out.println(LocalizerRepository.getBookingsCount());
        System.out.println(LocalizerRepository.getTotalSalesAverageAmount());
    }
}