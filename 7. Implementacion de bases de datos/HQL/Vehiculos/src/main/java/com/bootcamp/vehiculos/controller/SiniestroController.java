package com.bootcamp.vehiculos.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bootcamp.vehiculos.dtos.SiniestroDto;
import com.bootcamp.vehiculos.service.ISiniestroService;

@RestController
@RequestMapping("/siniestros")
public class SiniestroController {

    private final ISiniestroService siniestroService;

    public SiniestroController(ISiniestroService siniestroService) {
        this.siniestroService = siniestroService;
    }

    @PostMapping
    public ResponseEntity<Long> createSiniestro(@RequestBody SiniestroDto siniestroDto) {
        return new ResponseEntity<>(siniestroService.createSiniestro(siniestroDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SiniestroDto>> getAllSiniestros() {
        List<SiniestroDto> siniestros = siniestroService.getAllSiniestros();
        return ResponseEntity.ok(siniestros);
    }
}