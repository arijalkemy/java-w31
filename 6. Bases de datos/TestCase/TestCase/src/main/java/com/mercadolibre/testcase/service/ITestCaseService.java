package com.mercadolibre.testcase.service;

import com.mercadolibre.testcase.dto.TestCaseDTO;
import com.mercadolibre.testcase.models.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    void newTestCase(TestCaseDTO testCaseDTO);

    List<TestCaseDTO> getAllTestCases();

    TestCaseDTO getTestCaseById(Long id);

    void updateTestCase(Long id, TestCaseDTO testCaseDTO);

    void deleteTestCaseById (Long id);

    List<TestCaseDTO> getTestCaseByLastUpdate(LocalDate lastUpdate);
}
