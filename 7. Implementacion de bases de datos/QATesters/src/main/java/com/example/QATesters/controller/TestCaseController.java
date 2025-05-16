package com.example.QATesters.controller;

import com.example.QATesters.dto.TestCaseDTO;
import com.example.QATesters.service.TestCaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {
    private final TestCaseService service;

    public TestCaseController(TestCaseService service) {
        this.service = service;
    }

    // Crear un nuevo caso de prueba
    @PostMapping("/new")
    public ResponseEntity<TestCaseDTO> createTestCase(@RequestBody TestCaseDTO dto) {
        return ResponseEntity.ok(service.createTestCase(dto));
    }

    // Devolver todos los casos de prueba
    @GetMapping
    public List<TestCaseDTO> getAllTestCases() {
        return service.getAllTestCases();
    }

    // Devolver un caso de prueba por id
    @GetMapping("/{id}")
    public ResponseEntity<TestCaseDTO> getTestCaseById(@PathVariable Long id) {
        TestCaseDTO dto = service.getTestCaseById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    // Actualizar un caso de prueba por id
    @PutMapping("/{id}")
    public ResponseEntity<TestCaseDTO> updateTestCase(@PathVariable Long id, @RequestBody TestCaseDTO dto) {
        TestCaseDTO updated = service.updateTestCase(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    // Eliminar un caso de prueba por id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTestCase(@PathVariable Long id) {
        boolean deleted = service.deleteTestCase(id);
        return deleted ? ResponseEntity.ok("Test case deleted") : ResponseEntity.notFound().build();
    }

    // Buscar casos de prueba por última actualización
    @GetMapping("/filter")
    public List<TestCaseDTO> filterByDate(@RequestParam("last_update") String date) {
        return service.findByLastUpdate(date);
    }
}
