package com.example.QATesters.service;

import com.example.QATesters.model.TestResult;
import com.example.QATesters.repository.TestResultRepository;
import org.springframework.stereotype.Service;

@Service
public class TestResultService {
    private final TestResultRepository repository;

    public TestResultService(TestResultRepository repository) {
        this.repository = repository;
    }

    public TestResult createTestResult(TestResult result) {
        return repository.save(result);
    }

    public TestResult getTestResultById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
