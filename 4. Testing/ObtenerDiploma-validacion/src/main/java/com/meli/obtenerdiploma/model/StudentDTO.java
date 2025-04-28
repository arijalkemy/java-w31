package com.meli.obtenerdiploma.model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentDTO {
    @NotBlank
    @Size(min = 2, max = 50)
    String studentName;

    @NotBlank
    @Size(min = 2, max = 50)
    String message;

    @DecimalMin(value = "0.0")
    @DecimalMin(value = "10.0")
    Double averageScore;

    @Size(min = 1)
    @Size(max = 10)
    List<SubjectDTO> subjects;
}
