package com.mercadolibre.aseguradora.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleBasicInfoDTO {

    private String licensePlate;
    private String brand;
    private String model;
    
}

