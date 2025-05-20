package com.bootcamp.showroom.controller;

import com.bootcamp.showroom.dto.ClothingDTO;
import com.bootcamp.showroom.service.ClothingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothes")
@RequiredArgsConstructor
public class ClothingController {
    private final ClothingService service;

    //Crear una nueva prenda
    @PostMapping
    public ResponseEntity<ClothingDTO> save(@RequestBody ClothingDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    //Devolver todas las prendas
    @GetMapping
    public ResponseEntity<List<ClothingDTO>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    //Devolver una prenda en particular
    @GetMapping("/{code}")
    public ResponseEntity<ClothingDTO> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(service.findByCode(code));
    }

    //Actualizar una prenda en particular
    @PutMapping("/{code}")
    public ResponseEntity<ClothingDTO> update(@PathVariable String code, @RequestBody ClothingDTO dto) {
        return ResponseEntity.ok(service.update(code, dto));
    }

    //Eliminar una prenda en particular
    @DeleteMapping("/{code}")
    public ResponseEntity<Void> delete(@PathVariable String code) {
        service.delete(code);
        return ResponseEntity.noContent().build();
    }

    //Traer todas las prendas de un determinado talle
    @GetMapping("/size/{size}")
    public ResponseEntity<List<ClothingDTO>> getBySize(@PathVariable String size) {
        return ResponseEntity.ok(service.findBySize(size));
    }

    //Buscar todas las prendas en cuyo nombre aparezca la palabra “remera”. No se tienen en cuenta ni mayúsculas ni minúsculas
    @GetMapping(params = "name")
    public ResponseEntity<List<ClothingDTO>> searchByName(@RequestParam String name) {
        return ResponseEntity.ok(service.searchByName(name));
    }
}
