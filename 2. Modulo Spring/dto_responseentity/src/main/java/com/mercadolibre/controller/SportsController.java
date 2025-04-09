package com.mercadolibre.controller;

import com.mercadolibre.model.SportDto;
import com.mercadolibre.model.SportsManDto;
import com.mercadolibre.service.ISportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sport")
public class SportsController {

    @Autowired
    ISportService sportService;

    @GetMapping(path="/find-sports")
    public ResponseEntity<List<SportDto>> findAllSports() {
        System.out.println("adsdasdasdsad");
        return ResponseEntity.ok(sportService.findAll());
    }

    @GetMapping(path="/find-sport/{name}")
    public ResponseEntity<SportDto> findSportByName(@PathVariable("name") String name) {
        SportDto sportFound = sportService.findByName(name);

        if (sportFound != null) {
            return ResponseEntity.ok(sportFound);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/find-sports-persons")
    public ResponseEntity<List<SportsManDto>> findSportsPersons(){
        List<SportsManDto> sportsMenDtoList =  sportService.findSoportsAndPersons();
         if (sportsMenDtoList.isEmpty()){
             return ResponseEntity.notFound().build();
         }
         return ResponseEntity.ok(sportsMenDtoList);
    }

}
