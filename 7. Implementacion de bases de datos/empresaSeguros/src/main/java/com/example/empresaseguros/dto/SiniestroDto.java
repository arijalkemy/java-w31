package com.example.empresaseguros.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SiniestroDto {
    private Long id;
    private LocalDate fecha;
    private Double perdidaEconomica;
    private Long idVehiculo;
}
