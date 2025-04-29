package com.meli.obtenerdiploma.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    Integer id;
    @NotBlank(message = "El nombre del estudiante es obligatorio")
    String studentName;
    String message;
    Double averageScore;

    @NotNull(message = "La Lista de materias debe ser obligatoria")
    @Size(message = "Debe contener al menos una materia")
    @Valid
    List<SubjectDTO> subjects;

}
