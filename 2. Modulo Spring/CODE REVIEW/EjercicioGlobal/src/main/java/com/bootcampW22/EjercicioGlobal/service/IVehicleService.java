package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.GenericDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    Vehicle getVehicleById(Long id);
    void deleteVehicle(Long id);
    void addVehicle(VehicleDto vehicleDto);
    void addVehicles(List<VehicleDto> vehicleDtos);
    void updateSpeed(Long id, String newSpeed);
    void updateFuel(Long id, String newFuel);
    List<VehicleDto> getByColorAndYear(String color, int year);
    List<VehicleDto> getByFuelType(String fuelType);
    List<VehicleDto> getByTransmission(String transmission);
    List<VehicleDto> getByDimensions(String length, String width);
    List<VehicleDto> getByWeight(double min, double max);
    List<VehicleDto> getByBrandAndYears(String brand, int startYear, int endYear);
    GenericDto<Double> getAvgSpeedByBrand(String brand);
    GenericDto<Double> getAvgCapacityByBrand(String brand);
}
