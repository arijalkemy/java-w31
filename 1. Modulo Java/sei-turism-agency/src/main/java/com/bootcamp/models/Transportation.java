package com.bootcamp.models;

import java.time.LocalDate;

public class Transportation extends Booking {
    public Transportation(LocalDate initialDate, LocalDate finalDate, Double price) {
        super(initialDate, finalDate, price);
        System.out.println("\n-->Transportation Booking created");
        System.out.println(this);
    }
}
