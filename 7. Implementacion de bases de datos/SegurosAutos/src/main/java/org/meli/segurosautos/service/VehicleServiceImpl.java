package org.meli.segurosautos.service;

import lombok.RequiredArgsConstructor;
import org.meli.segurosautos.dto.VehicleDto;
import org.meli.segurosautos.dto.VehicleTotalLossDto;
import org.meli.segurosautos.repository.IVehicleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements IVehicleService {

    private final IVehicleRepository vehicleRepository;

    @Override
    public List<String> getAllLicensePlates() {
        return vehicleRepository.findAllLicensePlates();
    }

    @Override
    public List<VehicleDto> getLicensePlateAndBrandOrderedByManufactureYear() {
        //return vehicleRepository.findLicensePlateAndBrandOrderedByManufactureYear();
        return vehicleRepository.findByOrderByManufactureYearAsc().stream()
                .map(vehicle -> VehicleDto.builder()
                        .licensePlate(vehicle.getLicensePlate())
                        .brand(vehicle.getBrand())
                        .build())
                .toList();
    }

    @Override
    public List<VehicleDto> getLicensePlateByNumberOfWheelsAndCurrentYear() {
        Integer currentYear = LocalDate.now().getYear();
        return vehicleRepository.findPlatesByNumberOfWheelsAndManufactureYear(currentYear).stream()
                .map(vehicle -> VehicleDto.builder()
                        .licensePlate(vehicle.getLicensePlate())
                        .build())
                .toList();
    }

    @Override
    public List<VehicleDto> getVehiclesByEconomicLoss() {
        return vehicleRepository.findVehiclesByEconomicLoss().stream()
                .map(vehicle -> VehicleDto.builder()
                        .licensePlate(vehicle.getLicensePlate())
                        .brand(vehicle.getBrand())
                        .model(vehicle.getModel())
                        .build())
                .toList();
    }

    @Override
    public List<VehicleTotalLossDto> getVehiclesByEconomicLossSum() {
        return vehicleRepository.findVehiclesByEconomicLossSum();
    }
}
