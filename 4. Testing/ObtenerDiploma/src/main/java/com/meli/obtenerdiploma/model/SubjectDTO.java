package com.meli.obtenerdiploma.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SubjectDTO {
    @NotBlank(message = "El noombre de la materia no puede ser vacio")
    String name;

    @NotNull(message = "La nota no puede ser nula")
    @Min(value = 0,message = "La nota minima debe ser cero")
    @Max(value = 10, message = "La nota maxima debe ser 10")
    Double score;
}
