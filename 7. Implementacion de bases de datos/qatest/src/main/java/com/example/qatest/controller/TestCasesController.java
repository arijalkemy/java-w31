package com.example.qatest.controller;

import com.example.qatest.model.request.NewTestRequest;
import com.example.qatest.service.TestsCasesService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/testcases")
public class TestCasesController {

    TestsCasesService service;

    @PostMapping("/new")
    public ResponseEntity<?> createNewTestCase(@RequestBody NewTestRequest newTest) {
        return new ResponseEntity<>(service.createTest(newTest), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllTestcases() {
        return new ResponseEntity<>(service.getAllTests(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTestcaseById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getTestById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTestCase(@PathVariable Long id, @RequestBody NewTestRequest updatedTest) {
        return new ResponseEntity<>(service.updateTestById(id, updatedTest), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTestCase(@PathVariable Long id) {
        service.deleteTestCaseByID(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> deleteTestCase(@RequestParam LocalDate last_update) {
        return new ResponseEntity<>(service.getTestCasesAfter(last_update), HttpStatus.OK);
    }

}
