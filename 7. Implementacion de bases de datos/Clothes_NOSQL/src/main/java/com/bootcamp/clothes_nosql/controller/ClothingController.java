package com.bootcamp.clothes_nosql.controller;

import com.bootcamp.clothes_nosql.dto.ClothingDTO;
import com.bootcamp.clothes_nosql.service.ClothingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothes")
@RequiredArgsConstructor
public class ClothingController {

    private final ClothingService service;

    @PostMapping
    public ResponseEntity<ClothingDTO> create(@RequestBody ClothingDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<ClothingDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{code}")
    public ResponseEntity<ClothingDTO> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(service.getByCode(code));
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> delete(@PathVariable String code) {
        service.delete(code);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/size/{size}")
    public ResponseEntity<List<ClothingDTO>> getBySize(@PathVariable String size) {
        return ResponseEntity.ok(service.getBySize(size));
    }

    @GetMapping(params = "name")
    public ResponseEntity<List<ClothingDTO>> getByName(@RequestParam String name) {
        return ResponseEntity.ok(service.getByNameContains(name));
    }
}

