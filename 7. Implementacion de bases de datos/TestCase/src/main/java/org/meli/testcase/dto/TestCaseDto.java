package org.meli.testcase.dto;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class TestCaseDto {
    private Long idCase;
    @NotBlank(message = "La descripción es obligatoria.")
    @Size(max = 255, message = "La descripción no puede superar 255 caracteres.")
    private String description;
    @NotNull(message = "El campo 'tested' es obligatorio.")
    private Boolean tested;
    @NotNull(message = "El campo 'passed' es obligatorio.")
    private Boolean passed;
    @NotNull(message = "El número de intentos es obligatorio.")
    @Positive(message = "El número de intentos no puede ser negativo o cero.")
    private Integer numberOfTries;
    @NotNull(message = "La fecha de la última actualización es obligatoria.")
    private LocalDate lastUpdate;
}
