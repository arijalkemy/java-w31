package org.mercadolibre.ejercicio_qa_tester.controller;

import org.mercadolibre.ejercicio_qa_tester.entities.TestCase;
import org.mercadolibre.ejercicio_qa_tester.service.TestCaseServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/testcases")
public class TestCasesController {

    private final TestCaseServiceImpl service;

    public TestCasesController(TestCaseServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/new")
    public String createTestCase(@RequestBody TestCase testCase) {
        return service.createTestCase(testCase);
    }

    @GetMapping
    public List<TestCase> getAllTestCases() {
        return service.getAllTestCase();
    }

    @GetMapping("/{id}")
    public TestCase getTestCaseById(@PathVariable Long id) {
        return service.getTestCaseById(id);
    }

    @PutMapping("/{id}")
    public String updateTestCase(@PathVariable Long id, @RequestBody TestCase testCase) {
        return service.updateTestCase(id, testCase);
    }

    // delete
    @DeleteMapping("{id}")
    public String deleteTestCase(@PathVariable Long id) {
        return service.deleteTestCase(id);
    }
}
