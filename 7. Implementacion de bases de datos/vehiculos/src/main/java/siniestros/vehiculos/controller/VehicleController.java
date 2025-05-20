package siniestros.vehiculos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import siniestros.vehiculos.dto.VehicleDto;
import siniestros.vehiculos.service.IVehicleService;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private IVehicleService vehicleService;

    @GetMapping
    public ResponseEntity<List<VehicleDto>> findAll() {
        return new ResponseEntity<>(vehicleService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<VehicleDto> save(@RequestBody VehicleDto body) {
        return new ResponseEntity<>(vehicleService.save(body), HttpStatus.OK);
    }

    @GetMapping("/find-all-order-by-year")
    public ResponseEntity<List<VehicleDto>> findAllOrderByYear() {
        return new ResponseEntity<>(vehicleService.findAllOrderByYear(), HttpStatus.OK);
    }

    @GetMapping("/find-by-wheels-greater-than-4-and-current-year")
    public ResponseEntity<List<VehicleDto>> findByWheelsGreaterThan4AndCurrentYear() {
        return new ResponseEntity<>(vehicleService.findByWheelsGreaterThan4AndCurrentYear(), HttpStatus.OK);
    }

    @GetMapping("/find-by-claims-cost-of-money-greater-than-10000")
    public ResponseEntity<List<VehicleDto>> findDistinctByClaimsCostOfDamageGreaterThanEqual() {
        return new ResponseEntity<>(vehicleService.findDistinctByClaimsCostOfDamageGreaterThanEqual(), HttpStatus.OK);
    }
}
