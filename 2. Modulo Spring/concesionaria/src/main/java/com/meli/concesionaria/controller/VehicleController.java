package com.meli.concesionaria.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meli.concesionaria.dto.CreateVehicleRequestDTO;
import com.meli.concesionaria.dto.GetVehicleResponseDTO;
import com.meli.concesionaria.service.VehicleService;

import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/v1/api/vehicles")
@RequiredArgsConstructor
public class VehicleController {
    private final VehicleService vehicleService;

    @PostMapping()
    public ResponseEntity<String> createVehicle(@RequestBody CreateVehicleRequestDTO body) {
        return ResponseEntity.ok(vehicleService.createVehicle(body));
    }

    @GetMapping()
    public ResponseEntity<List<GetVehicleResponseDTO>> getAllVehicles() {
        return ResponseEntity.ok(vehicleService.getAllVehicles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetVehicleResponseDTO> getVehicleById(@PathVariable String id) {
        return ResponseEntity.ok(vehicleService.getVehicleById(id));
    }

    @GetMapping("/prices")
    public ResponseEntity<List<GetVehicleResponseDTO>> getFromPrice(
            @RequestParam Double priceMin,
            @RequestParam Double priceMax) {
        return ResponseEntity.ok(vehicleService.getFromPrices(priceMin, priceMax));
    }

    @GetMapping("/dates")
    public ResponseEntity<List<GetVehicleResponseDTO>> getFromDates(
            @RequestParam String dateFrom,
            @RequestParam String dateTo) {
        return ResponseEntity.ok(vehicleService.getFromDates(LocalDate.parse(dateFrom), LocalDate.parse(dateTo)));
    }

}
