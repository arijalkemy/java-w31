package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.DeleteResponseDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;

import java.io.IOException;
import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    String addNewVehicle(VehicleDto vehicleDto);
    List<VehicleDto> searchByColorAndYear(String color, int year);
    List<VehicleDto> searchByBrandAndYear(String brand, int startYear, int endYear);
    String searchAverageSpeedByBrand(String brand);
    String addVehicles(List<VehicleDto>vehicles);
    String updateSpeed(Long id, String speed);
    List<VehicleDto> searchByFuelType(String type);
    DeleteResponseDto deleteVehicleById(Long id);
    List<VehicleDto>searchByTransmission(String type);
    String updateFuel(Long id, String fuelType);
    String searchAveragePeopleByBrand(String brand);
    List<VehicleDto> searchByDimensions(String height, String width);
    List<VehicleDto>searchByWeight(double weightMin, double weightMax);
}
