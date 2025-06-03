package com.meli.obrasliterarias.controller;

import com.meli.obrasliterarias.model.ObraLiteraria;
import com.meli.obrasliterarias.service.ObrasLiterariasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/obras")
public class ObrasLiterariasController {

    @Autowired
    private ObrasLiterariasService obrasLiterariasService;

    @PostMapping("/obraLiteraria/new")
    public ResponseEntity<String> save(@RequestBody List<ObraLiteraria> obrasLiterarias) {
        String responseMessage = obrasLiterariasService.saveObras(obrasLiterarias);
        return new ResponseEntity<>(responseMessage, HttpStatus.CREATED);
    }

    @GetMapping("/obraLiteraria/get")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(obrasLiterariasService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/obraLiteraria/author/{author}")
    public ResponseEntity<?> findByAuthor(@PathVariable String author) {
        return new ResponseEntity<>(obrasLiterariasService.findByAuthor(author), HttpStatus.OK);
    }

    @GetMapping("/obraLiteraria/palabraClave/{palabraClave}")
    public ResponseEntity<?> findByPalabraClave(@PathVariable String palabraClave) {
        return new ResponseEntity<>(obrasLiterariasService.findByPalabraClave(palabraClave), HttpStatus.OK);
    }

    @GetMapping("/obraLiteraria/topPages")
    public ResponseEntity<?> findByPalabraClave() {
        return new ResponseEntity<>(obrasLiterariasService.findTop5ByPaginas(), HttpStatus.OK);
    }

    @GetMapping("/obraLiteraria/year/{year}")
    public ResponseEntity<?> findByAnoPublicacionBefore(@PathVariable int year) {
        return new ResponseEntity<>(obrasLiterariasService.findByAnoPublicacionBefore(year), HttpStatus.OK);
    }

    @GetMapping("/obraLiteraria/publisher/{publisher}")
    public ResponseEntity<?> findByEditorial(@PathVariable String publisher) {
        return new ResponseEntity<>(obrasLiterariasService.findByEditorial(publisher), HttpStatus.OK);
    }

}

