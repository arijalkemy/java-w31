package com.mercadolibre.qatester.service;

import com.mercadolibre.qatester.dto.TestCaseDto;
import com.mercadolibre.qatester.modal.TestCase;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ITestCaseService {
    TestCase create(TestCase testCase);
    List<TestCase> getAll();
    TestCaseDto getById(Long id);
    TestCase update(Long id, TestCase testCase);
    void delete(Long id);
    List<TestCase> findByLastUpdateAfter(LocalDate date);
}