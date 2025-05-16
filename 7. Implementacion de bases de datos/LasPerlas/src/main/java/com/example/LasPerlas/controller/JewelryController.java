package com.example.LasPerlas.controller;

import com.example.LasPerlas.dto.JewelryDTO;
import com.example.LasPerlas.service.JewelryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewelry")
public class JewelryController {

    private final JewelryService jewelryService;

    public JewelryController(JewelryService jewelryService) {
        this.jewelryService = jewelryService;
    }

    // Crear una nueva joya y devolver el correspondiente status code con un mensaje informando su “nro identificatorio”. (URI: /jewerly/new).
    @PostMapping("/new")
    public ResponseEntity<JewelryDTO> createJewelry(@RequestBody JewelryDTO jewelryDTO) {
        return ResponseEntity.ok(jewelryService.createJewelry(jewelryDTO));
    }

    // Devolver el listado de todas las joyas registradas. (URI: /jewerly).
    @GetMapping
    public List<JewelryDTO> getAvailableJewelry() {
        return jewelryService.getAvailableJewelry();
    }

    // Eliminar “lógicamente” una joya.
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteJewelry(@PathVariable Long id) {
        return jewelryService.deleteJewelry(id)
                ? ResponseEntity.ok("Jewelry logically deleted.")
                : ResponseEntity.notFound().build();
    }

    // Actualizar los datos de una joya.
    @PutMapping("/update/{id}")
    public ResponseEntity<JewelryDTO> updateJewelry(@PathVariable Long id, @RequestBody JewelryDTO jewelryDTO) {
        JewelryDTO updated = jewelryService.updateJewelry(id, jewelryDTO);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }
}
