package com.mercadolibre.testcase.controllers;

import com.mercadolibre.testcase.dto.TestCaseDTO;
import com.mercadolibre.testcase.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/testcases")
public class TestCaseController {

    @Autowired
    ITestCaseService service;

    @PostMapping("/new")
    public ResponseEntity<Void> newTestCase(@RequestBody TestCaseDTO testCaseDTO) {
        service.newTestCase(testCaseDTO);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("")
    public ResponseEntity<List<TestCaseDTO>> getAllTestCases() {
        return ResponseEntity.ok(service.getAllTestCases());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseDTO> getTestCaseById(@PathVariable Long id){
        return ResponseEntity.ok(service.getTestCaseById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTestCaseById(@PathVariable Long id){
       service.deleteTestCaseById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTestCase(@PathVariable Long id, @RequestBody TestCaseDTO testCaseDTO){
        service.updateTestCase(id, testCaseDTO);
        return ResponseEntity.noContent().build();
    }

    /* e/api/testcases?last_update=’dd/mm/yyyy’*/
    @GetMapping("/lastupdate")
    public ResponseEntity<List<TestCaseDTO>> getTestCaseByLastUpdate( @RequestParam("last_update")
                                                                          @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate lastUpdate){
        return ResponseEntity.ok(service.getTestCaseByLastUpdate(lastUpdate));
    }
}
