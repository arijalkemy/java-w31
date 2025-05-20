package com.mercadolibre.empresa_seguros.controller;

import com.mercadolibre.empresa_seguros.dto.request.VehicleAccidentDto;
import com.mercadolibre.empresa_seguros.service.IVehicleAccidentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/vehicle-accident")
public class VehicleAccidentController {
    private final IVehicleAccidentService vehicleAccidentService;

    @PostMapping("/create")
    public ResponseEntity<VehicleAccidentDto> addVehicleAccident(
            @RequestBody VehicleAccidentDto vehicleAccidentDto){
        return new ResponseEntity<>(vehicleAccidentService.addVehicleAccident(vehicleAccidentDto), HttpStatus.OK);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<VehicleAccidentDto>> getAll(){
        return new ResponseEntity<>(vehicleAccidentService.getAll(), HttpStatus.OK);
    }
}
