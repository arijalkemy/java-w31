package com.mercadolibre.aseguradora.controller;

import com.mercadolibre.aseguradora.dto.VehicleBasicInfoDTO;
import com.mercadolibre.aseguradora.dto.VehicleInfoResponseDTO;
import com.mercadolibre.aseguradora.dto.VehicleLossInfoDTO;
import com.mercadolibre.aseguradora.dto.VehiclePlateBrandDTO;
import com.mercadolibre.aseguradora.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    // 1. List all license plates
    @GetMapping("/plates")
    public List<String> getAllLicensePlates() {
        return vehicleService.getAllLicensePlates();
    }

    // 2. List license plate and brand, ordered by manufacture year
    @GetMapping("/plates-brands")
    public List<VehiclePlateBrandDTO> getLicensePlateAndBrandOrderedByYear() {
        return vehicleService.getLicensePlateAndBrandOrderedByYear();
    }

    // 3. Vehicles with more than 4 wheels and manufactured this year
    @GetMapping("/current-year/more-than-4-wheels")
    public List<String> getCurrentYearVehiclesWithMoreThanFourWheels() {
        return vehicleService.getCurrentYearVehiclesWithMoreThanFourWheels();
    }

    // 4. Vehicles with at least one accident over 10,000
    @GetMapping("/accidents/loss-over-10000")
    public List<VehicleBasicInfoDTO> getVehiclesWithAccidentOverTenThousand() {
        return vehicleService.getVehiclesWithAccidentOverTenThousand();
    }

    // 5. Vehicles with accident > 10,000 and total loss
    @GetMapping("/accidents/total-loss-over-10000")
    public List<VehicleLossInfoDTO> getVehiclesWithAccidentOverTenThousandAndTotalLoss() {
        return vehicleService.getVehiclesWithAccidentOverTenThousandAndTotalLoss();
    }

    // 6. Vehicles with accident count
    @GetMapping("/accidents/count")
    public List<VehicleInfoResponseDTO> getVehiclesWithAccidentCount() {
        return vehicleService.getVehiclesWithAccidentCount();
    }
}

