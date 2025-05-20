package com.mercadolibre.aseguradora.dto;

import com.mercadolibre.aseguradora.model.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleInfoResponseDTO {
    private int accidentCount;
    private Vehicle vehicle;


}

