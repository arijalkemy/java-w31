package com.bootcamp.qatesters.service;

import java.util.Date;
import java.util.List;

import com.bootcamp.qatesters.dto.TestCaseDto;

public interface ITestCaseService {
    public Long createTestCase(TestCaseDto testCase);
    public List<TestCaseDto> getTestCases();
    public TestCaseDto getTestCaseById(Long id);
    public TestCaseDto updateTestCase(Long id, TestCaseDto testCaseDto);
    public void deleteTestCase(Long id);
    public List<TestCaseDto> findTestCasesUpdatedAfter(Date lastUpdate);
}