package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    void deleteVehicle(Long id);
    void addVehicle(VehicleDto vehicleDto);
    void addVehicles(List<VehicleDto> vehicleDtos);
    void updateSpeed(Long id, String newSpeed);
    void updateFuel(Long id, String newFuel);
    List<VehicleDto> getByColorAndYear(String color, int year);
    List<VehicleDto> getByFuelType(String fuelType);
    List<VehicleDto> getByTransmission(String transmission);
    List<VehicleDto> getByDimensions(double minLength, double maxLength, double minWidth, double maxWidth);
    List<VehicleDto> getByWeight(double min, double max);
    List<VehicleDto> getByBrandAndYears(String brand, int startYear, int endYear);
    Double getAvgSpeedByBrand(String brand);
    Double getAvgCapacityByBrand(String brand);
}
