package com.meli.maolaya.crudjpa.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestCaseDto implements Serializable {
    private Long idCase;
    private String description;
    private Boolean tested;
    private Boolean passed;
    private Integer numberOfTries;
    private LocalDate lastUpdate;
}
