package com.mercadolibre.literaryworks.controller;

import com.mercadolibre.literaryworks.dto.LiteraryWorkDTO;
import com.mercadolibre.literaryworks.model.LiteraryWork;
import com.mercadolibre.literaryworks.service.LiteraryWorkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/literaryworks")
public class LiteraryWorkController {

    private final LiteraryWorkService literaryWorkService;

    public LiteraryWorkController(LiteraryWorkService literaryWorkService) {
        this.literaryWorkService = literaryWorkService;
    }

    @GetMapping
    public ResponseEntity<List<LiteraryWorkDTO>> getAllLiteraryWorks() {
        return new ResponseEntity<>(literaryWorkService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<LiteraryWorkDTO> addLiteraryWork(@RequestBody LiteraryWorkDTO lw) {
        return new ResponseEntity<>(literaryWorkService.add(lw), HttpStatus.OK);
    }

    @PostMapping("/add-batch")
    public ResponseEntity<List<LiteraryWorkDTO>> addLiteraryWorkBatch(@RequestBody List<LiteraryWork> batch) {
        return new ResponseEntity<>(literaryWorkService.addAll(batch), HttpStatus.OK);
    }

    @GetMapping("/author")
    public ResponseEntity<List<LiteraryWorkDTO>> findByAuthor(@RequestParam String name) {
        return new ResponseEntity<>(literaryWorkService.findByAuthor(name), HttpStatus.OK);
    }

    @GetMapping("/title")
    public ResponseEntity<List<LiteraryWorkDTO>> findByKeyword(@RequestParam String keyword) {
        return new ResponseEntity<>(literaryWorkService.findByKeyword(keyword), HttpStatus.OK);
    }

    @GetMapping("/top-pages")
    public ResponseEntity<List<LiteraryWorkDTO>> getTopFiveWithMostPages() {
        return new ResponseEntity<>(literaryWorkService.getTopFiveWithMostPages(), HttpStatus.OK);
    }

    @GetMapping("/before/{year}")
    public ResponseEntity<List<LiteraryWorkDTO>> getLiteraryWorksPublishedBeforeYear(@PathVariable int year) {
        return new ResponseEntity<>(literaryWorkService.getPublishedBeforeYear(year), HttpStatus.OK);
    }

    @GetMapping("/publisher")
    public ResponseEntity<List<LiteraryWorkDTO>> findByPublisher(@RequestParam String publisher) {
        return new ResponseEntity<>(literaryWorkService.findByPublisher(publisher), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLiteraryWork(@PathVariable String id) {
        literaryWorkService.delete(id);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }
}
