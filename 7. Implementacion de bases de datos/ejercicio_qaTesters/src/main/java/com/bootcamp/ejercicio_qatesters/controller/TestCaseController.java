package com.bootcamp.ejercicio_qatesters.controller;

import com.bootcamp.ejercicio_qatesters.dto.TestCaseDto;
import com.bootcamp.ejercicio_qatesters.service.ITestCaseService;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {
  private final ITestCaseService testCaseService;

  public TestCaseController(ITestCaseService testCaseService) {
    this.testCaseService = testCaseService;
  }

  @PostMapping("/new")
  public ResponseEntity<Void> createTestCase(TestCaseDto testCaseDto) {
    testCaseService.createTestCase(testCaseDto);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<TestCaseDto>> findAll() {
    return new ResponseEntity<>(testCaseService.listAllTestCases(), HttpStatus.OK);
  }

  @GetMapping("{id}")
  public ResponseEntity<TestCaseDto> findById(@PathVariable Long id) {
    return new ResponseEntity<>(testCaseService.findTestCaseById(id), HttpStatus.OK);
  }

  @PutMapping("{id}")
  public ResponseEntity<TestCaseDto> updateTestCase(@PathVariable Long id, @RequestBody TestCaseDto testCaseDto) {
    testCaseService.updateTestCase(testCaseDto);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Void> deleteTestCase(@PathVariable Long id) {
    testCaseService.deleteTestCaseById(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
