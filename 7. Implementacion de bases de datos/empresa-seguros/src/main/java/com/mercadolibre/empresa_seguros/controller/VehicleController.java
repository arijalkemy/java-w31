package com.mercadolibre.empresa_seguros.controller;

import com.mercadolibre.empresa_seguros.dto.request.VehicleDto;
import com.mercadolibre.empresa_seguros.service.IVehicleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/vehicles")
public class VehicleController {
    private final IVehicleService vehicleService;

    @PostMapping("/create")
    public ResponseEntity<VehicleDto> addVehicleAccident(
            @RequestBody VehicleDto vehicleDto){
        return new ResponseEntity<>(vehicleService.addVehicle(vehicleDto), HttpStatus.OK);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<VehicleDto>> getAll(){
        return new ResponseEntity<>(vehicleService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/getquery")
    public ResponseEntity<?> getQuery(){
        return new ResponseEntity<>(vehicleService.getQuery(), HttpStatus.OK);
    }
}
