package com.meli.concesionaria.dto;

import java.util.List;

import com.meli.concesionaria.model.ServiceModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetVehicleResponseDTO {
    private String id;
    private String brand;
    private String model;
    private String manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private String price;
    private String currency;
    private List<ServiceModel> services;
    private String countOfOwners;
}
