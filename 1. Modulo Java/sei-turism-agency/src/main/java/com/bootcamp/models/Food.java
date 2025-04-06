package com.bootcamp.models;

import java.time.LocalDate;

public class Food extends Booking {
    public Food(LocalDate initialDate, LocalDate finalDate, Double price) {
        super(initialDate, finalDate, price);
        System.out.println("\n-->Food Booking created");
        System.out.println(this);
    }
}
