package com.example.hqlenvivo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateVehicleRequest {
    private String patente;
    private String brand;
    private String model;
    private String year;
    private Integer wheels;
}
