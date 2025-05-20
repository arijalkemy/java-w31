package com.mercadolibre.casosdeprueba.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TesterDto {
    private String nombre;
    private List<TestCaseDto> testRealizados;
}
