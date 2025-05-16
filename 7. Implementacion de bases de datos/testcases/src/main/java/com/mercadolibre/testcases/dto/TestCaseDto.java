package com.mercadolibre.testcases.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestCaseDto {
    private Long id;
    private String description;
    private Boolean tested;
    private Boolean passed;
    private Integer numberOfTries;
    private String lastUpdate;
}
