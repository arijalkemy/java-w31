package com.showroom.extra.controller;

import com.showroom.extra.dto.VentaDTO;
import com.showroom.extra.model.Prenda;
import com.showroom.extra.model.Venta;
import com.showroom.extra.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/sale")
public class VentaController {

    @Autowired
    private IVentaService service;

    @PostMapping
    public ResponseEntity<Venta> save(@RequestBody VentaDTO ventaDTO){
        return ResponseEntity.ok(service.save(ventaDTO));
    }
    @GetMapping
    public ResponseEntity<List<Venta>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }
    ///api/sale/{number}
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Venta>> findById(@PathVariable String id){
        return ResponseEntity.ok(service.findbyId(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Venta> updateSale(@PathVariable String id, VentaDTO ventaDTO){
        return ResponseEntity.ok(service.updateSale(id,ventaDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSale(String id){
        return ResponseEntity.ok(service.deleteSale(id));
    }

    @GetMapping("/fecha")
    public ResponseEntity<List<Venta>> saleByFecha(@RequestParam LocalDate date){
        return ResponseEntity.ok(service.saleByFecha(date));
    }

    @GetMapping("/clothes/{id}")
    public ResponseEntity<List<Prenda>> prendasBySale(String id){
        return ResponseEntity.ok(service.findBySale(id));
    }


}
