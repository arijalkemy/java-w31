package com.bootcamp.be_java_hisp_w31_g09.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdatePricesDTO {
    @NotNull(message = "El tipo de operación es obligatorio")
    private String operation;
    @NotNull(message = "El porcentaje es obligatorio")
    @Positive(message = "El porcentaje debe ser un número positivo")
    private Double percentage;
}
