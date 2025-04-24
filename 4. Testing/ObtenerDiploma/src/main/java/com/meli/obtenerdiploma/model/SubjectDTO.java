package com.meli.obtenerdiploma.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SubjectDTO {
    @NotNull(message = "El nombre de la materia no puede ser nulo")
    private String name;

    @NotNull(message = "La nota de la materia no puede ser nula")
    @Min(value = 0, message = "La nota de la materia no puede ser menor a 0")
    @Max(value = 10, message = "La nota de la materia no puede ser mayor a 10")
    private Double score;
}
