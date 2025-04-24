package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Getter @Setter
public class SubjectDTO {
    @NotBlank(message = "La materia tiene que tener nombre")
    String name;
    @NotNull(message = "No hay nota para una materia")
    @PositiveOrZero(message = "Las notas no pueden ser negativas")
    Double score;
}
