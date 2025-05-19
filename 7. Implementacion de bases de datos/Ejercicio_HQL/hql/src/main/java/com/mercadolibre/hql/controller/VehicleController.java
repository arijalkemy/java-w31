package com.mercadolibre.hql.controller;

import com.mercadolibre.hql.dto.VehicleDto;
import com.mercadolibre.hql.dto.VehicleLossDTO;
import com.mercadolibre.hql.dto.VehicleSummaryDto;
import com.mercadolibre.hql.service.IVehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final IVehicleService vehicleService;

    public VehicleController(IVehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping()
    public ResponseEntity<VehicleDto> createVehicle(@RequestBody VehicleDto vehicleDto) {
        VehicleDto savedVehicle = vehicleService.save(vehicleDto);
        return ResponseEntity.ok(savedVehicle);
    }

    @GetMapping
    public ResponseEntity<List<VehicleDto>> getAllVehicles() {
        return ResponseEntity.ok(vehicleService.findAll());
    }

    @GetMapping("/patents")
    public ResponseEntity<List<String>> getAllPatents() {
        return ResponseEntity.ok(vehicleService.getAllPatents());
    }

    @GetMapping("/summaries")
    public ResponseEntity<List<VehicleSummaryDto>> getAllSummaries() {
        return ResponseEntity.ok(vehicleService.findAllPatentAndBrandOrderByManufacturingYear());
    }

    @GetMapping("/patents/heavy-current-year")
    public ResponseEntity<List<String>> getHeavyVehiclesFromCurrentYear() {
        return ResponseEntity.ok(vehicleService.getHeavyCurrentYearVehicles());
    }

    @GetMapping("/with-high-loss-accidents")
    public ResponseEntity<List<VehicleDto>> getVehiclesWithExpensiveAccidents() {
        return ResponseEntity.ok(vehicleService.getVehiclesWithAccidentsOver10000());
    }

    @GetMapping("/high-losses")
    public ResponseEntity<List<VehicleLossDTO>> getVehiclesWithHighLosses() {
        List<VehicleLossDTO> vehicles = vehicleService.getVehiclesWithHighLosses();
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDto> getVehicleById(@PathVariable Long id) {
        VehicleDto vehicle = vehicleService.findById(id);
        return ResponseEntity.ok(vehicle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleDto> updateVehicle(@PathVariable Long id, @RequestBody VehicleDto vehicleDto) {
        VehicleDto updatedVehicle = vehicleService.update(id, vehicleDto);
        return ResponseEntity.ok(updatedVehicle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
        vehicleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
