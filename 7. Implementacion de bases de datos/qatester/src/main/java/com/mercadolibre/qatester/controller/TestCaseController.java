package com.mercadolibre.qatester.controller;

import com.mercadolibre.qatester.dto.TestCaseDto;
import com.mercadolibre.qatester.modal.TestCase;
import com.mercadolibre.qatester.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    @Autowired
    private ITestCaseService service;

    // POST /api/testcases/new
    @PostMapping("/new")
    public TestCase create(@RequestBody TestCase testCase) {
        return service.create(testCase);
    }

    // GET /api/testcases
    @GetMapping
    public List<TestCase> getAll(@RequestParam(name = "last_update", required = false)
                                 @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate lastUpdate) {
        if (lastUpdate != null) {
            return service.findByLastUpdateAfter(lastUpdate);
        }
        return service.getAll();
    }

    // GET /api/testcases/{id}
    @GetMapping("/{id}")
    public TestCaseDto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // PUT /api/testcases/{id}
    @PutMapping("/{id}")
    public TestCase update(@PathVariable Long id, @RequestBody TestCase testCase) {
        return service.update(id, testCase);
    }

    // DELETE /api/testcases/{id}
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}