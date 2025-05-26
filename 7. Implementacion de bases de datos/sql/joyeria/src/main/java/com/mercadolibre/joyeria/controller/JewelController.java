package com.mercadolibre.joyeria.controller;

import com.mercadolibre.joyeria.dto.JewelRequestDTO;
import com.mercadolibre.joyeria.dto.JewelResponseDTO;
import com.mercadolibre.joyeria.service.IJewelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewelry")
public class JewelController {
    private final IJewelService jewelService;

    public JewelController(IJewelService jewelService) {
        this.jewelService = jewelService;
    }

    @PostMapping("/new")
    public ResponseEntity<Long> createJewel(@RequestBody JewelRequestDTO jewel) {
        return new ResponseEntity<>(jewelService.saveJewel(jewel), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<JewelResponseDTO>> getJewels() {
        return new ResponseEntity<>(jewelService.getJewels(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteJewel(@PathVariable Long id) {
        jewelService.deleteJewel(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<JewelResponseDTO> updateJewel(@PathVariable Long id,
                                                        @RequestBody JewelRequestDTO jewel) {
        return new ResponseEntity<>(jewelService.updateJewel(jewel, id), HttpStatus.FOUND);
    }
}
