package com.bootcamp.models;

import java.time.LocalDate;

public class Hotel extends Booking {
    public Hotel(LocalDate initialDate, LocalDate finalDate, Double price) {
        super(initialDate, finalDate, price);
        System.out.println("\n-->Hotel Booking created");
        System.out.println(this);
    }
}
