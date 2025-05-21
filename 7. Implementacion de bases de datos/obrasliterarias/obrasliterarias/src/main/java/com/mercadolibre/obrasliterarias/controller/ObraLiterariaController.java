package com.mercadolibre.obrasliterarias.controller;

import com.mercadolibre.obrasliterarias.dto.ObraLiterariaDto;
import com.mercadolibre.obrasliterarias.service.IObraLiterariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obra")
public class ObraLiterariaController {
    @Autowired
    IObraLiterariaService service;
    @PostMapping
    public ResponseEntity<Void> saveObra(@RequestBody ObraLiterariaDto obraLiterariaDto){
       service.saveObra(obraLiterariaDto);
       return ResponseEntity.noContent().build();
    }
    @GetMapping("/autor")
    public ResponseEntity<List<ObraLiterariaDto>> getObrasPorAutor(@RequestParam String nombreAutor) {
        return ResponseEntity.ok(service.getObrasPorAutor(nombreAutor));
    }
    @GetMapping("/nombre")
    public ResponseEntity<List<ObraLiterariaDto>> getObrasPorNombre(@RequestParam String nombreLibro) {
        return ResponseEntity.ok(service.buscarPorNombre(nombreLibro));
    }
    @GetMapping("/top")
    public ResponseEntity<List<ObraLiterariaDto>> findTop5ByOrderByCantidadPaginasDesc() {
        return ResponseEntity.ok(service.findTop5ByOrderByCantidadPaginasDesc());
    }
    @GetMapping("/searchYear")
    public ResponseEntity<List<ObraLiterariaDto>> findObraLiterariaPublicatedBeforeYear(@RequestParam Integer year) {
        return ResponseEntity.ok(service.findObraLiterariaPublicatedBeforeYear(year));
    }

    @GetMapping("/editorial")
    public ResponseEntity<List<ObraLiterariaDto>> getObrasPorEditorial(@RequestParam String editorial) {
        return ResponseEntity.ok(service.buscarPorEditorial(editorial));
    }
}
