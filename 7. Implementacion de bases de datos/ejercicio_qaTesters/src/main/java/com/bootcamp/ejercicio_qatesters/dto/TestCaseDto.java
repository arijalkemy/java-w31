package com.bootcamp.ejercicio_qatesters.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TestCaseDto {
  @JsonProperty(value = "id_case")
  private Long id;

  private String description;

  private Boolean tested;

  private Boolean passed;

  @JsonProperty(value = "number_of_tries")
  private Integer numberTries;

  @JsonProperty(value = "last_update")
  private LocalDate lastUpdate;
}
