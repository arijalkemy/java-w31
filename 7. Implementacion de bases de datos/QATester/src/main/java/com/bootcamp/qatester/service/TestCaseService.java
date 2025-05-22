package com.bootcamp.qatester.service;

import com.bootcamp.qatester.model.TestCase;
import com.bootcamp.qatester.repository.TestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TestCaseService {

    private final TestCaseRepository testCaseRepository;

    TestCaseService(TestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
    }

    public TestCase saveTestCase(TestCase testCase) {
        return testCaseRepository.save(testCase);
    }

    public List<TestCase> getAllTestCases() {
        return testCaseRepository.findAll();
    }

    public Optional<TestCase> getTestCaseById(Long id) {
        return testCaseRepository.findById(id);
    }

    public void deleteTestCaseById(Long id) {
        testCaseRepository.deleteById(id);
    }

    public List<TestCase> findTestCasesByLastUpdateAfter(LocalDate date) {
        return testCaseRepository.findByLastUpdateAfter(date);
    }
}