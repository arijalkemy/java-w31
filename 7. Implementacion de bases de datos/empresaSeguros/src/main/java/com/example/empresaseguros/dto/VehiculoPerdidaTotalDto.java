package com.example.empresaseguros.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoPerdidaTotalDto {
    private String matricula;
    private String marca;
    private String modelo;
    private Double perdidaTotal;
}
