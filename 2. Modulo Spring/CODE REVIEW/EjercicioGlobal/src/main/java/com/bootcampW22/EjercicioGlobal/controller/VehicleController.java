package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.GenericDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {

    IVehicleService vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService){
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicles")
    public ResponseEntity<?> getVehicles(){
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }

    /* Punto 1 */
    @PostMapping("/vehicles")
    public ResponseEntity<GenericDto<VehicleDto>> addVehicle(@RequestBody VehicleDto vehicleDto) {
        return new ResponseEntity<>(new GenericDto<VehicleDto>("createdVehicle", vehicleService.addVehicle(vehicleDto)), HttpStatus.OK);
    }

    /* Punto 2 */
    @GetMapping("/vehicles/color/{color}/year/{year}")
    public ResponseEntity<List<VehicleDto>> getVehiclesByColorAndYear(@PathVariable String color,
                                                                      @PathVariable int year) {
        return new ResponseEntity<>(vehicleService.getVehiclesByColorAndYear(color, year), HttpStatus.OK);
    }

    /* Punto 3 */
    @GetMapping("/vehicles/brand/{brand}/between/{start_year}/{end_year}")
    public ResponseEntity<List<VehicleDto>> getVehiclesByBrandAndYearRange(@PathVariable String brand,
                                                                           @PathVariable int start_year,
                                                                           @PathVariable int end_year) {
        return new ResponseEntity<>(vehicleService.getVehiclesByBrandAndYearRange(brand, start_year, end_year), HttpStatus.OK);
    }

    /* Punto 4 - Custom DTO */
    @GetMapping("/vehicles/average_speed/brand/{brand}")
    public ResponseEntity<GenericDto<Double>> getAvgSpeedByBrand(@PathVariable String brand) {
        Double avgSpeed = vehicleService.getAvgSpeedByBrand(brand);
        return new ResponseEntity<>(new GenericDto<Double>("averageSpeed", avgSpeed), HttpStatus.OK);
    }

    /* Punto 5 */
    @PostMapping("/vehicles/batch")
    public ResponseEntity<GenericDto<List<VehicleDto>>> addVehicles(@RequestBody List<VehicleDto> vehiclesDtos) {
        vehicleService.addVehicles(vehiclesDtos);
        return new ResponseEntity<>(new GenericDto<>("createdVehicles", vehiclesDtos), HttpStatus.OK);
    }

    /* Punto 6 */
    @PutMapping("/vehicles/{id}/update_speed")
    public ResponseEntity<GenericDto> updateSpeed(@PathVariable Long id, @RequestBody GenericDto<String> body) {
        String newSpeed = body.getValue();
        vehicleService.updateSpeed(id, body.getValue());
        return new ResponseEntity<>(new GenericDto<>("updated", newSpeed), HttpStatus.OK);
    }

    /* Punto 7 */
    @GetMapping("/vehicles/fuel_type/{type}")
    public ResponseEntity<List<VehicleDto>> getVehiclesByFuelType(@PathVariable String type) {
        return new ResponseEntity<>(vehicleService.getVehiclesByFuelType(type), HttpStatus.OK);
    }

    /* Punto 8 */
    @DeleteMapping("/vehicles/{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /* Punto 9 */
    @GetMapping("/vehicles/transmission/{type}")
    public ResponseEntity<List<VehicleDto>> getVehiclesByTransmissionType(@PathVariable String type) {
        return new ResponseEntity<>(vehicleService.getVehiclesByTransmissionType(type), HttpStatus.OK);
    }

    /* Punto 10 */
    @PutMapping("/vehicles/{id}/update_fuel")
    public ResponseEntity<GenericDto> updateFuel(@PathVariable Long id, @RequestBody GenericDto<String> body) {
        String newFuel = body.getValue();
        vehicleService.updateFuel(id, body.getValue());
        return new ResponseEntity<>(new GenericDto<>("updated", newFuel), HttpStatus.OK);
    }

    /* Punto 11 - Custom DTO */
    @GetMapping("/vehicles/average_capacity/brand/{brand}")
    public ResponseEntity<GenericDto<Double>> getAvgCapacityByBrand(@PathVariable String brand) {
        Double avgCapacity = vehicleService.getAvgCapacityByBrand(brand);
        return new ResponseEntity<>(new GenericDto<Double>("averageCapacity", avgCapacity), HttpStatus.OK);
    }

    /* Punto 12 */
    @GetMapping("/vehicles/dimensions")
    public ResponseEntity<List<VehicleDto>> getByDimensionsRange(@RequestParam String length,
                                             @RequestParam String width
                                             ) {
        double minLength = Double.parseDouble(length.split("-")[0]);
        double maxLength = Double.parseDouble(length.split("-")[1]);

        double minWidth = Double.parseDouble(width.split("-")[0]);
        double maxWidth = Double.parseDouble(width.split("-")[1]);

        return new ResponseEntity<>(vehicleService.getByDimensionsRange(minLength, maxLength, minWidth, maxWidth), HttpStatus.OK);
    }

    /* Punto 13 */
    @GetMapping("/vehicles/weight")
    public ResponseEntity<List<VehicleDto>> getByWeightRange(@RequestParam double min, @RequestParam double max) {
        return new ResponseEntity<>(vehicleService.getByWeightRange(min, max), HttpStatus.OK);
    }

}
