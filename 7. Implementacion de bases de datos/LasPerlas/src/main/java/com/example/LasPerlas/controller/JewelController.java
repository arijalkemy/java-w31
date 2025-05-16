package com.example.LasPerlas.controller;

import com.example.LasPerlas.model.request.NewJewelRequest;
import com.example.LasPerlas.service.JewelService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jewelry")
@AllArgsConstructor
public class JewelController {

    JewelService service;

    @PostMapping("/new")
    public ResponseEntity<?> createNewJewerly(@RequestBody NewJewelRequest newJewerly) {
        return new ResponseEntity<>(service.createNewJewerly(newJewerly), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllJewels() {
        return new ResponseEntity<>(service.getAllJewels(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteJewelById(@PathVariable Long id) {
        service.deleteJewelById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id_modificar}")
    public ResponseEntity<?> updateJewelById(@PathVariable Long id_modificar, @RequestBody NewJewelRequest modifiedJewel) {
        return new ResponseEntity<>(service.updateJewelById(id_modificar, modifiedJewel), HttpStatus.OK);
    }

}
