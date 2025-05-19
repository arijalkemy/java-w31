package com.mercadolibre.hql.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleLossDTO {

    private String licensePlate;
    private String brand;
    private String model;
    private Double totalLoss;

}