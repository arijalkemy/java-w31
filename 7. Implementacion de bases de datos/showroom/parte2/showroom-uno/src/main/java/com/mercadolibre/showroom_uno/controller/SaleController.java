package com.mercadolibre.showroom_uno.controller;

import com.mercadolibre.showroom_uno.dto.SaleClotheDto;
import com.mercadolibre.showroom_uno.dto.SaleDto;
import com.mercadolibre.showroom_uno.service.IShowRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SaleController {

    @Autowired
    IShowRoomService service;
    /* POST /api/sale Crear una nueva venta. */
    @PostMapping
    public ResponseEntity<Void> createSale(@RequestBody SaleDto saleDto) {
        service.createSale(saleDto);
        return ResponseEntity.noContent().build();
    }

    /* GET /api/sale Devolver todas las ventas o las anteriores a una fecha */
    @GetMapping
    public ResponseEntity<List<SaleDto>> getAllSales() {
        return new ResponseEntity<>(service.getAllSales(), HttpStatus.OK);
    }
    /* GET /api/sale/{number} Devolver una venta en particular */
    @GetMapping("/{number}")
    public ResponseEntity<SaleDto> getSaleByNumber(@PathVariable Long number) {
        return new ResponseEntity<>(service.getSaleByNumber(number), HttpStatus.OK);
    }

    /* PUT /api/sale/{number} Actualizar una venta en particular */
    @PutMapping("/{number}")
    public ResponseEntity<Void> updateSale(@PathVariable Long number, @RequestBody SaleDto saleDto) {
        service.updateSale(number, saleDto);
        return ResponseEntity.noContent().build();
    }

    /* DELETE /api/sale/{number} Eliminar una venta en particular */
    @DeleteMapping("/{number}")
    public ResponseEntity<Void> deleteSale(@PathVariable Long number) {
        service.deleteSale(number);
        return ResponseEntity.noContent().build();
    }

    /* GET /api/sale/clothes/{number} Traer la lista completa de prendas de una determinada venta. */
    @GetMapping("/clothes/{number}")
    public ResponseEntity<List<SaleClotheDto>> getClothesBySale(@PathVariable Long number) {
        return new ResponseEntity<>(service.getClothesBySale(number), HttpStatus.OK);
    }
}
