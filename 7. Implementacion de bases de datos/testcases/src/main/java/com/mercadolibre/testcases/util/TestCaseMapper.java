package com.mercadolibre.testcases.util;

import com.mercadolibre.testcases.dto.TestCaseDto;
import com.mercadolibre.testcases.model.TestCase;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TestCaseMapper {
    public static TestCaseDto toTestCaseDto(TestCase testCase) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return new TestCaseDto(
                testCase.getId(),
                testCase.getDescription(),
                testCase.getTested(),
                testCase.getPassed(),
                testCase.getNumberOfTries(),
                testCase.getLastUpdate().format(formatter)
        );
    }

    public static TestCase toTestCase(TestCaseDto dto) {
        return new TestCase(
                dto.getDescription(),
                dto.getTested(),
                dto.getPassed(),
                dto.getNumberOfTries(),
                dto.getLastUpdate() != null
                        && !dto.getLastUpdate().isEmpty()
                        ? LocalDate.parse(dto.getLastUpdate())
                        : LocalDate.now()
        );
    }

    public static List<TestCaseDto> toTestCasesDto(List<TestCase> testCases) {
        return testCases.stream().map(TestCaseMapper::toTestCaseDto).toList();
    }
}
