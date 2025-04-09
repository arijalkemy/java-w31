package com.concesionariadeautos.concesionariadeautos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class VehiclesOffServiceResponseDTO implements Serializable {
    private Long id;
    private String brand, model,currency,numberOfKilometers,doors, countOfOwner,price;
    private Date manufacturingDate;
}
