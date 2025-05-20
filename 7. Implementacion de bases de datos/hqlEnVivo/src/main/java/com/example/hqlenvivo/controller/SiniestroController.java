package com.example.hqlenvivo.controller;

import com.example.hqlenvivo.model.Siniestro;
import com.example.hqlenvivo.service.SiniestroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/siniestros")
@RequiredArgsConstructor
public class SiniestroController {
    private final SiniestroService siniestroService;

    @PostMapping("/{vehiculoId}")
    public ResponseEntity<Siniestro> create(@PathVariable Long vehiculoId, @RequestBody Siniestro s) {
        return ResponseEntity.ok(siniestroService.save(vehiculoId, s));
    }

    @GetMapping
    public ResponseEntity<List<Siniestro>> getAll() {
        return ResponseEntity.ok(siniestroService.findAll());
    }

    @GetMapping("/vehiculo/{vehiculoId}")
    public List<Siniestro> getPorVehiculo(@PathVariable Long vehiculoId) {
        return siniestroService.findByVehiculo(vehiculoId);
    }
}