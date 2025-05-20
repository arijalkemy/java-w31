package com.qa_tester.ejercicio_qa.service;

import com.qa_tester.ejercicio_qa.dto.TestCaseDto;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    public TestCaseDto addTestCase(TestCaseDto testCaseDto);
    public List<TestCaseDto> getAllTest();
    public TestCaseDto getTestCaseById(Long testCaseId);
    public TestCaseDto updateTestCase(Long testCaseId, TestCaseDto testCaseDto);
    public void deleteTestCase(Long testCaseId);
    public List<TestCaseDto> getByDate(LocalDate lastUpdate);
}
