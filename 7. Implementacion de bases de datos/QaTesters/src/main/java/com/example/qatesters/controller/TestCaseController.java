package com.example.qatesters.controller;

import com.example.qatesters.dto.ResponseDTO;
import com.example.qatesters.dto.TestCaseDTO;
import com.example.qatesters.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/api/testcase")
public class TestCaseController {
    @Autowired
    private ITestCaseService testCaseService;

    @PostMapping("/new")
    public ResponseEntity<TestCaseDTO> postTestCase(@RequestBody TestCaseDTO testCaseDTO){
        return new ResponseEntity<>(testCaseService.saveTestCase(testCaseDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TestCaseDTO>> getTestCases(){
        return new ResponseEntity<>(testCaseService.getTestCases(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseDTO> getTestCaseById(@PathVariable Long id){
        return new ResponseEntity<>(testCaseService.getTestCaseById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCaseDTO> putTestCase(@PathVariable Long id,
                                                    @RequestBody TestCaseDTO modifyTestCase){
        return new ResponseEntity<>(testCaseService.modifyTestCase(id, modifyTestCase), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deleteTestCaseById(@PathVariable Long id){
        return new ResponseEntity<>(testCaseService.deleteTestCase(id), HttpStatus.OK);
    }

    @GetMapping("/date")
    public ResponseEntity<List<TestCaseDTO>> getTestCasesByDate(@RequestParam LocalDate date){
        return new ResponseEntity<>(testCaseService.getTestCasesByDate(date), HttpStatus.OK);
    }


}
