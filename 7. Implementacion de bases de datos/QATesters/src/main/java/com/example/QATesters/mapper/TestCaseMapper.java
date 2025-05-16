package com.example.QATesters.mapper;

import com.example.QATesters.dto.TestCaseDTO;
import com.example.QATesters.model.TestCase;

import java.time.LocalDate;

public class TestCaseMapper {
    public static TestCaseDTO toDTO(TestCase testCase) {
        TestCaseDTO dto = new TestCaseDTO();
        dto.setId(testCase.getId());
        dto.setDescription(testCase.getDescription());
        dto.setTested(testCase.getTested());
        dto.setPassed(testCase.getPassed());
        dto.setNumberOfTries(testCase.getNumberOfTries());
        dto.setLastUpdate(testCase.getLastUpdate());
        return dto;
    }

    public static TestCase toEntity(TestCaseDTO dto) {
        TestCase testCase = new TestCase();
        testCase.setId(dto.getId());
        testCase.setDescription(dto.getDescription());
        testCase.setTested(dto.getTested());
        testCase.setPassed(dto.getPassed());
        testCase.setNumberOfTries(dto.getNumberOfTries());
        testCase.setLastUpdate(dto.getLastUpdate());
        return testCase;
    }
}
