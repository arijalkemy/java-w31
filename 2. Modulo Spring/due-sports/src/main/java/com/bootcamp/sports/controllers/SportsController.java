package com.bootcamp.sports.controllers;

import com.bootcamp.sports.dtos.SportDto;
import com.bootcamp.sports.services.SportsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sport/")
public class SportsController {
    @GetMapping("findSports/")
    public ResponseEntity<List<SportDto>> getSports() {
        List<SportDto> sports = SportsService.getSports();
        return new ResponseEntity<>(sports, HttpStatus.OK);
    }

    @GetMapping("findSport/{name}")
    public ResponseEntity<SportDto> getSportByName(@PathVariable String name) {
        SportDto sport = SportsService.getSportByName(name);
        if (sport != null) {
            return new ResponseEntity<>(sport, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<SportDto> createSport(@RequestBody SportDto sportDto) {
        SportDto result = SportsService.addSport(sportDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
