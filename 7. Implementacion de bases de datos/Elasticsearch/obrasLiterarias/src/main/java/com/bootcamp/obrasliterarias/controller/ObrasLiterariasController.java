package com.bootcamp.obrasliterarias.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.obrasliterarias.dto.ObraLiterariaDto;
import com.bootcamp.obrasliterarias.service.IObrasLiterariasService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/ObrasLiterarias")
public class ObrasLiterariasController {
    private final IObrasLiterariasService service;

    public ObrasLiterariasController(IObrasLiterariasService service) {
        this.service = service;
    }

    @GetMapping("")
    public ResponseEntity<List<ObraLiterariaDto>> getAllObrasLiterarias() {
        return new ResponseEntity<>(service.getAllObrasLiterarias(), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<String> postNewObraLiteraria(@RequestBody ObraLiterariaDto obraLiterariaDto) {
        return new ResponseEntity<>(service.createObraLiteraria(obraLiterariaDto), HttpStatus.CREATED);
    }

    @GetMapping("/autor/{autor}")
    public ResponseEntity<List<ObraLiterariaDto>> getObrasLiterariasByAutor(@PathVariable String autor) {
        return new ResponseEntity<>(service.getObrasLiterariasByAutor(autor), HttpStatus.OK);
    }

    @GetMapping("/title/{keyword}")
    public ResponseEntity<List<ObraLiterariaDto>> getObrasLiterariasByKeyword(@PathVariable String keyword) {
        return new ResponseEntity<>(service.getObrasLiterariasByKeyword(keyword), HttpStatus.OK);
    }

    @GetMapping("/masLargas")
    public ResponseEntity<List<ObraLiterariaDto>> getFiveLongestObrasLiterarias() {
        return new ResponseEntity<>(service.getFiveLongestObrasLiterarias(), HttpStatus.OK);
    }

    @GetMapping("/beforeYear/{year}")
    public ResponseEntity<List<ObraLiterariaDto>> getObrasLiterariasBeforeYear(@PathVariable Integer year) {
        return new ResponseEntity<>(service.getObrasLiterariasBeforeYear(year), HttpStatus.OK);
    }

    @GetMapping("/editorial/{editorial}")
    public ResponseEntity<List<ObraLiterariaDto>> getObrasLiterariasByEditorial(@PathVariable String editorial) {
        return new ResponseEntity<>(service.getObrasLiterariasByEditorial(editorial), HttpStatus.OK);
    }
}