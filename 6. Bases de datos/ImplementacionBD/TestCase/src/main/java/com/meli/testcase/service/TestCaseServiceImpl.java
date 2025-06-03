package com.meli.testcase.service;

import com.meli.testcase.entity.TestCase;
import com.meli.testcase.repository.TestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TestCaseServiceImpl implements TestCaseService {

    @Autowired
    private TestCaseRepository testCaseRepository;

    @Override
    public TestCase createTestCase(TestCase testCase) {
        return testCaseRepository.save(testCase);
    }

    @Override
    public List<TestCase> getAllTestCase() {
        return testCaseRepository.findAll();
    }

    @Override
    public TestCase getTestCaseById(long id) {
        return testCaseRepository.findById(id).orElse(null);
    }

    @Override
    public String updateTestCase(Long id, TestCase testCaseDetails) {
        TestCase testCaseOriginal = this.getTestCaseById(id);

        testCaseOriginal.setDescription(testCaseDetails.getDescription());
        testCaseOriginal.setTested(testCaseDetails.getTested());
        testCaseOriginal.setPassed(testCaseDetails.getPassed());
        testCaseOriginal.setNumberOfTries(testCaseDetails.getNumberOfTries());
        testCaseOriginal.setLastUpdate(testCaseDetails.getLastUpdate());

        this.createTestCase(testCaseOriginal);
        return "Modificaciones guardadas correctamente";
    }

    @Override
    public void deleteTestCase(Long id) {
        testCaseRepository.findById(id).ifPresent(testCaseRepository::delete);
    }
}
