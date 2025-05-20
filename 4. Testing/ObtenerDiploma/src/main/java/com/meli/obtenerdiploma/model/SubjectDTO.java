package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter @Setter
public class SubjectDTO {
    @NotBlank(message = "El nombre es obligatorio.")
    String name;
    @Min(value = 0, message = "El puntaje debe ser mayor a 0.")
    @Max(value = 100, message = "El puntaje debe ser menor a 100.")
    @NotNull(message = "El puntaje es obligatorio.")
    Double score;
}
