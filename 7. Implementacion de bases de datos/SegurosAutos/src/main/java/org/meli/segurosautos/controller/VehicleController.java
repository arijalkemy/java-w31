package org.meli.segurosautos.controller;

import lombok.RequiredArgsConstructor;
import org.meli.segurosautos.dto.VehicleDto;
import org.meli.segurosautos.dto.VehicleTotalLossDto;
import org.meli.segurosautos.service.IVehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final IVehicleService vehicleService;

    @GetMapping("/license_plates")
    public ResponseEntity<List<String>> getAllLicensePlates() {
        return new ResponseEntity<>(vehicleService.getAllLicensePlates(), HttpStatus.OK);
    }

    @GetMapping("/license_plate-brand")
    public ResponseEntity<List<VehicleDto>> getLicensePlateAndBrand() {
        return new ResponseEntity<>(vehicleService.getLicensePlateAndBrandOrderedByManufactureYear(), HttpStatus.OK);
    }

    @GetMapping("/license_plate/manufacture_current-year")
    public ResponseEntity<List<VehicleDto>> getLicensePlateByManufactureCurrentYear() {
        return new ResponseEntity<>(vehicleService.getLicensePlateByNumberOfWheelsAndCurrentYear(), HttpStatus.OK);
    }

    @GetMapping("/claim_loss")
    public ResponseEntity<List<VehicleDto>> getClaimLossGreaterThan10000() {
        return new ResponseEntity<>(vehicleService.getVehiclesByEconomicLoss(), HttpStatus.OK);
    }

    @GetMapping("/claim_total-loss")
    public ResponseEntity<List<VehicleTotalLossDto>> getClaimTotalLossGreaterThan10000() {
        return new ResponseEntity<>(vehicleService.getVehiclesByEconomicLossSum(), HttpStatus.OK);
    }
}
