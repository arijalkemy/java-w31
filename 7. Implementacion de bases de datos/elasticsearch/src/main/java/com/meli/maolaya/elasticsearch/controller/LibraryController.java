package com.meli.maolaya.elasticsearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meli.maolaya.elasticsearch.dto.LiteraryWorkDto;
import com.meli.maolaya.elasticsearch.service.ILibraryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    private ILibraryService libraryService;

    @GetMapping("/author")
    public ResponseEntity<List<LiteraryWorkDto>> getByAuthor(@RequestParam String author) {
        return ResponseEntity.ok(libraryService.getByAuthor(author));
    }

    @GetMapping("/title/contains")
    public ResponseEntity<List<LiteraryWorkDto>> getByTitle(@RequestParam String title) {
        return ResponseEntity.ok(libraryService.getByTitle(title));
    }

    @GetMapping("/pages")
    public ResponseEntity<List<LiteraryWorkDto>> getByPages() {
        return ResponseEntity.ok(libraryService.getByPages());
    }

    @GetMapping("/year")
    public ResponseEntity<List<LiteraryWorkDto>> getBeforeYear(@RequestParam Integer year) {
        return ResponseEntity.ok(libraryService.getBeforeYear(year));
    }

    @GetMapping("/editorial")
    public ResponseEntity<List<LiteraryWorkDto>> getByEditorial(@RequestParam String editorial) {
        return ResponseEntity.ok(libraryService.getByEditorial(editorial));
    }

}
