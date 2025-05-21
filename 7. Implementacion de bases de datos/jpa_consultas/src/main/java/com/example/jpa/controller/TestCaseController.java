package com.example.jpa.controller;

import com.example.jpa.dto.TestCaseDto;
import com.example.jpa.service.TestCaseServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TestCaseController {
    private final TestCaseServiceImpl testCaseServiceImpl;

    public TestCaseController(TestCaseServiceImpl testCaseServiceImpl) {
        this.testCaseServiceImpl = testCaseServiceImpl;
    }

    @PostMapping("/testcases/new")
    public ResponseEntity<?> newTestcase(@Valid @RequestBody TestCaseDto testcaseDto) {
        testCaseServiceImpl.save(testcaseDto);
        return new ResponseEntity<>("Test case created successfully", HttpStatus.CREATED);
    }

    @GetMapping("/testcases/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        TestCaseDto testCaseDto = testCaseServiceImpl.getById(id);
        return new ResponseEntity<>(testCaseDto, HttpStatus.OK);
    }

    @PutMapping("/testcases/{id}")
    public ResponseEntity<?> updateTestcase(@Valid @RequestBody TestCaseDto testcaseDto, @PathVariable Long id) {
        testCaseServiceImpl.updateById(testcaseDto, id);
        return new ResponseEntity<>("Test case updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/testcases/{id}")
    public ResponseEntity<?> deleteTestcase(@PathVariable Long id) {
        testCaseServiceImpl.deleteById(id);
        return new ResponseEntity<>("Test case deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/testcases")
    public ResponseEntity<?> getAllTestcases(
            @RequestParam(required = false) Boolean passed,
            @RequestParam(required = false) Boolean tested,
            @RequestParam(required = false) Integer numberOfTries,
            @RequestParam(required = false) String lastUpdate
    ) {
        List<TestCaseDto> testCaseDtoList = testCaseServiceImpl.findAllByFilters(passed, tested, numberOfTries, lastUpdate);
        return new ResponseEntity<>(testCaseDtoList, HttpStatus.OK);
    }
}
