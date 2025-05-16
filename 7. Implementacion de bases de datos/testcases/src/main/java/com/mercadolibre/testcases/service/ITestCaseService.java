package com.mercadolibre.testcases.service;

import com.mercadolibre.testcases.dto.TestCaseDto;

import java.util.List;

public interface ITestCaseService {
    TestCaseDto save(TestCaseDto testCaseDto);
    List<TestCaseDto> findAll();
    TestCaseDto findById(Long id);
    TestCaseDto update(TestCaseDto testCaseDto);
    void delete(Long id);
    //List<TestCaseDto> findByFilter(Boolean passed, Boolean tested, Integer numberOfTries, String lastUpdate);
    List<TestCaseDto> findAllByLastUpdate(String lastUpdate);
}
