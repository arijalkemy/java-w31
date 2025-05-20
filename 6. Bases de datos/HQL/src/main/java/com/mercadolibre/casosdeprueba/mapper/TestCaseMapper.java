package com.mercadolibre.casosdeprueba.mapper;

import com.mercadolibre.casosdeprueba.dto.TestCaseDto;
import com.mercadolibre.casosdeprueba.model.TestCase;

public class TestCaseMapper {
    static public TestCaseDto toTestCaseDto(TestCase testCase) {
        return new TestCaseDto(testCase.getDescription(), testCase.getTested(), testCase.getPassed(), testCase.getNumber_of_tries(), testCase.getId_tester());
    }

    static public TestCase toTestCase(TestCaseDto testCaseDto) {
        return new TestCase(null, testCaseDto.getDescription(), testCaseDto.getTested(), testCaseDto.getPassed(), testCaseDto.getNumber_of_tries(), null, testCaseDto.getId_tester());
    }
}
