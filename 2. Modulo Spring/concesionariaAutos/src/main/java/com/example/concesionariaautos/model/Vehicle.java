package com.example.concesionariaautos.model;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
public class Vehicle {
    private String id;
    private String brand;
    private String model;
    private String manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private String price;
    private String currency;
    private List<Service> services;
    private String countOfOwners;

}
