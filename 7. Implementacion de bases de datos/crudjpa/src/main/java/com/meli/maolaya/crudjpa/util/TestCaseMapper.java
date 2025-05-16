package com.meli.maolaya.crudjpa.util;

import com.meli.maolaya.crudjpa.dto.TestCaseDto;
import com.meli.maolaya.crudjpa.model.TestCase;

public class TestCaseMapper {
    public static TestCase fromDto(TestCaseDto testCaseDto) {
        return TestCase.builder().description(testCaseDto.getDescription()).tested(testCaseDto.getTested())
                .passed(testCaseDto.getPassed()).numberOfTries(testCaseDto.getNumberOfTries())
                .lastUpdate(testCaseDto.getLastUpdate()).build();
    }

    public static TestCaseDto fromEntity(TestCase testCase) {
        return TestCaseDto.builder().idCase(testCase.getIdCase()).description(testCase.getDescription())
                .tested(testCase.getTested())
                .passed(testCase.getPassed()).numberOfTries(testCase.getNumberOfTries())
                .lastUpdate(testCase.getLastUpdate()).build();
    }
}
