package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    void addVehicle(VehicleDto vehicleDto);
    List<VehicleDto> findVehiclesByColorAndYear(String color, int year);
    List<VehicleDto> findVehiclesByBrandAndBeetweenYears(String brand, int startYear, int endYear);
    Double checkAverageSpeedByBrand(String brand);
    List<VehicleDto> addVehicleList(List<VehicleDto> vehicleList);
    List<VehicleDto> updateSpeedByVehicle(int id, VehicleDto vehicleDto);
}
