package com.mercadolibre.qatesters.service;

import com.mercadolibre.qatesters.model.TestCase;
import com.mercadolibre.qatesters.repository.ITestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TestCaseService {

    @Autowired
    private ITestCaseRepository repository;

    public TestCase create(TestCase testCase) {
        return repository.save(testCase);
    }

    public List<TestCase> getAll() {
        return repository.findAll();
    }

    public TestCase getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Test case not found"));
    }

    public TestCase update(Long id, TestCase newTestCase) {
        return repository.findById(id)
                .map(testCase -> {
                    testCase.setDescription(newTestCase.getDescription());
                    testCase.setTested(newTestCase.getTested());
                    testCase.setPassed(newTestCase.getPassed());
                    testCase.setNumberOfTries(newTestCase.getNumberOfTries());
                    testCase.setLastUpdate(newTestCase.getLastUpdate());
                    return repository.save(testCase);
                }).orElseThrow(() -> new RuntimeException("Test case not found"));
    }

    public void delete(Long id) {
            repository.deleteById(id);
    }

    public List<TestCase> filterByDate(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(dateStr, formatter);
        return repository.findByLastUpdateAfter(date);
    }
}
