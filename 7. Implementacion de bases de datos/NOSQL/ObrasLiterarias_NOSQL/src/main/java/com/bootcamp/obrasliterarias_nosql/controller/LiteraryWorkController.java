package com.bootcamp.obrasliterarias_nosql.controller;

import com.bootcamp.obrasliterarias_nosql.dto.LiteraryWorkDTO;
import com.bootcamp.obrasliterarias_nosql.service.LiteraryWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/literarywork")
public class LiteraryWorkController {

    private final LiteraryWorkService service;

    @Autowired
    public LiteraryWorkController(LiteraryWorkService service){
        this.service = service;
    }
    //Crear obras literarias
    @PostMapping
    public LiteraryWorkDTO newLiteraryWork (@RequestBody LiteraryWorkDTO work){
        return service.newLiteraryWork(work);
    }

    //Retornar las obras de un determinado autor.
    @GetMapping("/author/{author}")
    public ResponseEntity<List<LiteraryWorkDTO>> findByAuthor(@PathVariable String author){
        return ResponseEntity.ok(service.findByAuthor(author));
    }

    //Retornar las obras que contengan palabras claves en sus títulos. Por ejemplo: que contengan la palabra “quijote”
    @GetMapping("/search/title/{keyword}")
    public ResponseEntity<List<LiteraryWorkDTO>> findByKeywordInTitle(@PathVariable String keyword){
        return ResponseEntity.ok(service.findByKeywordInTitle(keyword));
    }

    //Retornar el top 5 de las obras literarias con más cantidad de páginas. Ordenar el resultado de mayor a menor.
    @GetMapping("/top5")
    public ResponseEntity<List<LiteraryWorkDTO>> getTop5ByPageCount(){
        return ResponseEntity.ok(service.getTop5ByPageCount());
    }

    //Retornar las obras que fueron publicadas antes de un determinado año. Por ejemplo: Antes de 1998.
    @GetMapping("/search/year/before/{year}")
    public ResponseEntity<List<LiteraryWorkDTO>> getByYearBefore(@PathVariable int year){
        return ResponseEntity.ok(service.getByYearBefore(year));
    }

    //Retornar todas las obras de una determinada editorial. Por ejemplo: Todas las obras de la editorial “Santillana”
    @GetMapping("/search/editorial/{editorial}")
    public ResponseEntity<List<LiteraryWorkDTO>> findByEditorial(@PathVariable String editorial){
        return ResponseEntity.ok(service.findByEditorial(editorial));
    }
}
