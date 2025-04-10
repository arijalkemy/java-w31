package com.example.concesionariaautos.dto;

import com.example.concesionariaautos.model.Service;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleDto {
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
