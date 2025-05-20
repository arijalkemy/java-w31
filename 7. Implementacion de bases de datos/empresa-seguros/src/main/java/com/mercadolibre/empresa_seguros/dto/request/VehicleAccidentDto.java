package com.mercadolibre.empresa_seguros.dto.request;

import com.mercadolibre.empresa_seguros.dto.response.VehicleResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleAccidentDto {
    private Long id;
    private LocalDate accidentDate;
    private Double moneyLost;
    private VehicleResponseDto reportedVehicle;
}
