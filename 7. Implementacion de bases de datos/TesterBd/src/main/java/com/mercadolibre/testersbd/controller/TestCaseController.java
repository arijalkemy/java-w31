package com.mercadolibre.testersbd.controller;

import com.mercadolibre.testersbd.dto.ResponseMessageDto;
import com.mercadolibre.testersbd.dto.TestCaseDto;
import com.mercadolibre.testersbd.model.TestCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.mercadolibre.testersbd.service.TestCaseService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/testcases")
public class TestCaseController {

    @Autowired
    private TestCaseService testCaseService;

    //Obtener todos los testcases
    @GetMapping
    public ResponseEntity<List<TestCaseDto>> getTestCases() {
        return new ResponseEntity<>(testCaseService.getTestCases(), HttpStatus.OK);
    }

    //Obtener un testcase por id
    @GetMapping("/{id}")
    public ResponseEntity<TestCaseDto> getTestCaseById(@PathVariable("id") Long id_case) {
        return new ResponseEntity<>(testCaseService.getTestCaseById(id_case),HttpStatus.OK);
    }

    //Crear un nuevo testcase
    @PostMapping("/new")
    public ResponseEntity<ResponseMessageDto> saveTestCase(@RequestBody TestCase testCase) {
        return new ResponseEntity<>(testCaseService.saveTestCase(testCase), HttpStatus.CREATED);
    }

    //Borrar un testcase por id
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseMessageDto> deleteTestCase(@PathVariable("id") Long id_case) {
        return new ResponseEntity<>(testCaseService.deleteTestCase(id_case), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseMessageDto> deleteTestCase(@RequestBody TestCaseDto testCaseDto, @PathVariable Long id) {
        return new ResponseEntity<>(testCaseService.updateTestCase(testCaseDto, id), HttpStatus.OK);
    }

}
