package co.com.mercadolibre.practicadeportistas.practicadeportistas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.mercadolibre.practicadeportistas.practicadeportistas.dto.SportDto;
import co.com.mercadolibre.practicadeportistas.practicadeportistas.service.SportService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class SportController {

    private final SportService sportService;

    public SportController(SportService sportService) {
        this.sportService = sportService;
    }

    @GetMapping("/findSports")
    public ResponseEntity<List<SportDto>> getSports() {
        return ResponseEntity.ok(sportService.getSports());
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<SportDto> getSportByName(@PathVariable String name) {
        return ResponseEntity.ok(sportService.findSportByName(name));
    }
    
}
