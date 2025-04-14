package com.example.ConcesionariaAutos.Entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Vehicle {
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private Integer numberOfKilometers;
    private Integer doors;
    private Integer price;
    private String currency;
    private List<Service> services;
    private Integer countOfOwners;
    private Integer id;
    private static Integer counter = 0;

    public Vehicle() {
    }

    public Vehicle(String brand, String model, LocalDate manufacturingDate, Integer numberOfKilometers, Integer doors,
            Integer price, String currency, List<Service> services, Integer countOfOwners) {
        this.id = counter++;
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.services = services;
        this.countOfOwners = countOfOwners;
    }
}
