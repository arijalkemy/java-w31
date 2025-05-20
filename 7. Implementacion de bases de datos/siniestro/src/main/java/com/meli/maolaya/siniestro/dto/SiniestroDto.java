package com.meli.maolaya.siniestro.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(Include.NON_EMPTY)
public class SiniestroDto implements Serializable {
    private Long id;
    private LocalDate fechaSiniestro;
    private Double perdidaEconomica;
    private Long idVehiculo;
}
