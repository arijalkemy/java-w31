package com.qa_tester.ejercicio_qa.controller;

import com.qa_tester.ejercicio_qa.dto.TestCaseDto;
import com.qa_tester.ejercicio_qa.service.ITestCaseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/testcases")
public class TestCaseController {
    private final ITestCaseService testCaseService;

    @PostMapping("/new")
    public ResponseEntity<TestCaseDto> addTestCase(@RequestBody TestCaseDto testCaseDto){
        return ResponseEntity.ok(testCaseService.addTestCase(testCaseDto));
    }

    @GetMapping("/get")
    public ResponseEntity<List<TestCaseDto>> getTestCases(){
        return ResponseEntity.ok(testCaseService.getAllTest());
    }

    @GetMapping("/id/{testCaseId}")
    public ResponseEntity<TestCaseDto> getTestCaseById(@PathVariable Long testCaseId){
        return ResponseEntity.ok(testCaseService.getTestCaseById(testCaseId));
    }

    @PutMapping("/id/{testCaseId}")
    public ResponseEntity<TestCaseDto> updateTestCase(@PathVariable Long testCaseId,
                                                      @RequestBody TestCaseDto testCaseDto){
        return ResponseEntity.ok(testCaseService.updateTestCase(testCaseId, testCaseDto));
    }

    @DeleteMapping("/id/{testCaseId}")
    public ResponseEntity<?> deleteTestCase(@PathVariable Long testCaseId){
        testCaseService.deleteTestCase(testCaseId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/filter")
    public ResponseEntity<List<TestCaseDto>> getByDate(@RequestParam LocalDate last_update){
        return ResponseEntity.ok(testCaseService.getByDate(last_update));
    }
}
