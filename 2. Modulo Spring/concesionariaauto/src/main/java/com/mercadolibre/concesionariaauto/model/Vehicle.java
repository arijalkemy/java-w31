package com.mercadolibre.concesionariaauto.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
 Integer id;
 String brand;
 String model;
 String manufacturingDate;
 String numberOfKilometers;
 String doors;
 String price;
 String currency;
 List<ServiceFromVehicle> services;
 String countOfOwners;
}
