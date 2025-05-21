package com.example.elastic.controller;

import com.example.elastic.model.ObraLiteraria;
import com.example.elastic.service.ObraLiterariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obras")
public class ObraLiterariaController {

    @Autowired
    ObraLiterariaService service;

    @PostMapping
    public ResponseEntity<ObraLiteraria> save(@RequestBody ObraLiteraria obra) {
        return ResponseEntity.ok(service.save(obra));
    }

    @GetMapping("/author")
    public ResponseEntity<List<ObraLiteraria>> byAuthor(@RequestParam String author) {
        return ResponseEntity.ok(service.findByAuthorContainingIgnoreCase(author));
    }

    @GetMapping("/title")
    public ResponseEntity<List<ObraLiteraria>> byName(@RequestParam String name) {
        return ResponseEntity.ok(service.findByNameContainingIgnoreCase(name));
    }

    @GetMapping("/topFive")
    public ResponseEntity<List<ObraLiteraria>> topFivePage() {
        return ResponseEntity.ok(service.topFiveCountPage());
    }

    @GetMapping("/before")
    public ResponseEntity<List<ObraLiteraria>> publishedBefore(@RequestParam Integer year) {
        return ResponseEntity.ok(service.publishedBefore(year));
    }

    @GetMapping("/editorial")
    public ResponseEntity<List<ObraLiteraria>> byEditorial(@RequestParam String editorial) {
        return ResponseEntity.ok(service.findByEditorial(editorial));
    }

}
