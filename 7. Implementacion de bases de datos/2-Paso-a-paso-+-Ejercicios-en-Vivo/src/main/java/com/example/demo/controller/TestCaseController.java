package com.example.demo.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.TestCaseDto;
import com.example.demo.service.ITestCaseService;
import com.example.demo.service.TestCaseService;

@RestController
@RequestMapping("api/testcases")
public class TestCaseController {
    
    ITestCaseService testCaseService;

    public TestCaseController(TestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    @PostMapping("/new")
    public ResponseEntity<TestCaseDto> postNewTestCase(@RequestBody TestCaseDto testCaseDto){
        return new ResponseEntity<>(testCaseService.createNewTestCase(testCaseDto), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<TestCaseDto>> getAllTestCases(){
        return new ResponseEntity<>(testCaseService.getAllTestCases(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseDto> getTestCaseById(
        @PathVariable Long id
    ){
        return new ResponseEntity<>(testCaseService.getTestCaseById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTestCaseById(
        @PathVariable Long id
    ){
        testCaseService.deleteTestCaseById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCaseDto> updateTestCaseById(
        @PathVariable Long id,
        @RequestBody TestCaseDto testCaseDto
    ){
        return new ResponseEntity<>( testCaseService.updateTestCaseById( id, testCaseDto), HttpStatus.OK);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<TestCaseDto>> getTestCasesByDate(
        @RequestParam String lastUpdate
    ){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(lastUpdate, formatter);

        List<TestCaseDto> updatedTestCases = testCaseService.findTestCasesUpdatedAfter(date);

        return new ResponseEntity<>( updatedTestCases, HttpStatus.OK);
    }

}
