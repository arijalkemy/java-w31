package com.mercadolibre.testersqa.controller;

import com.mercadolibre.testersqa.dto.TestCaseDto;
import com.mercadolibre.testersqa.entity.TestCase;
import com.mercadolibre.testersqa.services.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/testcase")
public class TesterController {
    @Autowired
    ITestCaseService testCaseService;

    @PostMapping("/new")
    public ResponseEntity<TestCase> create(@RequestBody TestCase req){
    return new ResponseEntity<>(testCaseService.create(req), HttpStatus.CREATED);
    }

}
