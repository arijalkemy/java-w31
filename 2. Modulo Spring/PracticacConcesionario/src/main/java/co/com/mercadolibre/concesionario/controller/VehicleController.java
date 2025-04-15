package co.com.mercadolibre.concesionario.controller;

import org.springframework.web.bind.annotation.RestController;

import co.com.mercadolibre.concesionario.dto.VehicleDto;
import co.com.mercadolibre.concesionario.service.VehicleService;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/v1/api/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public ResponseEntity<List<VehicleDto>> getAll() {
        return ResponseEntity.ok().body(vehicleService.getAll());
    }

    @GetMapping("/dates")
    public ResponseEntity<List<VehicleDto>> getAllByDatesManufacturerRange
    (@RequestParam LocalDate since, @RequestParam LocalDate to) {
        return ResponseEntity.ok().body(vehicleService.getAllByManuFacturingDate(since, to));
    }
    
    @GetMapping("/prices")
    public ResponseEntity<List<VehicleDto>> getAllByPriceRange
    (@RequestParam double since, @RequestParam double to) {
        return ResponseEntity.ok().body(vehicleService.getAllByPrices(since, to));
    }
    

    @PostMapping
    public ResponseEntity<?> postMethodName(@RequestBody VehicleDto vehicleDto) {
        vehicleService.save(vehicleDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    

}
