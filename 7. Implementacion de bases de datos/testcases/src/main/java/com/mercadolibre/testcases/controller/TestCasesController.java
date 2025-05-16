package com.mercadolibre.testcases.controller;

import com.mercadolibre.testcases.dto.TestCaseDto;
import com.mercadolibre.testcases.service.ITestCaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/testcases")
public class TestCasesController {
    private final ITestCaseService testCaseService;

    public TestCasesController(ITestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    @PostMapping("/new")
    public ResponseEntity<TestCaseDto> createTestCase(@RequestBody TestCaseDto testCaseDto) {
        return new ResponseEntity<>(testCaseService.save(testCaseDto), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<TestCaseDto>> getAllTestCases() {
        return new ResponseEntity<>(testCaseService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseDto> getTestCaseById(@PathVariable Long id) {
        TestCaseDto testCaseDto = testCaseService.findById(id);
        return new ResponseEntity<>(testCaseDto, testCaseDto != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCaseDto> updateTestCase(@PathVariable Long id, @RequestBody TestCaseDto testCaseDto) {
        testCaseDto.setId(id);
        TestCaseDto updatedTestCase = testCaseService.update(testCaseDto);
        return new ResponseEntity<>(updatedTestCase, updatedTestCase != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTestCase(@PathVariable Long id) {
        testCaseService.delete(id);
        return new ResponseEntity<>("Test case with id " + id + " successfully deleted", HttpStatus.OK);
    }

    @GetMapping("/by")
    public ResponseEntity<List<TestCaseDto>> getTestCasesByLastUpdate(@RequestParam String lastUpdate) {
        return new ResponseEntity<>(testCaseService.findAllByLastUpdate(lastUpdate), HttpStatus.OK);
    }
}
