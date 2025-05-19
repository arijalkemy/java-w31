package com.mercadolibre.testersbd.service;

import com.mercadolibre.testersbd.dto.ResponseMessageDto;
import com.mercadolibre.testersbd.dto.TestCaseDto;
import com.mercadolibre.testersbd.model.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface TestCaseService {
    List<TestCaseDto> getTestCases();
    TestCaseDto getTestCaseById(Long id_case);
    ResponseMessageDto saveTestCase(TestCase testCase);
    ResponseMessageDto deleteTestCase(Long id_case);
    ResponseMessageDto updateTestCase(TestCaseDto testCaseDto, Long id);
}
