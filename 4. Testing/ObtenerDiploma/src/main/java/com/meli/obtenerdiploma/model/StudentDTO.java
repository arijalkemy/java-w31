package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotBlank(message = "El nombre del estudiante es obligatorio")
    String studentName;
    String message;
    Double averageScore;
    @Valid
    @NotNull(message = "Debe ingresar al menos una materia")
    @Size(min = 1, message = "Debe ingresar al menos una materia")
    List<SubjectDTO> subjects;
}
