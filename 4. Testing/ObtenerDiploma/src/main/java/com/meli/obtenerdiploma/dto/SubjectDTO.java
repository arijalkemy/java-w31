package com.meli.obtenerdiploma.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDTO {
    @NotBlank(message = "El noombre de la materia no puede ser vacio")
    String name;

    @NotNull(message = "La nota no puede ser nula")
    @Min(value = 0,message = "La nota minima debe ser cero")
    @Max(value = 10, message = "La nota maxima debe ser 10")
    Double score;
}
