package org.ejercicios.concesionarialh.controller;

import org.ejercicios.concesionarialh.dto.CarDTO;
import org.ejercicios.concesionarialh.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController("/v1/api")
public class CarController {

    private CarService service;

    public CarController(CarService service) {
        this.service = service;
    }

    @PostMapping("/vehicles")
    public ResponseEntity<Integer> addCar(@RequestBody CarDTO car) {
        return new ResponseEntity<>(service.addCar(car), HttpStatus.CREATED);
    }

    @GetMapping("/vehicles")
    public ResponseEntity<List<CarDTO>> getCars() {
        return new ResponseEntity<>(service.getAllCars(), HttpStatus.OK);
    }

    @GetMapping("/vehicles/{id}")
    public ResponseEntity<CarDTO> getCar(@PathVariable int id) {
        return new ResponseEntity<>(service.getCar(id), HttpStatus.OK);
    }

    @GetMapping("/vehicles/dates")
    public ResponseEntity<List<CarDTO>> getCarsByDate(@RequestParam String since, @RequestParam String to) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate sinceDate = LocalDate.parse(since, formatter);
        LocalDate untilDate = LocalDate.parse(to, formatter);

        return new ResponseEntity<>(service.getCarsByDate(sinceDate, untilDate), HttpStatus.OK);
    }

    @GetMapping("/vehicles/prices")
    public ResponseEntity<List<CarDTO>> getCarsByPrice(@RequestParam int since, @RequestParam int to) {
        return new ResponseEntity<>(service.getCarsByPrice(since, to), HttpStatus.OK);
    }



}
