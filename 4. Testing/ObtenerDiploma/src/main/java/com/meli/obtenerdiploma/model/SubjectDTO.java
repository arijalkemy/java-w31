package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Valid
@Getter @Setter
public class SubjectDTO {
    @NotNull(message = "Por favor ingrese el nombre de la materia.")
            @NotEmpty(message = "El nombre de la materia no puede estar vacío.")
    String name;

    @NotNull(message = "Por favor ingrese el puntaje obtenido en la materia.")
            @Min(0)
            @Max(100)
    Double score;
}
