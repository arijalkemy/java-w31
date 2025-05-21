package com.mercadolibre.showroom.controller;

import com.mercadolibre.showroom.dto.ClothingItemDto;
import com.mercadolibre.showroom.service.IClothesService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothes")
public class ClothesController {

    private final IClothesService clothesService;

    public ClothesController(IClothesService clothesService) {
        this.clothesService = clothesService;
    }

    @PostMapping
    public ResponseEntity<ClothingItemDto> createClothingItem(@RequestBody ClothingItemDto item) {
        return new ResponseEntity<>(clothesService.save(item), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ClothingItemDto>> getAllClothes(@RequestParam(required = false) String name) {
        if (name != null) {
            return ResponseEntity.ok(clothesService.findByName(name));
        }
        return ResponseEntity.ok(clothesService.findAll());
    }

    @GetMapping("/{code}")
    public ResponseEntity<ClothingItemDto> getClothingItemByCode(@PathVariable String code) {
        return ResponseEntity.ok(clothesService.findById(code));
    }

    @PutMapping("/{code}")
    public ResponseEntity<ClothingItemDto> updateClothingItem(@PathVariable String code, @RequestBody ClothingItemDto updatedItem) {
        return ResponseEntity.ok(clothesService.update(code, updatedItem));
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteClothingItem(@PathVariable String code) {
        clothesService.delete(code);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/size/{size}")
    public ResponseEntity<List<ClothingItemDto>> getClothesBySize(@PathVariable String size) {
        return ResponseEntity.ok(clothesService.findBySize(size));
    }
}
