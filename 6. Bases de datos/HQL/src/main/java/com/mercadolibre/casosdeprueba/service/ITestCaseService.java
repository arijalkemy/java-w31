package com.mercadolibre.casosdeprueba.service;

import com.mercadolibre.casosdeprueba.dto.TestCaseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITestCaseService {
    String createTestCase(TestCaseDto testCase);

    List<TestCaseDto> getTestCases();

    List<TestCaseDto> getTestCasesByLastUpdate(String lastUpdate);

    TestCaseDto getTestCasebyId(Long id);

    TestCaseDto updateTestCaseService(Long id, TestCaseDto testCase);

    String deleteTestCaseService(Long id);
}
