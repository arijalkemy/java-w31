package com.example.qatesters.service;

import com.example.qatesters.dto.ResponseDTO;
import com.example.qatesters.dto.TestCaseDTO;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    List<TestCaseDTO> getTestCases();
    TestCaseDTO saveTestCase(TestCaseDTO testCase);
    ResponseDTO deleteTestCase(Long id);
    TestCaseDTO modifyTestCase(Long id, TestCaseDTO modifyTestCase);
    TestCaseDTO getTestCaseById(Long id);
    List<TestCaseDTO> getTestCasesByDate(LocalDate date);
}
