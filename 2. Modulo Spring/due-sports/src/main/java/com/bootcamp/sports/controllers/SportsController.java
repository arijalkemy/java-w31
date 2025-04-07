package com.bootcamp.sports.controllers;

import com.bootcamp.sports.dtos.SportDto;
import com.bootcamp.sports.models.Sport;
import com.bootcamp.sports.services.SportsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sport/")
public class SportsController {
    @GetMapping("findSports/")
    public ResponseEntity<List<SportDto>> getSports() {
        List<Sport> sports = SportsService.getSports();
        return new ResponseEntity<>(
                sports.stream().map(SportDto::buildFromSport).collect(Collectors.toList()),
                HttpStatus.OK);
    }

    @GetMapping("findSport/{name}")
    public ResponseEntity<SportDto> getSportByName(@PathVariable String name) {
        Sport sport = SportsService.getSportByName(name);
        if (sport != null) {
            return new ResponseEntity<>(SportDto.buildFromSport(sport), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<Sport> createSport(@RequestBody SportDto sportDto) {
        Sport sport = Sport.buildFromDto(sportDto);
        SportsService.addSport(sport);
        return new ResponseEntity<>(sport, HttpStatus.CREATED);
    }
}
