package com.mercadolibre.miniseries.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mercadolibre.miniseries.model.Siniestro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class VehicleDto {

    private Long id;
    private String matricula;
    private String marca;
    private String modelo;
    private Long anoFabricacion;
    private Integer numRuedas;
    private List<SiniestroDto> siniestros;
}
