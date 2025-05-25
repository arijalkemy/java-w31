package com.mercadolibre.empresaseguroshql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatenteMarcaDTO {
    private String patente;
    private String marca;
}
