package com.mercadolibre.qatesters.controller;

import com.mercadolibre.qatesters.dto.TestCaseDto;
import com.mercadolibre.qatesters.service.ITestCaseService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    private ITestCaseService testCaseService;

    public TestCaseController(ITestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    @GetMapping()
    public ResponseEntity<List<TestCaseDto>> getTestCases(
            @RequestParam(value = "last_update", required = false)
            @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate lastUpdate) {
        List<TestCaseDto> testCases;
        if (lastUpdate != null) {
            testCases = testCaseService.getTestCasesUpdatedAfter(lastUpdate);
        } else {
            testCases = testCaseService.getTestCases();
        }
        return ResponseEntity.ok(testCases);
    }

    @PostMapping("/new")
    public ResponseEntity<TestCaseDto> createTestCase(@RequestBody TestCaseDto testCaseDto) {
        return new ResponseEntity<>(testCaseService.createTestCase(testCaseDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseDto> getTestCaseById(@PathVariable Long id) {
        return ResponseEntity.ok(testCaseService.getTestCase(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCaseDto> updateTestCase(@PathVariable Long id, @RequestBody TestCaseDto testCaseDto) {
        return ResponseEntity.ok(testCaseService.updateTestCase(id, testCaseDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTestCase(@PathVariable Long id) {
        testCaseService.deleteTestCase(id);
        return ResponseEntity.ok("Deleted test case");
    }

}
