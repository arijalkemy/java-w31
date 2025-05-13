package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter @Setter
public class
StudentDTO {
    @NotBlank(message = "El nombre del estudiante es obligatorio")
    String studentName;
    @NotBlank(message = "El mensaje es obligatorio")
    String message;
    @NotNull(message = "El promedio es obligatorio")
    @Min(value = 0, message = "El promedio no puede ser negativo")
    @Max(value = 10, message = "El promedio no puede ser mayor que 10")
    Double averageScore;
    @NotNull(message = "El listado de materias es obligatorio")
    List<@NotNull @Valid SubjectDTO> subjects; // agregar @Valid a subject para que justamente lo valide
}
