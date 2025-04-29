package com.meli.obtenerdiploma.model;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class StudentDTO {
    @Size(min = 4, max = 10, message = "Mas de cuatro caracteres o menos de treinta.")
    String studentName;
    String message;
    Double averageScore;
    List<SubjectDTO> subjects;
}
