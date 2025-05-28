package com.sports.demo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sports.demo.dto.PersonDto;
import com.sports.demo.dto.SportDto;
import com.sports.demo.entity.Sport;
import com.sports.demo.service.ISportService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/sports")
@RequiredArgsConstructor
public class SportController {

    private final ISportService sportService;

    @GetMapping("/findSports")
    public ResponseEntity<List<SportDto>> getAllSports() {
        return new ResponseEntity<>(sportService.findSports(), HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<SportDto> getSportByName(@PathVariable String name) throws Exception {
        return new ResponseEntity<>(sportService.getSportByName(name), HttpStatus.OK);
    }
    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonDto>> getAllSportPersons(){
        return new ResponseEntity<>(sportService.findSportPerson(),HttpStatus.OK);
    }
    

}
