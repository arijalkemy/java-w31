package com.example.elastic.controller;

import com.example.elastic.dto.ArticuloDTO;
import com.example.elastic.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articulos")
public class ArticuloController {

    @Autowired
    private ArticuloService articuloService;

    @GetMapping
    public ResponseEntity<List<ArticuloDTO>> findAll() {
        return ResponseEntity.ok(articuloService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticuloDTO> findById(@PathVariable String id) {
        return ResponseEntity.ok(articuloService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ArticuloDTO> save(@RequestBody ArticuloDTO articuloDTO) {
        return ResponseEntity.ok(articuloService.save(articuloDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArticuloDTO> update(@PathVariable String id, @RequestBody ArticuloDTO articuloDTO) {
        return ResponseEntity.ok(articuloService.update(id, articuloDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        articuloService.delete(id);
        return ResponseEntity.noContent().build();
    }
} 