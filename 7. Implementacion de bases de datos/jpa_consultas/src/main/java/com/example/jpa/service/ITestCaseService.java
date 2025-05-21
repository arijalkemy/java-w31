package com.example.jpa.service;

import com.example.jpa.dto.TestCaseDto;

import java.util.List;

public interface ITestCaseService {
    void save(TestCaseDto testCaseDto);
    TestCaseDto getById(Long id);
    void updateById(TestCaseDto testCaseDto, Long id);
    void deleteById(Long id);
    List<TestCaseDto> findAllByFilters(Boolean passed, Boolean tested, Integer numberOfTries, String lastUpdate);
}
