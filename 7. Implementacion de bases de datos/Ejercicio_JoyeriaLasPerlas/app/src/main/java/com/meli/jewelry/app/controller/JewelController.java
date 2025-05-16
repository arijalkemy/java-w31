package com.meli.jewelry.app.controller;

import com.meli.jewelry.app.dto.JewelDto;
import com.meli.jewelry.app.service.IJewelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewelry")
public class JewelController {

    private IJewelService jewelService;

    public JewelController(IJewelService jewelService) {
        this.jewelService = jewelService;
    }

    @GetMapping
    public ResponseEntity<List<JewelDto>> getJewelry() {
        return new ResponseEntity<>(jewelService.getAllJewels(), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<String> createJewel(@RequestBody JewelDto jewelDto) {
        jewelService.save(jewelDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteJewel(@PathVariable Long id) {
        jewelService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateJewel(@RequestBody JewelDto jewelDto, @PathVariable Long id) {
        jewelService.update(id, jewelDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
