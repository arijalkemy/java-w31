package com.mercadolibre.empresa_seguros.dto.request;

import com.mercadolibre.empresa_seguros.dto.response.VehicleAccidenteResponseDto;
import com.mercadolibre.empresa_seguros.model.VehicleAccident;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDto {
    private Long id;
    private String patentNumber;
    private String brand;
    private String model;
    private LocalDate madeDate;
    private Integer wheelsQuantity;
    private List<VehicleAccidenteResponseDto> reportedAccidents;
}
