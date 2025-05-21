package com.mercadolibre.testcase.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter @Setter
public class TestCaseDTO {
    private Long id;
    private String description;
    private Boolean tested;
    private Boolean passed;
    private int numberOfTries;
    private LocalDate lastUpdate = LocalDate.now();
}
