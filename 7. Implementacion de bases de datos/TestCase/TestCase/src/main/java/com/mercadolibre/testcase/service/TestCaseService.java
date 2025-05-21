package com.mercadolibre.testcase.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.testcase.dto.TestCaseDTO;
import com.mercadolibre.testcase.models.TestCase;
import com.mercadolibre.testcase.repository.ITestCaseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TestCaseService implements ITestCaseService {

    private final ITestCaseRepository repository;
    private final ObjectMapper mapper;

    public TestCaseService(ITestCaseRepository repository){
        this.repository = repository;
        this.mapper = new ObjectMapper();
        this.mapper.registerModule(new JavaTimeModule());
    }

    @Override
    public void newTestCase(TestCaseDTO testCaseDTO) {
        TestCase testCase = mapper.convertValue(testCaseDTO, TestCase.class);
        repository.save(testCase);
    }

    @Override
    public List<TestCaseDTO> getAllTestCases() {
        return repository.findAll().stream()
                .map(t -> mapper.convertValue(t, TestCaseDTO.class))
                .toList();
    }

    @Override
    public TestCaseDTO getTestCaseById(Long id) {
        Optional<TestCase> testCase = repository.findById(id);
        return testCase.map(t -> mapper.convertValue(t, TestCaseDTO.class)).orElse(null);
    }

    @Override
    public void updateTestCase(Long id, TestCaseDTO testCaseDTO) {
        Optional<TestCase> testCase = repository.findById(id);
        if(testCase.isPresent()) {
            TestCase testCaseObtained = testCase.get();
            testCaseObtained.setDescription(testCaseDTO.getDescription());
            testCaseObtained.setTested(testCaseDTO.getTested());
            testCaseObtained.setPassed(testCaseDTO.getPassed());
            testCaseObtained.setNumberOfTries(testCaseDTO.getNumberOfTries());
            testCaseObtained.setLastUpdate(LocalDate.now());
            repository.save(testCaseObtained);
        }
    }

    @Override
    public void deleteTestCaseById(Long id) {
        Optional<TestCase> testCase = repository.findById(id);
        testCase.ifPresent(repository::delete);
    }

    @Override
    public List<TestCaseDTO> getTestCaseByLastUpdate(LocalDate lastUpdate) {
        List<TestCase> testCases = repository.findByLastUpdateGreaterThanEqual(lastUpdate);
        return testCases.stream()
                .map(t -> mapper.convertValue(t, TestCaseDTO.class))
                .toList();
    }
}