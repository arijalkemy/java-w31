package com.bootcamp.showroom.controller;

import com.bootcamp.showroom.dto.ClothingDTO;
import com.bootcamp.showroom.dto.SaleDTO;
import com.bootcamp.showroom.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sale")
@RequiredArgsConstructor
public class SaleController {
    private final SaleService service;

    //Crear una nueva venta
    @PostMapping
    public ResponseEntity<SaleDTO> create(@RequestBody SaleDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    //Devolver todas las ventas
    @GetMapping
    public ResponseEntity<List<SaleDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    //Devolver una venta en particular
    @GetMapping("/{number}")
    public ResponseEntity<SaleDTO> getById(@PathVariable String number) {
        return ResponseEntity.ok(service.getByNumber(number));
    }

    //Actualizar una determinada venta
    @PutMapping("/{number}")
    public ResponseEntity<SaleDTO> update(@PathVariable String number, @RequestBody SaleDTO dto) {
        return ResponseEntity.ok(service.update(number, dto));
    }

    //Eliminar una venta en particular
    @DeleteMapping("/{number}")
    public ResponseEntity<Void> delete(@PathVariable String number) {
        service.delete(number);
        return ResponseEntity.noContent().build();
    }

    //Traer todas las prendas de una determinada fecha
    @GetMapping(params = "date")
    public ResponseEntity<List<SaleDTO>> getByDate(@RequestParam String date) {
        return ResponseEntity.ok(service.getByDate(date));
    }


    //Traer la lista completa de prendas de una determinada venta
    @GetMapping("/clothes/{number}")
    public ResponseEntity<List<ClothingDTO>> getClothesFromSale(@PathVariable String number) {
        return ResponseEntity.ok(service.getClothesFromSale(number));
    }
}