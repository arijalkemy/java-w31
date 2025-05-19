package com.mercadolibre.qatesters.service;


import com.mercadolibre.qatesters.dto.TestCaseDto;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {

    TestCaseDto createTestCase(TestCaseDto testCaseDto);
    List<TestCaseDto> getTestCases();
    TestCaseDto getTestCase(Long id);
    TestCaseDto updateTestCase(Long id, TestCaseDto testCaseDto);
    void deleteTestCase(Long id);

    List<TestCaseDto> getTestCasesUpdatedAfter(LocalDate lastUpdate);
}
