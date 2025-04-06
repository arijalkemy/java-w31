package com.bootcamp.models;

import java.time.LocalDate;

public class Travel extends Booking {
    public Travel(LocalDate initialDate, LocalDate finalDate, Double price) {
        super(initialDate, finalDate, price);
        System.out.println("\n-->Travel Booking created");
        System.out.println(this);
    }
}
