package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter @Setter
public class StudentDTO {
    @NotBlank String studentName;
    @NotBlank String message;
    @NotNull Double averageScore;
    List<@NotBlank SubjectDTO> subjects;
}
