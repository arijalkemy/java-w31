package com.bootcamp.qatesters.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import com.bootcamp.qatesters.model.TestCase;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class TestCaseDto implements Serializable {
    @Positive
    private Long idCase;

    @NotNull(message = "La descripción no puede ser nula")
    @Size(min = 2, max = 100, message = "La descripción debe tener entre 2 y 100 caracteres")
    private String description;

    @NotNull(message = "El número de intentos no puede ser nulo")
    @PositiveOrZero(message = "El número de intentos debe ser mayor o igual a cero")
    private Integer numberOfTries;
    
    private Boolean tested;
    private Boolean passed;

    Date lastUpdate;

    public static TestCaseDto testCaseToDto(TestCase testCase) {
        return new TestCaseDto(
            testCase.getIdCase(),
            testCase.getDescription(),
            testCase.getNumberOfTries(),
            testCase.getTested(),
            testCase.getPassed(),
            testCase.getLastUpdate()
        );
    }
}