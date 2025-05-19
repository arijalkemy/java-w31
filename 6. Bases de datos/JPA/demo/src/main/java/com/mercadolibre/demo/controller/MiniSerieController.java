package com.mercadolibre.demo.controller;

import com.mercadolibre.demo.dto.MiniSerieDTO;
import com.mercadolibre.demo.services.MiniSerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/miniserie")
public class MiniSerieController {
    @Autowired
    private MiniSerieService miniSerieService;

    @GetMapping
    public ResponseEntity<List<MiniSerieDTO>> getAll() {
        return new ResponseEntity<>(miniSerieService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<MiniSerieDTO>> getById(@PathVariable Long id) {
        return new ResponseEntity<>(miniSerieService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody MiniSerieDTO miniSerie) {
        miniSerieService.save(miniSerie);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        miniSerieService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
