package com.mercadolibre.concesionariaauto.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDTO implements Serializable {
    Integer id;
    String brand;
    String model;
    String manufacturingDate;
    String numberOfKilometers;
    String doors;
    String price;
    String currency;
    String countOfOwners;
}
