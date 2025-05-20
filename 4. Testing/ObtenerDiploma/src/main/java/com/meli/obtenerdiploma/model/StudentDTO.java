package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotBlank(message = "El nombre del estudiante es obligatorio.")
    String studentName;
    @NotBlank(message = "El mensaje es obligatorio.")
    String message;
    @Min(value = 0, message = "El puntaje promedio debe ser mayor a 0.")
    @Max(value = 100, message = "El puntaje promedio debe ser menor a 100.")
    @NotNull(message = "El puntaje promedio es obligatorio.")
    Double averageScore;
    @NotNull(message = "Las materias son obligatorias")
    @Valid
    List<SubjectDTO> subjects;
}
