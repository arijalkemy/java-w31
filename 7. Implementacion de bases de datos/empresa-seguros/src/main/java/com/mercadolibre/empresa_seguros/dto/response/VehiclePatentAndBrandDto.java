package com.mercadolibre.empresa_seguros.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class VehiclePatentAndBrandDto {
    private String patentNumber;
    private String brand;
}
