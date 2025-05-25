package com.mercadolibre.empresaseguroshql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoInfoDTO {
    private String patente;
    private String marca;
    private String modelo;
}
