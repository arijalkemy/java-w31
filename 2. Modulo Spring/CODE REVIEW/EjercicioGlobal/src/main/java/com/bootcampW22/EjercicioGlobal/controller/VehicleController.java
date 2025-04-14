package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.GenericDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import com.bootcampW22.EjercicioGlobal.utils.Utils;
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

    /* Punto 8 */
    @DeleteMapping("/vehicles/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /* Punto 1 */
    @PostMapping("/vehicles")
    public ResponseEntity<Void> addVehicle(@RequestBody VehicleDto vehicle) {
        vehicleService.addVehicle(vehicle);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /* Punto 5 */
    @PostMapping("/vehicles/batch")
    public ResponseEntity<Void> addVehicles(@RequestBody List<VehicleDto> vehicleDtos) {
        vehicleService.addVehicles(vehicleDtos);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /* Punto 6 */
    @PutMapping("/vehicles/{id}/update_speed")
    public ResponseEntity<Void> updateSpeed(@PathVariable Long id,
                                            @RequestBody GenericDto<String> body) {
        vehicleService.updateSpeed(id, body.getValue());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /* Punto 10 */
    @PutMapping("/vehicles/{id}/update_fuel")
    public ResponseEntity<Void> updateFuel(@PathVariable Long id,
                                           @RequestBody GenericDto<String> body) {
        vehicleService.updateFuel(id, body.getValue());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /* Punto 2 */
    @GetMapping("/vehicles/color/{color}/year/{year}")
    public ResponseEntity<List<VehicleDto>> getByColorAndYear(@PathVariable String color,
                                                              @PathVariable int year) {
        return new ResponseEntity<>(vehicleService.getByColorAndYear(color, year), HttpStatus.OK);
    }

    /* Punto 7 */
    @GetMapping("/vehicles/fuel_type/{type}")
    public ResponseEntity<List<VehicleDto>> getByColorAndYear(@PathVariable String type) {
        return new ResponseEntity<>(vehicleService.getByFuelType(type), HttpStatus.OK);
    }

    /* Punto 9 */
    @GetMapping("/vehicles/transmission/{type}")
    public ResponseEntity<List<VehicleDto>> getByTransmission(@PathVariable String type) {
        return new ResponseEntity<>(vehicleService.getByTransmission(type), HttpStatus.OK);
    }

    /* Punto 12 */
    @GetMapping("/vehicles/dimensions")
    public ResponseEntity<List<VehicleDto>> getByDimensions(@RequestParam String length,
                                                            @RequestParam String width) {
        double[] lengthParams = Utils.separateDimensionParams(length);
        double[] widthParams = Utils.separateDimensionParams(width);

        return new ResponseEntity<>(
                vehicleService.getByDimensions(lengthParams[0], lengthParams[1], widthParams[0], widthParams[1]),
                HttpStatus.OK);
    }

    /* Punto 13 */
    @GetMapping("/vehicles/weight")
    public ResponseEntity<List<VehicleDto>> getByWeight(@RequestParam double min, @RequestParam double max) {
        return new ResponseEntity<>(vehicleService.getByWeight(min, max), HttpStatus.OK);
    }

    /* Punto 3 */
    @GetMapping("/vehicles/brand/{brand}/between/{start_year}/{end_year}")
    public ResponseEntity<List<VehicleDto>> getByBrandAndYears(@PathVariable String brand,
                                                               @PathVariable int start_year,
                                                               @PathVariable int end_year) {
        return new ResponseEntity<>(vehicleService.getByBrandAndYears(brand, start_year, end_year), HttpStatus.OK);
    }

    /* Punto 4 */
    @GetMapping("/vehicles/average_speed/brand/{brand}")
    public ResponseEntity<GenericDto<Double>> getAvgSpeedByBrand(@PathVariable String brand) {
        Double avgSpeed = vehicleService.getAvgSpeedByBrand(brand);
        GenericDto<Double> response = new GenericDto<>("avgSpeed", avgSpeed);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /* Punto 11 */
    @GetMapping("/vehicles/average_capacity/brand/{brand}")
    public ResponseEntity<GenericDto<Double>> getAvgCapacityByBrand(@PathVariable String brand) {
        Double avgSpeed = vehicleService.getAvgCapacityByBrand(brand);
        GenericDto<Double> response = new GenericDto<>("avgCapacity", avgSpeed);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
