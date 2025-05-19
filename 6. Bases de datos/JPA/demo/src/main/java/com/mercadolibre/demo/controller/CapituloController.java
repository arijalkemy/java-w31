package com.mercadolibre.demo.controller;

import com.mercadolibre.demo.dto.CapituloDTO;
import com.mercadolibre.demo.dto.MiniSerieDTO;
import com.mercadolibre.demo.services.CapituloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/capitulos")
public class CapituloController {

    @Autowired
    private CapituloService capituloService;

    @GetMapping
    public ResponseEntity<List<CapituloDTO>> getAll() {
        return new ResponseEntity<>(capituloService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CapituloDTO>> getById(@PathVariable Long id) {
        return new ResponseEntity<>(capituloService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/miniserie/{miniserieId}")
    public ResponseEntity<Void> create(@PathVariable Long miniserieId, @RequestBody CapituloDTO capitulo) {
        capituloService.save(miniserieId, capitulo);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        capituloService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
