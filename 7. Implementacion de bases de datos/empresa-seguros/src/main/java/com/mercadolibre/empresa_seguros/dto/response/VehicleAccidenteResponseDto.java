package com.mercadolibre.empresa_seguros.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleAccidenteResponseDto {
    private LocalDate accidentDate;
    private Double moneyLost;
}
