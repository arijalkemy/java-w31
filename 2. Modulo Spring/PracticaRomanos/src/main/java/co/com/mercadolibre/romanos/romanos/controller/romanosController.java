package co.com.mercadolibre.romanos.romanos.controller;

import org.springframework.web.bind.annotation.RestController;

import co.com.mercadolibre.romanos.romanos.service.romanosService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class romanosController {

    @GetMapping("/romans")
    public ResponseEntity<?> getRomansNumber(@RequestParam int numberToBeTurnedIntoRoman) {
        return ResponseEntity.ok().body(romanosService.toRoman(numberToBeTurnedIntoRoman));
    }
    
}
