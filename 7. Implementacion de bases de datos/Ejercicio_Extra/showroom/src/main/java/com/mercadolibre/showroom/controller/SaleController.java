package com.mercadolibre.showroom.controller;

import com.mercadolibre.showroom.dto.ClothingItemDto;
import com.mercadolibre.showroom.dto.SaleDto;
import com.mercadolibre.showroom.service.ISaleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/sale")
public class SaleController {

    private final ISaleService saleService;

    public SaleController(ISaleService saleService) {
        this.saleService = saleService;
    }

    // Crear una nueva venta
    @PostMapping
    public ResponseEntity<SaleDto> createSale(@RequestBody SaleDto saleDto) {
        return new ResponseEntity<>(saleService.save(saleDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SaleDto>> getAllSales(@RequestParam(required = false) String date) {
        if (date != null) {
            // Formato esperado: dd/MM/yyyy
            LocalDate parsedDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            List<SaleDto> salesByDate = saleService.findByDate(parsedDate);
            return new ResponseEntity<>(salesByDate, HttpStatus.OK);
        }
        return new ResponseEntity<>(saleService.findAll(), HttpStatus.OK);
    }


    @GetMapping("/{number}")
    public ResponseEntity<SaleDto> getSaleById(@PathVariable Long number) {
        return new ResponseEntity<>(saleService.findById(number), HttpStatus.OK);
    }

    @PutMapping("/{number}")
    public ResponseEntity<SaleDto> updateSale(@PathVariable Long number, @RequestBody SaleDto saleDto) {
        return new ResponseEntity<>(saleService.update(number, saleDto), HttpStatus.OK);
    }

    // Eliminar una venta en particular
    @DeleteMapping("/{number}")
    public ResponseEntity<Void> deleteSale(@PathVariable Long number) {
        saleService.delete(number);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Traer la lista completa de prendas de una determinada venta
    @GetMapping("/clothes/{number}")
    public ResponseEntity<List<ClothingItemDto>> getClothesBySaleNumber(@PathVariable Long number) {
        return new ResponseEntity<>(saleService.getClothingItemsBySaleNumber(number), HttpStatus.OK);
    }
}

