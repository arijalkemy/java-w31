package com.meli.maolaya.crudjpa.service;

import java.time.LocalDate;
import java.util.List;

import com.meli.maolaya.crudjpa.dto.TestCaseDto;

public interface ITestCaseService {

    void saveTestCase(TestCaseDto testCaseDto);

    List<TestCaseDto> getTestCases();

    TestCaseDto getTestCaseById(Long id);

    TestCaseDto saveTestCase(Long id, TestCaseDto testCaseDto);

    void deleteTestCase(Long id);

    List<TestCaseDto> getByDate(LocalDate date);

}
