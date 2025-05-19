package com.mercadolibre.qatester.service;

import com.mercadolibre.qatester.dto.TestCaseDto;
import com.mercadolibre.qatester.modal.TestCase;
import com.mercadolibre.qatester.repository.ITestCaseRepository;
import com.mercadolibre.qatester.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TestCaseServiceImpl  implements ITestCaseService {

    @Autowired
    private ITestCaseRepository repository;

    public TestCase create(TestCase testCase) {
        return repository.save(testCase);
    }

    public List<TestCase> getAll() {
        return repository.findAll();
    }

    public TestCaseDto getById(Long id) {
        Optional<TestCase> testCase=repository.findById(id);
        return testCase.map(Mapper::toDto).orElse(null);


    }

    public TestCase update(Long id, TestCase testCase) {
        testCase.setId_case(id);
        return repository.save(testCase);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<TestCase> findByLastUpdateAfter(LocalDate date) {
        return repository.findByLastUpdateAfter(date);
    }
}