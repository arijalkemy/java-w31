package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    VehicleDto addVehicle(VehicleDto vehicleDto);
    List<VehicleDto> getVehiclesByColorAndYear(String color, int year);
    List<VehicleDto> getVehiclesByBrandAndYearRange(String brand, int start_year, int end_year);
    Double getAvgSpeedByBrand(String brand);
    void updateSpeed(Long id, String newSpeed);
    List<VehicleDto> addVehicles(List<VehicleDto> vehicleDto);
    List<VehicleDto> getVehiclesByFuelType(String type);
    void deleteVehicle(Long id);
    List<VehicleDto> getVehiclesByTransmissionType(String type);
    Double getAvgCapacityByBrand(String brand);
    void updateFuel(Long id, String newFuel);
    List<VehicleDto> getByDimensionsRange(double minLength, double maxLength, double minWidth, double maxWidth);
    List<VehicleDto> getByWeightRange(double min, double max);
}
