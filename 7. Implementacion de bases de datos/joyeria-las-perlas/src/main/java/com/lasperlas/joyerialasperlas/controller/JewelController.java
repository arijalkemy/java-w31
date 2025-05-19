package com.lasperlas.joyerialasperlas.controller;

import com.lasperlas.joyerialasperlas.dto.JewelDto;
import com.lasperlas.joyerialasperlas.service.IJewelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewelry")
public class JewelController {

    @Autowired
    private IJewelService jewelService;

    @GetMapping
    public ResponseEntity<List<JewelDto>> getJewelry() {
        return new ResponseEntity<>(jewelService.getJewelry(), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<JewelDto> postJewelry(@RequestBody JewelDto body) {
        return new ResponseEntity<>(jewelService.postJewelry(body), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<JewelDto> logicalDeletion(@PathVariable Long id) {
        jewelService.logicalDeletion(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<JewelDto> logicalDeletion(@PathVariable Long id, @RequestBody JewelDto body) {
        // "Envía el objeto completo para editar (sin cambiar el id)." Por eso llamo al mismo metodo del post y no uso
        // el path variable
        return new ResponseEntity<>(jewelService.postJewelry(body), HttpStatus.OK);
    }
}
