package com.example.qatest.controller;

import com.example.qatest.model.dto.TestDTO; // Keep using TestDTO for TestCase representation
import com.example.qatest.model.entity.TestExecutionResult; // Potentially return this or a DTO of it
import com.example.qatest.model.request.AddTestResultRequest;
import com.example.qatest.model.request.NewTestRequest; // Simplified
import com.example.qatest.service.TestsCasesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
@AllArgsConstructor
public class TestCasesController {

    private TestsCasesService service;

    @PostMapping("/new")
    public ResponseEntity<TestDTO> createNewTestCase(@RequestBody NewTestRequest newTest) {
        TestDTO createdTest = service.createTest(newTest);
        return new ResponseEntity<>(createdTest, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TestDTO>> getAllTestcases() {
        List<TestDTO> testCases = service.getAllTests();
        return new ResponseEntity<>(testCases, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestDTO> getTestcaseById(@PathVariable Long id) {
        TestDTO testCase = service.getTestById(id);
        return new ResponseEntity<>(testCase, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestDTO> updateTestCase(@PathVariable Long id, @RequestBody NewTestRequest updatedTest) {
        TestDTO updated = service.updateTestById(id, updatedTest);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTestCase(@PathVariable Long id) {
        service.deleteTestCaseByID(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/after")
    public ResponseEntity<List<TestDTO>> getTestCasesAfter(@RequestParam("last_update") LocalDate lastUpdate) { // Use @RequestParam name for clarity
        List<TestDTO> testCases = service.getTestCasesAfter(lastUpdate);
        return new ResponseEntity<>(testCases, HttpStatus.OK);
    }

    @PostMapping("/results")
    public ResponseEntity<TestExecutionResult> addTestExecutionResult(@RequestBody AddTestResultRequest request) {
        TestExecutionResult savedResult = service.createTestExecutionResult(request);
        return new ResponseEntity<>(savedResult, HttpStatus.CREATED);
    }
}