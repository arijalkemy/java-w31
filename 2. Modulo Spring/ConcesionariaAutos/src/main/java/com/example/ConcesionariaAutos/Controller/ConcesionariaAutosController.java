package com.example.ConcesionariaAutos.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ConcesionariaAutos.Entities.Vehicle;
import com.example.ConcesionariaAutos.Service.ConcesionariaAutosService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/v1/api/vehicles")
public class ConcesionariaAutosController {

    @Autowired
    ConcesionariaAutosService concesionariaAutosService;

    @PostMapping()
    public ResponseEntity<?> postVehicle(@RequestBody Vehicle vehicle) {
        return new ResponseEntity<>(concesionariaAutosService.newVehicle(vehicle), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<?> getVehicles() {
        return new ResponseEntity<>(concesionariaAutosService.getVehicles(), HttpStatus.OK);
    }

    @GetMapping("/dates")
    public ResponseEntity<?> getVehiclesByManufacturingDate(@RequestParam String since, @RequestParam String to) {
        if (since == null || to == null) {
            return new ResponseEntity<>("Formato de fecha inválido", HttpStatus.BAD_REQUEST);
        } else if (since.isEmpty() || to.isEmpty()) {
            return new ResponseEntity<>("Formato de fecha inválido", HttpStatus.BAD_REQUEST);
        }

        LocalDate startLocalDate;
        LocalDate endLocalDate;

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            startLocalDate = LocalDate.parse(since, formatter);
            endLocalDate = LocalDate.parse(to, formatter);
        } catch (DateTimeParseException e) {
            return new ResponseEntity<>("Formato de fecha inválido", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(
                concesionariaAutosService.getVehiclesByManufacturingDate(startLocalDate, endLocalDate),
                HttpStatus.OK);
    }

    @GetMapping("/prices")
    public ResponseEntity<?> getVehiclesByPriceRange(@RequestParam String since, @RequestParam String to) {
        if (since == null || to == null) {
            return new ResponseEntity<>("Formato de precio inválido", HttpStatus.BAD_REQUEST);
        }

        Double startPriceDouble;
        Double endPriceDouble;
        try {
            startPriceDouble = Double.parseDouble(since);
            endPriceDouble = Double.parseDouble(to);
        } catch (Exception e) {
            return new ResponseEntity<>("Formato de precio inválido", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(
                concesionariaAutosService.getVehiclesByPriceRange(startPriceDouble, endPriceDouble),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getVehicleById(@PathVariable Integer id) {
        return new ResponseEntity<>(concesionariaAutosService.getVehicleById(id), HttpStatus.OK);
    }

}
