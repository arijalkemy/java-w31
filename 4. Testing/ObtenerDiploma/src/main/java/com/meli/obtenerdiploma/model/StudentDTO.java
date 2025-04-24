package com.meli.obtenerdiploma.model;

//import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter @Setter
public class StudentDTO {
    @NotBlank(message = "El nombre del estudiante no puede ser nulo")
    private String studentName;

    @NotNull(message = "Las materias del estudiante no puede ser nula")
    @NotEmpty(message = "El estudiante debe estar anotado a al menos una materia.")
    private List<SubjectDTO> subjects;

    // Acá no incluyo validaciones ya que se calculará a partir de la lista de materias.
    private Double averageScore;

    // Acá no incluyo validaciones ya que se agrega al momento de calcular el averageScore.
    private String message;
}
