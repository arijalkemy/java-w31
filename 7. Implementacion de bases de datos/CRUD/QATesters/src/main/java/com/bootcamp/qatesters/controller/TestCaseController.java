package com.bootcamp.qatesters.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bootcamp.qatesters.dto.TestCaseDto;
import com.bootcamp.qatesters.service.ITestCaseService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/testcases") 
public class TestCaseController {
    @Autowired
    private ITestCaseService service;

    @PostMapping("/new")
    public ResponseEntity<Long> createTestCase(@Valid @RequestBody TestCaseDto testCase) {
        return new ResponseEntity<>(service.createTestCase(testCase), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<TestCaseDto>> getAllTestCases() {
        return new ResponseEntity<>(service.getTestCases(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseDto> getTestCaseById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getTestCaseById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCaseDto> updateTestCase(@Valid @PathVariable Long id, @RequestBody TestCaseDto testCaseDto) {
        return new ResponseEntity<>(service.updateTestCase(id, testCaseDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTestCase(@Valid @PathVariable Long id) {
        service.deleteTestCase(id);
        return new ResponseEntity<>("Test case eliminado con éxito", HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<TestCaseDto>> getTestCasesUpdatedAfter(
            @RequestParam("last_update")
            @DateTimeFormat(pattern = "yyyy-mm-dd") Date lastUpdate) {

        List<TestCaseDto> testCases = service.findTestCasesUpdatedAfter(lastUpdate);
        return new ResponseEntity<>(testCases, HttpStatus.OK);
    }
    

}
