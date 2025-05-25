package com.mercadolibre.testersbd.utils;

import com.mercadolibre.testersbd.dto.TestCaseDto;
import com.mercadolibre.testersbd.model.TestCase;

public class TestMapper {
    public static TestCaseDto toDto(TestCase testCase) {
        if (testCase == null) return null;
        TestCaseDto dto = new TestCaseDto();
        dto.setId(testCase.getId());
        dto.setDescription(testCase.getDescription());
        dto.setTested(testCase.getTested());
        dto.setPassed(testCase.getPassed());
        dto.setNumberOfTries(testCase.getNumberOfTries());
        return dto;
    }

    public static TestCase toEntity(TestCaseDto dto) {
        if (dto == null) return null;
        TestCase testCase = new TestCase();
        testCase.setId(dto.getId());
        testCase.setDescription(dto.getDescription());
        testCase.setTested(dto.getTested());
        testCase.setPassed(dto.getPassed());
        testCase.setNumberOfTries(dto.getNumberOfTries());
        return testCase;
    }
}
