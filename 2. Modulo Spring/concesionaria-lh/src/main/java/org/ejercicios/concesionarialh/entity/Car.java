package org.ejercicios.concesionarialh.entity;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private int id;
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
