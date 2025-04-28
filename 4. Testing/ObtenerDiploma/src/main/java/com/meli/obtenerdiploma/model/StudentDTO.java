package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Valid
@Getter @Setter
public class StudentDTO {
    @NotNull(message = "Por favor ingrese el nombre del estudiante.")
            @NotEmpty(message = "El nombre del estudiante no puede ser vacío.")
    String studentName;
    @NotNull(message = "La propiedad mensaje no puede ser nula.")
            @NotEmpty(message = "La propiedad mensaje no puede estar vacía.")
    String message;

    @Min(value = 0, message = "El promedio no puede ser menor que 0.")
    @Max(value = 100, message = "El promedio no puede ser mayor que 100.")
    Double averageScore;

    @NotEmpty(message = "La lista de asignaturas no puede estar vacía.")
            @NotNull(message = "La lista de asignaturas no puede ser nula.")
    List<SubjectDTO> subjects;
}
