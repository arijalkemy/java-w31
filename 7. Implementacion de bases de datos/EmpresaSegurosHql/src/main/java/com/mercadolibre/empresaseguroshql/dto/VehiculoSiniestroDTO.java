package com.mercadolibre.empresaseguroshql.dto;

import com.mercadolibre.empresaseguroshql.model.Vehiculo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoSiniestroDTO {
    private Vehiculo vehiculo;
    private Integer perdidaTotal;
}
