package com.example.empresaseguros.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoInfoDto {
    private String matricula;
    private String marca;
    private String modelo;
}
