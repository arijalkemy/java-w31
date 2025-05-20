package com.mercadolibre.casosdeprueba.controller;

import com.mercadolibre.casosdeprueba.dto.TestCaseDto;
import com.mercadolibre.casosdeprueba.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    @Autowired
    private ITestCaseService testCaseService;

    @PostMapping("/new")
    public ResponseEntity<?> createTestCase(@RequestBody TestCaseDto testCase) {
        return new ResponseEntity<>(testCaseService.createTestCase(testCase), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<?> getTestCases(@RequestParam(required = false) String last_update) {
        return new ResponseEntity<>(last_update == null || last_update.isBlank() ? testCaseService.getTestCases() : testCaseService.getTestCasesByLastUpdate(last_update), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getTestCaseById(@PathVariable Long id) {
        return new ResponseEntity<>(testCaseService.getTestCasebyId(id), HttpStatus.OK);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<?> updateTestCaseById(@PathVariable Long id, @RequestBody TestCaseDto testCase) {
        return new ResponseEntity<>(testCaseService.updateTestCaseService(id, testCase), HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> deleteTestCaseById(@PathVariable Long id) {
        return new ResponseEntity<>(testCaseService.deleteTestCaseService(id), HttpStatus.OK);
    }
}
