package com.example.demo.dto;

import java.time.LocalDate;

import com.example.demo.model.TestCase;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class TestCaseDto {

    private Long idCase;
    private String description;
    private Boolean tested;
    private Boolean passed;
    private int numberOfTries;
    private LocalDate lastUpdate;

    public TestCase toEntity() {
        TestCase entity = new TestCase();
        entity.setDescription(description);
        entity.setTested(tested);
        entity.setPassed(passed);
        entity.setNumberOfTries(numberOfTries);
        entity.setLastUpdate(lastUpdate);
        return entity;
    }

    public static TestCaseDto toDto( TestCase testCase) {
        return new TestCaseDto(
            testCase.getIdCase(),
            testCase.getDescription(),
            testCase.getTested(),
            testCase.getPassed(),
            testCase.getNumberOfTries(),
            testCase.getLastUpdate()
        );
    }
}
