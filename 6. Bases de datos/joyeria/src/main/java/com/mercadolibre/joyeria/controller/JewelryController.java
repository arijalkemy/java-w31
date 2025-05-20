package com.mercadolibre.joyeria.controller;

import com.mercadolibre.joyeria.dto.RequestJewelryDto;
import com.mercadolibre.joyeria.service.IJewelryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jewelry")
public class JewelryController {

    @Autowired
    private IJewelryService jewelryService;

    @GetMapping("/")
    public ResponseEntity<?> getAllJewelry() {
        return new ResponseEntity<>(jewelryService.getAllJewelry(), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<?> addJewelry(@RequestBody RequestJewelryDto jewelry) {
        return new ResponseEntity<>(jewelryService.addJewelry(jewelry), HttpStatus.CREATED);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteJewelry(@PathVariable Long id) {
        return new ResponseEntity<>(jewelryService.deleteJewelry(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> editJewelry(@PathVariable Long id, @RequestBody RequestJewelryDto jewelry) {
        return new ResponseEntity<>(jewelryService.editJewelry(id, jewelry), HttpStatus.OK);
    }
}
