package com.example.QATesters.controller;

import com.example.QATesters.model.TestResult;
import com.example.QATesters.service.TestResultService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/testresults")
public class TestResultController {
    private final TestResultService service;

    public TestResultController(TestResultService service) {
        this.service = service;
    }

    @PostMapping("/new")
    public TestResult createTestResult(@RequestBody TestResult result) {
        return service.createTestResult(result);
    }

    @GetMapping("/{id}")
    public TestResult getTestResultById(@PathVariable Long id) {
        return service.getTestResultById(id);
    }
}
