package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotBlank(message = "El estudiante tiene que tener un nombre")
    String studentName;
    String message;
    Double averageScore;
    @NotEmpty(message = "No hay materias para el estudiante")
    List<SubjectDTO> subjects;
}
