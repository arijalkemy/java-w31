package com.mercadolibre.qatesters.controller;

import com.mercadolibre.qatesters.model.TestCase;
import com.mercadolibre.qatesters.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    @Autowired
    private TestCaseService service;

    @PostMapping("/new")
    public ResponseEntity<TestCase> create(@RequestBody TestCase testCase) {
        return ResponseEntity.ok(service.create(testCase));
    }

    @GetMapping
    public ResponseEntity<List<TestCase>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCase> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCase> update(@PathVariable Long id, @RequestBody TestCase testCase) {
        return ResponseEntity.ok(service.update(id, testCase));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(params = "last_update")
    public ResponseEntity<List<TestCase>> filterByDate(@RequestParam("last_update") String dateStr) {
        return ResponseEntity.ok(service.filterByDate(dateStr));
    }
}
