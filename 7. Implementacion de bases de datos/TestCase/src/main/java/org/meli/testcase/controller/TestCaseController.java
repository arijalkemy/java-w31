package org.meli.testcase.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.meli.testcase.dto.TestCaseDto;
import org.meli.testcase.service.ITestCaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    private final ITestCaseService testCaseService;

    @PostMapping("/new")
    public ResponseEntity<TestCaseDto> createTestCase(@Valid @RequestBody TestCaseDto testCaseDto) {
        return new ResponseEntity<>(testCaseService.createTestCase(testCaseDto), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<TestCaseDto>> getTestCases(
            @RequestParam(value = "last_update", required = false) String lastUpdateString) {
        return new ResponseEntity<>(testCaseService.getTestCasesFiltered(lastUpdateString), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseDto> getTestCaseById(@PathVariable Long id) {
        return new ResponseEntity<>(testCaseService.getTestCaseById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<TestCaseDto> updateTestCase(@PathVariable Long id, @Valid @RequestBody TestCaseDto testCaseDto) {
        return new ResponseEntity<>(testCaseService.updateTestCase(id, testCaseDto), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<TestCaseDto> deleteTestCase(@PathVariable Long id) {
        testCaseService.deleteTestCase(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
