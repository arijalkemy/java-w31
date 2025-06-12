package com.bootcamp.ejercicio_qatesters.service;

import com.bootcamp.ejercicio_qatesters.dto.TestCaseDto;
import java.util.List;

public interface ITestCaseService {
  void createTestCase(TestCaseDto testCaseDto);
  List<TestCaseDto> listAllTestCases();
  TestCaseDto findTestCaseById(long id);
  void updateTestCase(TestCaseDto testCaseDto);
  void deleteTestCaseById(long id);
  List<TestCaseDto> findAllTestCasesByLastUpdate(String lastUpdate);
}
