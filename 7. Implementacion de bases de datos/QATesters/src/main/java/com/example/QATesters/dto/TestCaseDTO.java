package com.example.QATesters.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TestCaseDTO {
    private Long id;
    private String description;
    private Boolean tested;
    private Boolean passed;
    private int numberOfTries;
    private LocalDate lastUpdate;

    public TestCaseDTO(Object o, String loginTest, boolean b, boolean b1, int i, LocalDate now) {
    }
}
