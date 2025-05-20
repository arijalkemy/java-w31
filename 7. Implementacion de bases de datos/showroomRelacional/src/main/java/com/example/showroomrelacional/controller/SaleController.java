package com.example.showroomrelacional.controller;

import com.example.showroomrelacional.entity.*;
import com.example.showroomrelacional.service.SalesService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/sale")
@AllArgsConstructor
public class SaleController {

    private final SalesService saleService;

    @PostMapping
    public ResponseEntity<SaleDTO> createSale(@RequestBody CreateSaleRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(saleService.createSale(request));
    }

    @GetMapping
    public ResponseEntity<List<SaleDTO>> getAllSales(@RequestParam(value = "date", required = false)
                                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        if (date != null)
            return ResponseEntity.ok(saleService.getSalesByDate(date));
        return ResponseEntity.ok(saleService.getAllSales());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleDTO> getSaleById(@PathVariable Long id) {
        return ResponseEntity.ok(saleService.getSaleById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SaleDTO> updateSale(@PathVariable Long id, @RequestBody CreateSaleRequest req) {
        return ResponseEntity.ok(saleService.updateSale(id, req));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSale(@PathVariable Long id) {
        saleService.deleteSale(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/clothes/{id}")
    public ResponseEntity<List<ClothDTO>> getClothesOfSale(@PathVariable Long id) {
        return ResponseEntity.ok(saleService.getClothesOfSale(id));
    }
}