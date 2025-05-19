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
    public ResponseEntity<TestCaseDto> getTestCaseById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(testCaseService.getTestCaseById(id),HttpStatus.OK);
    }

    //Crear un nuevo testcase
    @PostMapping("/new")
    public ResponseEntity<ResponseMessageDto> saveTestCase(@RequestBody TestCase testCase) {
        return new ResponseEntity<>(testCaseService.saveTestCase(testCase), HttpStatus.CREATED);
    }

    //Borrar un testcase por id
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseMessageDto> deleteTestCase(@PathVariable("id") Long id) {
        return new ResponseEntity<>(testCaseService.deleteTestCase(id), HttpStatus.OK);
    }

    //Actualizar un testcase por id
    @PutMapping("/{id}")
    public ResponseEntity<ResponseMessageDto> updateTestCase(@PathVariable("id") Long id, @RequestBody TestCase testCase) {
        return new ResponseEntity<>(testCaseService.updateTestCase(id, testCase), HttpStatus.OK);
    }

    //Obtener test cases actualizados después de una fecha dada
    @GetMapping("/last_update")
    public ResponseEntity<List<TestCaseDto>> getTestCasesByLastUpdate(
            @RequestParam("last_update") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate lastUpdate) {
        return new ResponseEntity<>(testCaseService.getTestCasesUpdatedAfter(lastUpdate), HttpStatus.OK);
    }

}
