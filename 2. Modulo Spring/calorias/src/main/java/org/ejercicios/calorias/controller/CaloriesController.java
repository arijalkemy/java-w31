package org.ejercicios.calorias.controller;

import org.ejercicios.calorias.service.CaloriesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CaloriesController {

    private CaloriesService service;

    public CaloriesController(CaloriesService service) {
        this.service = service;
    }

    @GetMapping("/recipe/{name}")
    public ResponseEntity<?> getDataFromRecipe(@PathVariable String name) {
        return new ResponseEntity<>(service.getDataFromRecipe(name), HttpStatus.OK);
    }


}
