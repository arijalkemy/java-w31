package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.dto.TestCaseDto;

public interface ITestCaseService {
    TestCaseDto createNewTestCase(TestCaseDto testCaseDto);
    List<TestCaseDto> getAllTestCases();
    TestCaseDto getTestCaseById(Long id);
    void deleteTestCaseById(Long id);
    TestCaseDto updateTestCaseById(Long id, TestCaseDto testcaseDto);
    List<TestCaseDto> findTestCasesUpdatedAfter(LocalDate dat);
}
