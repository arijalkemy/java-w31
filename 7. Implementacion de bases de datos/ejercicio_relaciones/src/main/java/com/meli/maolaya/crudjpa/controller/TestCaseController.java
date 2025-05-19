package com.meli.maolaya.crudjpa.controller;

import org.springframework.web.bind.annotation.RestController;

import com.meli.maolaya.crudjpa.dto.TestCaseDto;
import com.meli.maolaya.crudjpa.service.ITestCaseService;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class TestCaseController {

    @Autowired
    private ITestCaseService testCaseService;

    @PostMapping("/api/testcases/new")
    public ResponseEntity<Void> postNewTestCase(@RequestBody TestCaseDto testCaseDto) {
        testCaseService.saveTestCase(testCaseDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/api/testcases")
    public ResponseEntity<List<TestCaseDto>> getTestCasesAfterDate(
            @RequestParam(value = "last_update", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate date) {
        if (date != null) {
            return ResponseEntity.ok(testCaseService.getByDate(date));
        }
        return ResponseEntity.ok(testCaseService.getTestCases());
    }

    @GetMapping("/api/testcases/{id}")
    public ResponseEntity<TestCaseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(testCaseService.getTestCaseById(id));
    }

    @PutMapping("/api/testcases/{id}")
    public ResponseEntity<TestCaseDto> putById(@PathVariable Long id, @RequestBody TestCaseDto testCaseDto) {
        return ResponseEntity.ok(testCaseService.saveTestCase(id, testCaseDto));
    }

    @DeleteMapping("/api/testcases/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        testCaseService.deleteTestCase(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
