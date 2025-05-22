package com.example.obrasLiterarias.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.obrasLiterarias.model.LiteraryWork;
import com.example.obrasLiterarias.service.ILiteraryWorkService;

@RestController
@RequestMapping("/literaryWorks")
public class LiteraryWorksController {

    private ILiteraryWorkService literaryWorkService;

    public LiteraryWorksController(ILiteraryWorkService literaryWorkService) {
        this.literaryWorkService = literaryWorkService;
    }

    @PostMapping("/batch")
    public ResponseEntity<List<LiteraryWork>> postABatchOfLiteraryWork(
        @RequestBody List<LiteraryWork> batch
    ){
        return new ResponseEntity<>( literaryWorkService.postABatchOfLiteraryWork(batch), HttpStatus.OK);
    }

    @GetMapping("/author")
    public ResponseEntity<List<LiteraryWork>> getLiteraryWorksByAuthor(
        @RequestParam String name
    ){
        return new ResponseEntity<>( literaryWorkService.getLiteraryWorksByAuthor(name), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<LiteraryWork>> getAllLiteraryWork(){
        return new ResponseEntity<>(literaryWorkService.getAllLiteraryWork(), HttpStatus.OK);
    }

    @GetMapping("/filterByKey")
    public ResponseEntity<List<LiteraryWork>> getLiteraryWorkByKeyWorks(
        @RequestParam String keyword
    ){
        return new ResponseEntity<>(literaryWorkService.getLiteraryWorkByKeyWord(keyword), HttpStatus.OK);
    }

    @GetMapping("/morePages")
    public ResponseEntity<List<LiteraryWork>>  getTopFiveLongestLiteraryWork(){
        return new ResponseEntity<>(literaryWorkService.getTopFiveLongestLiteraryWork(), HttpStatus.OK);
    }
 
    @GetMapping("/filterByYear")
    public ResponseEntity<List<LiteraryWork>> getLiteraryWorkByYear(
        @RequestParam int year
    ){
        return new ResponseEntity<>( literaryWorkService.getLiteraryWorkByYear(year), HttpStatus.OK);
    }

    @GetMapping("/filterByPublisher")
    public ResponseEntity<List<LiteraryWork>> getLiteraryWorkByPublisher(
        @RequestParam String publisher
    ){
        return new ResponseEntity<>( literaryWorkService.getLiteraryWorkByPublisher(publisher), HttpStatus.OK);
    }
}
