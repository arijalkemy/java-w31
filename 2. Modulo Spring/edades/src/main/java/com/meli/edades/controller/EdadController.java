package com.meli.edades.controller;

import org.springframework.web.bind.annotation.RestController;

import com.meli.edades.service.EdadService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequiredArgsConstructor
public class EdadController {

    private final EdadService edadService;

    @GetMapping("/api/{day}/{month}/{year}")
    public ResponseEntity<String> getEdad(@PathVariable String day, @PathVariable String month,
            @PathVariable String year) {
        return ResponseEntity.ok(edadService.getEdad(day, month, year));
    }

}
