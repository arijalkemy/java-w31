package com.mercadolibre.aseguradora.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleLossInfoDTO {

    private String licensePlate;
    private String brand;
    private String model;
    private BigDecimal totalLoss;

}

