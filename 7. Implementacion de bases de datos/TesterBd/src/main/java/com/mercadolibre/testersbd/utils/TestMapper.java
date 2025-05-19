package com.mercadolibre.testersbd.utils;

import com.mercadolibre.testersbd.dto.TestCaseDto;
import com.mercadolibre.testersbd.model.TestCase;

public class TestMapper {
    public static TestCaseDto toDto(TestCase testCase) {
        if (testCase == null) return null;
        TestCaseDto dto = new TestCaseDto();
        dto.setNumberOfTries(testCase.getId());
        dto.setDescription(testCase.getDescription());
        dto.setTested(testCase.getTested());
        dto.setPassed(testCase.getPassed());
        dto.setNumberOfTries(testCase.getNumberOfTries());
        return dto;
    }
}
