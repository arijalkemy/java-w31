package com.bootcamp.qatester.controller;

import com.bootcamp.qatester.model.TestCase;
import com.bootcamp.qatester.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    private final TestCaseService testCaseService;

    TestCaseController(TestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    @PostMapping("/new")
    public ResponseEntity<TestCase> createTestCase(@RequestBody TestCase testCase) {
        TestCase created = testCaseService.saveTestCase(testCase);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public List<TestCase> getAllTestCases() {
        return testCaseService.getAllTestCases();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCase> getTestCaseById(@PathVariable Long id) {
        Optional<TestCase> testCase = testCaseService.getTestCaseById(id);
        return testCase.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCase> updateTestCase(@PathVariable Long id, @RequestBody TestCase testCaseDetails) {
        return testCaseService.getTestCaseById(id)
                .map(existingTestCase -> {
                    existingTestCase.setDescription(testCaseDetails.getDescription());
                    existingTestCase.setTested(testCaseDetails.getTested());
                    existingTestCase.setPassed(testCaseDetails.getPassed());
                    existingTestCase.setNumberOfTries(testCaseDetails.getNumberOfTries());
                    existingTestCase.setLastUpdate(testCaseDetails.getLastUpdate());
                    TestCase updated = testCaseService.saveTestCase(existingTestCase);
                    return ResponseEntity.ok(updated);
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTestCase(@PathVariable Long id) {
        if (testCaseService.getTestCaseById(id).isPresent()) {
            testCaseService.deleteTestCaseById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(params = "last_update")
    public List<TestCase> filterByLastUpdate(@RequestParam("last_update") String lastUpdate) {
        LocalDate date = LocalDate.parse(lastUpdate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return testCaseService.findTestCasesByLastUpdateAfter(date);
    }
}