package com.example.QATesters.service;

import com.example.QATesters.dto.TestCaseDTO;
import com.example.QATesters.mapper.TestCaseMapper;
import com.example.QATesters.model.TestCase;
import com.example.QATesters.model.TestResult;
import com.example.QATesters.repository.TestCaseRepository;
import com.example.QATesters.repository.TestResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TestCaseService {
    private final TestCaseRepository repository;
    private final TestResultRepository testResultRepository;

    @Autowired
    public TestCaseService(TestCaseRepository testCaseRepository, TestResultRepository testResultRepository) {
        this.repository = testCaseRepository;
        this.testResultRepository = testResultRepository;
    }

    public TestCase createTestCase(TestCase testCase) {
        // Guarda el objeto TestResult primero si no es nulo
        if (testCase.getTestResult() != null) {
            TestResult savedResult = testResultRepository.save(testCase.getTestResult());
            testCase.setTestResult(savedResult);
        }
        return repository.save(testCase);
    }

    public List<TestCaseDTO> getAllTestCases() {
        return repository.findAll().stream().map(TestCaseMapper::toDTO).collect(Collectors.toList());
    }

    public TestCaseDTO getTestCaseById(Long id) {
        Optional<TestCase> testCase = repository.findById(id);
        return testCase.map(TestCaseMapper::toDTO).orElse(null);
    }

    public TestCaseDTO updateTestCase(Long id, TestCaseDTO dto) {
        Optional<TestCase> existingTestCase = repository.findById(id);
        if (existingTestCase.isPresent()) {
            TestCase updated = existingTestCase.get();
            updated.setDescription(dto.getDescription());
            updated.setTested(dto.isTested());
            updated.setPassed(dto.isPassed());
            updated.setNumberOfTries(dto.getNumberOfTries());
            return TestCaseMapper.toDTO(repository.save(updated));
        }
        return null;
    }

    public boolean deleteTestCase(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<TestCaseDTO> findByLastUpdate(String date) {
        LocalDate parsedDate = LocalDate.parse(date);
        return repository.findByLastUpdateAfter(parsedDate).stream().map(TestCaseMapper::toDTO).collect(Collectors.toList());
    }
}
