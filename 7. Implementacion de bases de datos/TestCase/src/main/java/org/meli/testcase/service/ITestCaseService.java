package org.meli.testcase.service;

import org.meli.testcase.dto.TestCaseDto;

import java.util.List;

public interface ITestCaseService {
    List<TestCaseDto> getAllTestCases();
    TestCaseDto getTestCaseById(Long id);
    TestCaseDto createTestCase(TestCaseDto testCaseDto);
    TestCaseDto updateTestCase(Long id, TestCaseDto testCaseDto);
    void deleteTestCase(Long id);
    List<TestCaseDto> getTestCasesFiltered(String lastUpdate);
}
