package com.meli.maolaya.siniestro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.meli.maolaya.siniestro.dto.SiniestroDto;
import com.meli.maolaya.siniestro.service.ISiniestroService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/siniestro")
public class SiniestroController {

    @Autowired
    private ISiniestroService siniestroService;

    @PostMapping("/new")
    public ResponseEntity<Void> postNewSiniestro(@RequestBody SiniestroDto siniestroDto) {
        siniestroService.saveSiniestro(siniestroDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
