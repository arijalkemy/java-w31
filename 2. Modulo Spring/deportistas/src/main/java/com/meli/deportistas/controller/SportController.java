package com.meli.deportistas.controller;

import org.springframework.web.bind.annotation.RestController;

import com.meli.deportistas.model.SportModel;
import com.meli.deportistas.service.SportService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequiredArgsConstructor
public class SportController {

    private final SportService sportService;

    @GetMapping("/findSports")
    public ResponseEntity<List<SportModel>> getSports() {
        return ResponseEntity.ok(sportService.getAllSports());
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<String> getMethodName(@PathVariable String name) {
        SportModel sport = sportService.getSportByName(name);
        String res = String.format("El nombre del deporte es %s", sport.getName());
        return ResponseEntity.ok(res);
    }

}