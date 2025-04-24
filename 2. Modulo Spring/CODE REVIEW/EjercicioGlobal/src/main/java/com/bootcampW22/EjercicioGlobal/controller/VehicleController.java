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
@RequestMapping("/vehicles")
public class VehicleController {

    IVehicleService vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService){
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public ResponseEntity<?> getVehicles(){
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }

    /* Punto 8 */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /* Punto 1 */
    @PostMapping
    public ResponseEntity<Void> addVehicle(@RequestBody VehicleDto vehicle) {
        vehicleService.addVehicle(vehicle);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /* Punto 5 */
    @PostMapping("/batch")
    public ResponseEntity<Void> addVehicles(@RequestBody List<VehicleDto> vehicleDtos) {
        vehicleService.addVehicles(vehicleDtos);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /* Punto 6 */
    @PutMapping("/{id}/update_speed")
    public ResponseEntity<Void> updateSpeed(@PathVariable Long id,
                                            @RequestBody VehicleDto vehicle) {
        vehicleService.updateSpeed(id, vehicle.getMax_speed());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /* Punto 10 */
    @PutMapping("/{id}/update_fuel")
    public ResponseEntity<Void> updateFuel(@PathVariable Long id,
                                           @RequestBody VehicleDto vehicle) {
        vehicleService.updateFuel(id, vehicle.getFuel_type());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /* Punto 2 */
    @GetMapping("/color/{color}/year/{year}")
    public ResponseEntity<List<VehicleDto>> getByColorAndYear(@PathVariable String color,
                                                              @PathVariable int year) {
        return new ResponseEntity<>(vehicleService.getByColorAndYear(color, year), HttpStatus.OK);
    }

    /* Punto 7 */
    @GetMapping("/fuel_type/{type}")
    public ResponseEntity<List<VehicleDto>> getByFuelType(@PathVariable String type) {
        return new ResponseEntity<>(vehicleService.getByFuelType(type), HttpStatus.OK);
    }

    /* Punto 9 */
    @GetMapping("/transmission/{type}")
    public ResponseEntity<List<VehicleDto>> getByTransmission(@PathVariable String type) {
        return new ResponseEntity<>(vehicleService.getByTransmission(type), HttpStatus.OK);
    }

    /* Punto 12 */
    @GetMapping("/dimensions")
    public ResponseEntity<List<VehicleDto>> getByDimensions(@RequestParam String length,
                                                            @RequestParam String width) {
        return new ResponseEntity<>(vehicleService.getByDimensions(length, width), HttpStatus.OK);
    }

    /* Punto 13 */
    @GetMapping("/weight")
    public ResponseEntity<List<VehicleDto>> getByWeight(@RequestParam double min, @RequestParam double max) {
        return new ResponseEntity<>(vehicleService.getByWeight(min, max), HttpStatus.OK);
    }

    /* Punto 3 */
    @GetMapping("/brand/{brand}/between/{start_year}/{end_year}")
    public ResponseEntity<List<VehicleDto>> getByBrandAndYears(@PathVariable String brand,
                                                               @PathVariable int start_year,
                                                               @PathVariable int end_year) {
        return new ResponseEntity<>(vehicleService.getByBrandAndYears(brand, start_year, end_year), HttpStatus.OK);
    }

    /* Punto 4 */
    @GetMapping("/average_speed/brand/{brand}")
    public ResponseEntity<GenericDto<Double>> getAvgSpeedByBrand(@PathVariable String brand) {
        return new ResponseEntity<>(vehicleService.getAvgSpeedByBrand(brand), HttpStatus.OK);
    }

    /* Punto 11 */
    @GetMapping("/average_capacity/brand/{brand}")
    public ResponseEntity<GenericDto<Double>> getAvgCapacityByBrand(@PathVariable String brand) {
        return new ResponseEntity<>(vehicleService.getAvgCapacityByBrand(brand), HttpStatus.OK);
    }

}
