package com.showroom.extra.controller;

import com.showroom.extra.dto.PrendaDTO;
import com.showroom.extra.model.Prenda;
import com.showroom.extra.service.IPrendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clothes")
public class PrendaController {
    @Autowired
    IPrendaService service;

    @PostMapping
    public ResponseEntity<Prenda> save(@RequestBody PrendaDTO prendaDTO){
        return ResponseEntity.ok(service.save(prendaDTO));
    }

    @GetMapping
    public ResponseEntity<List<Prenda>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{code}")
    public ResponseEntity<Optional<Prenda>> findCode(@PathVariable String code){
        return ResponseEntity.ok(service.findById(code));
    }

    @PutMapping("/{code}")
    public ResponseEntity<Prenda> UpdatePrenda(@PathVariable String code, @RequestBody PrendaDTO prendaDTO){
        return ResponseEntity.ok(service.updatePrenda(code,prendaDTO));
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<String> deletePrenda(@PathVariable String code){
        return ResponseEntity.ok(service.delete(code));
    }

    @GetMapping("/talle/{size}")
    public ResponseEntity<List<Prenda>> findbyTalle(@PathVariable String size){
        return ResponseEntity.ok(service.findByTalle(size));
    }

    @GetMapping("/name")
    public ResponseEntity<List<Prenda>> findByName(@RequestParam String name){
        return ResponseEntity.ok(service.findByRemera(name));
    }

}
