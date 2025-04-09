package com.mercadolibre.concesionariaauto.controller;

import com.mercadolibre.concesionariaauto.dto.VehicleDTO;
import com.mercadolibre.concesionariaauto.model.Vehicle;
import com.mercadolibre.concesionariaauto.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/vehicles")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @PostMapping
    public ResponseEntity<String> addVehicles(@RequestBody List<Vehicle> vehicles) {
        vehicles.forEach(vehicleService::addVehicle);
        return ResponseEntity.ok("Vehículos guardados correctamente");
    }
    @GetMapping
    public List<VehicleDTO> getVehicles(){
        return this.vehicleService.getVehicles();
    }

    @GetMapping("/dates")
    public List<VehicleDTO> getVehiclesByManufacturingDateRange(
            @RequestParam("since") String since,
            @RequestParam("to") String to) {
        return vehicleService.getVehiclesByManufacturingDateRange(since, to);
    }

    @GetMapping("/prices")
    public List<VehicleDTO> getVehiclesByPrice(
            @RequestParam("since") String since,
            @RequestParam("to") String to) {
        return vehicleService.getVehiclesByPrice(since, to);
    }

    @GetMapping("/{id}")
    public VehicleDTO getVehicleById(@PathVariable Integer id){
        return vehicleService.getVehicleById(id);
    }
}
