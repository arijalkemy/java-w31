package com.bootcamp.models;

import java.time.LocalDate;
import java.util.Date;

public abstract class Booking {
    private Integer id;
    private LocalDate initialDate;
    private LocalDate finalDate;
    private Double price;
    private static int counterIds = 0;

    public Booking(LocalDate initialDate, LocalDate finalDate, Double price) {
        counterIds += 1;
        this.id = counterIds;
        this.initialDate = initialDate;
        this.finalDate = finalDate;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public LocalDate getInitialDate() {
        return initialDate;
    }

    public LocalDate getFinalDate() {
        return finalDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setInitialDate(LocalDate initialDate) {
        this.initialDate = initialDate;
    }

    public void setFinalDate(LocalDate finalDate) {
        this.finalDate = finalDate;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "\n\tBooking:" +
                "\n\t\tid= " + id +
                "\n\t\tinitial Date= " + initialDate +
                "\n\t\tfinal Date= " + finalDate +
                "\n\t\tprice= " + price;
    }
}
