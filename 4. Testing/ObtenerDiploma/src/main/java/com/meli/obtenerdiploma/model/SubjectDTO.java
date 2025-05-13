package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter @Setter
public class SubjectDTO {
    @NotBlank(message = "El nombre de la materia es obligatorio")
    String name;
    @NotNull(message = "La nota es obligatorio")
    @Min(value = 0, message = "La nota no puede ser negativa")
    @Max(value = 10, message = "La nota no puede ser mayor que 10")
    Double score;
}
