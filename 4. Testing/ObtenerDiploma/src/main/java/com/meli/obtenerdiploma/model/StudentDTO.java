package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.sql.SQLOutput;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotBlank(message = "El noombre del estudiante es obligatorio")
    String studentName;

    String message;
    Double averageScore;

    @NotNull(message = "La Lista de materias debe ser obligatoria")
    @Size(message = "Debe contener al menos una materia")
    @Valid
    List<SubjectDTO> subjects;

}
