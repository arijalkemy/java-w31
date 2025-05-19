package com.mercadolibre.vehiculohql.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoPatenteMarcaModeloDTO {
    private String patente;
    private String marca;
    private String modelo;
}
