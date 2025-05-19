package com.mercadolibre.testcases.controller;

import com.mercadolibre.testcases.dto.TesterDto;
import com.mercadolibre.testcases.service.ITesterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/testers")
public class TesterController {

    private final ITesterService testerService;

    public TesterController(ITesterService testerService) {
        this.testerService = testerService;
    }

    @PostMapping("/new")
    public ResponseEntity<TesterDto> createTester(@RequestBody TesterDto testerDto) {
        return new ResponseEntity<>(testerService.save(testerDto), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<TesterDto>> getAll() {
        return new ResponseEntity<>(testerService.getAll(), HttpStatus.OK);
    }
}
