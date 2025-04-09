package org.ejercicios.concesionarialh.dto;

import org.ejercicios.concesionarialh.entity.Service;

import java.util.List;

public class CarDTO {
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
