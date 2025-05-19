package com.bootcamp.qatesters.service;

import java.util.Date;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.bootcamp.qatesters.dto.TestCaseDto;
import com.bootcamp.qatesters.exception.NotFoundException;
import com.bootcamp.qatesters.model.TestCase;
import com.bootcamp.qatesters.repository.ITestCaseRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TestCaseService implements ITestCaseService {
    private final ITestCaseRepository repository;
    public TestCaseService(ITestCaseRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Long createTestCase(TestCaseDto testCaseDto) {
        ObjectMapper mapper = new ObjectMapper();
        TestCase testCase = mapper.convertValue(testCaseDto, TestCase.class);

        repository.save(testCase);
        return testCase.getIdCase();
    }

    @Override
    @Transactional(readOnly = true) 
    public List<TestCaseDto> getTestCases() {
        List<TestCase> testCase = repository.findAll();
        if (testCase.isEmpty()) {
            throw new NotFoundException("No se encontraron testCases.");
        }

        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(testCase, new TypeReference<List<TestCaseDto>>() {});
    }

    @Override
    @Transactional(readOnly = true) 
    public TestCaseDto getTestCaseById(Long id) {
        TestCase testCase = repository.findById(id).orElse(null);
        if (testCase == null) {
            throw new NotFoundException("No se encontró una testCase de id " + id);
        }
        return TestCaseDto.testCaseToDto(testCase);
    }

    @Override
    @Transactional
    public TestCaseDto updateTestCase(Long id, TestCaseDto testCaseDto) {
        TestCase testCase = repository.findById(id).orElse(null);
        if (testCase == null) {
            throw new NotFoundException("No se encontró una testCase de id " + id);
        }

        testCase.setDescription(testCaseDto.getDescription());
        testCase.setNumberOfTries(testCaseDto.getNumberOfTries());
        testCase.setTested(testCaseDto.getTested());
        testCase.setPassed(testCaseDto.getPassed());
        testCase.setLastUpdate(testCaseDto.getLastUpdate());
        repository.save(testCase);

        testCaseDto.setIdCase(id);
        return testCaseDto;
    }

    @Override
    @Transactional
    public void deleteTestCase(Long id) {
        TestCase testCase = repository.findById(id).orElse(null);
        if (testCase == null) {
            throw new NotFoundException("No se encontró una testCase de id " + id);
        }
        
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true) 
    public List<TestCaseDto> findTestCasesUpdatedAfter(Date lastUpdate) {
        List<TestCase> testCases = repository.findByLastUpdateAfter(lastUpdate);
        if (testCases.isEmpty()) {
            throw new NotFoundException("No se encontraron test cases actualizados luego de " + lastUpdate);
        }

        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(testCases, new TypeReference<List<TestCaseDto>>() {});
    }

}
