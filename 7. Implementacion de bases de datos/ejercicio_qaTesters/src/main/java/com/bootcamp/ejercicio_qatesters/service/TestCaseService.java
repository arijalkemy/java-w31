package com.bootcamp.ejercicio_qatesters.service;

import com.bootcamp.ejercicio_qatesters.dto.TestCaseDto;
import com.bootcamp.ejercicio_qatesters.exception.NotFoundException;
import com.bootcamp.ejercicio_qatesters.model.TestCase;
import com.bootcamp.ejercicio_qatesters.repository.ITestCaseRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TestCaseService implements ITestCaseService {
  private final ITestCaseRepository testCaseRepository;

  public TestCaseService(ITestCaseRepository testCaseRepository) {
    this.testCaseRepository = testCaseRepository;
  }

  @Override
  public void createTestCase(TestCaseDto testCaseDto) {
    testCaseRepository.save(new ObjectMapper().convertValue(testCaseDto, TestCase.class));
  }

  @Override
  public List<TestCaseDto> listAllTestCases() {
    return new ObjectMapper()
        .convertValue(testCaseRepository.findAll(), new TypeReference<List<TestCaseDto>>() {});
  }

  @Override
  public TestCaseDto findTestCaseById(long id) {
    TestCase testCase = getTestCaseById(id);
    return new ObjectMapper().convertValue(testCase, TestCaseDto.class);
  }

  private TestCase getTestCaseById(Long id) {
    return testCaseRepository
        .findById(id)
        .orElseThrow(() -> new NotFoundException("No se encontró el test case"));
  }

  @Override
  public void updateTestCase(TestCaseDto testCaseDto) {
    TestCase testCase = getTestCaseById(testCaseDto.getId());
    updateTestCase(testCaseDto, testCase);
    testCaseRepository.save(testCase);
  }

  private static void updateTestCase(TestCaseDto testCaseDto, TestCase testCase) {
    testCase.setDescription(testCaseDto.getDescription());
    testCase.setTested(testCaseDto.getTested());
    testCase.setPassed(testCaseDto.getPassed());
    testCase.setNumberTries(testCaseDto.getNumberTries());
    testCase.setLastUpdate(testCaseDto.getLastUpdate());
  }

  @Override
  public void deleteTestCaseById(long id) {
    testCaseRepository.deleteById(id);
  }

  @Override
  public List<TestCaseDto> findAllTestCasesByLastUpdate(String lastUpdate) {
    List<TestCaseDto> testCaseDtos = testCaseRepository.findByLastUpdate((LocalDate.parse(lastUpdate)));
    return new ObjectMapper().convertValue(testCaseDtos, new TypeReference<List<TestCaseDto>>() {});
  }
}
