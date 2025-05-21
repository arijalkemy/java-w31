package com.mercadolibre.showroom.controller;

import com.mercadolibre.showroom.dto.request.VentaRequestDto;
import com.mercadolibre.showroom.dto.response.PrendaResponseDto;
import com.mercadolibre.showroom.dto.response.VentaResponseDto;
import com.mercadolibre.showroom.service.IVentaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/sale")
public class VentaController {
    private final IVentaService ventaService;

    @PostMapping("")
    public ResponseEntity<VentaResponseDto> addVenta(@RequestBody VentaRequestDto ventaRequest){
        VentaResponseDto ventaCreada = ventaService.addVenta(ventaRequest);
        URI location = URI.create("api/sale/" + ventaCreada.getId());
        return ResponseEntity.created(location).body(ventaCreada);
    }

    @GetMapping("get-all")
    public ResponseEntity<List<VentaResponseDto>> getAllVentas(){
        return ResponseEntity.ok(ventaService.getAllVentas());
    }

    @GetMapping("{numero}")
    public ResponseEntity<VentaResponseDto> getByNumero(@PathVariable String numero){
        return ResponseEntity.ok(ventaService.getByNumero(numero));
    }

    @DeleteMapping("{numero}")
    public ResponseEntity<?> deleteVenta(@PathVariable String numero){
        ventaService.deleteVenta(numero);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/by-date")
    public ResponseEntity<List<VentaResponseDto>> getByFecha(@RequestParam LocalDate fecha){
        return ResponseEntity.ok(ventaService.getByDate(fecha));
    }

    @GetMapping("/clothes/{numero}")
    public ResponseEntity<List<PrendaResponseDto>> getPrendaFromVenta(@PathVariable String numero){
        return ResponseEntity.ok(ventaService.findPrendaFromVenta(numero));
    }



}
