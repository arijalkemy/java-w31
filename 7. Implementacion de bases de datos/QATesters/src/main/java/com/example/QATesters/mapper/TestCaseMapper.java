package com.example.QATesters.mapper;

import com.example.QATesters.dto.TestCaseDTO;
import com.example.QATesters.model.TestCase;

import java.time.LocalDate;

public class TestCaseMapper {
    public static TestCaseDTO toDTO(TestCase testCase) {
        TestCaseDTO dto = new TestCaseDTO();
        dto.setIdCase(testCase.getIdCase());
        dto.setDescription(testCase.getDescription());
        dto.setTested(testCase.isTested());
        dto.setPassed(testCase.isPassed());
        dto.setNumberOfTries(testCase.getNumberOfTries());
        dto.setLastUpdate(testCase.getLastUpdate());
        return dto;
    }

    public static TestCase toEntity(TestCaseDTO dto) {
        TestCase testCase = new TestCase();
        testCase.setIdCase(dto.getIdCase());
        testCase.setDescription(dto.getDescription());
        testCase.setTested(dto.isTested());
        testCase.setPassed(dto.isPassed());
        testCase.setNumberOfTries(dto.getNumberOfTries());
        testCase.setLastUpdate(dto.getLastUpdate());
        return testCase;
    }
}
