package com.mercadolibre.aseguradora.service;

import com.mercadolibre.aseguradora.dto.VehicleBasicInfoDTO;
import com.mercadolibre.aseguradora.dto.VehicleInfoResponseDTO;
import com.mercadolibre.aseguradora.dto.VehicleLossInfoDTO;
import com.mercadolibre.aseguradora.dto.VehiclePlateBrandDTO;
import com.mercadolibre.aseguradora.model.Vehicle;
import com.mercadolibre.aseguradora.repository.IVehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Year;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final IVehicleRepository vehicleRepository;

    // 1. List all license plates
    public List<String> getAllLicensePlates() {
        return vehicleRepository.findAll().stream()
                .map(Vehicle::getLicensePlate)
                .toList();
    }

    // 2. List license plate and brand, ordered by manufacture year
    public List<VehiclePlateBrandDTO> getLicensePlateAndBrandOrderedByYear() {
        return vehicleRepository.findAllByOrderByManufactureYearAsc().stream()
                .map(v -> new VehiclePlateBrandDTO(v.getLicensePlate(), v.getBrand()))
                .toList();
    }

    // 3. Vehicles with more than 4 wheels and manufactured this year
    public List<String> getCurrentYearVehiclesWithMoreThanFourWheels() {
        int currentYear = Year.now().getValue();
        return vehicleRepository.findVehiclesWithMoreThan4WheelsAndManufacturedInYear(2023).stream()
                .map(Vehicle::getLicensePlate)
                .toList();
    }

    // 4. Vehicles with at least one accident over 10,000
    public List<VehicleBasicInfoDTO> getVehiclesWithAccidentOverTenThousand() {
        return vehicleRepository.findVehiclesWithAccidentsOverLoss(10000).stream()
                .map(v -> new VehicleBasicInfoDTO(v.getLicensePlate(), v.getBrand(), v.getModel()))
                .toList();
    }

    // 5. Vehicles with accident > 10,000 and total loss
    public List<VehicleLossInfoDTO> getVehiclesWithAccidentOverTenThousandAndTotalLoss() {
        return vehicleRepository.findVehiclesWithTotalLossOver(10000).stream()
                .map(v -> {
                    Vehicle vehicle = (Vehicle) v[0];
                    BigDecimal totalLoss = (BigDecimal) v[1];
                    return new VehicleLossInfoDTO(vehicle.getLicensePlate(), vehicle.getBrand(), vehicle.getModel(), totalLoss);
                })
                .collect(Collectors.toList());
    }

    // 6. Vehicles with accident count
    public List<VehicleInfoResponseDTO> getVehiclesWithAccidentCount() {
        return vehicleRepository.findAll().stream()
                .map(v -> new VehicleInfoResponseDTO(v.getAccidents().size(), v))
                .toList();
    }
}

