package com.mercadolibre.obrasliterarias.controller;

import com.mercadolibre.obrasliterarias.dto.LiteraryWorkDTO;
import com.mercadolibre.obrasliterarias.model.LiteraryWork;
import com.mercadolibre.obrasliterarias.service.LiteraryWorkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/literary-works")
@RequiredArgsConstructor
public class LiteraryWorkController {

    private final LiteraryWorkService service;

    @PostMapping
    public ResponseEntity<LiteraryWork> save(@RequestBody LiteraryWorkDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping("/author/{author}")
    public List<LiteraryWork> getByAuthor(@PathVariable String author) {
        return service.findByAuthor(author);
    }

    @GetMapping("/search")
    public List<LiteraryWork> getByKeyword(@RequestParam String keyword) {
        return service.findByKeyword(keyword);
    }

    @GetMapping("/top-pages")
    public List<LiteraryWork> getTop5ByPages() {
        return service.findTop5ByPages();
    }

    @GetMapping("/before-year/{year}")
    public List<LiteraryWork> getBeforeYear(@PathVariable int year) {
        return service.findBeforeYear(year);
    }

    @GetMapping("/publisher/{publisher}")
    public List<LiteraryWork> getByPublisher(@PathVariable String publisher) {
        return service.findByPublisher(publisher);
    }
}

