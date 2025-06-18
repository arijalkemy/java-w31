package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.ResponseDto;
import com.bootcampW22.EjercicioGlobal.dto.ResquestSpeedDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    String addVehicles(List<VehicleDto> vehicles);
    String addVehicle(VehicleDto vehicleDto);
    String searchAverageSpeedByBrand(String brand);
    List<VehicleDto> searchVehiclesByDimensions(String height, String width);
    boolean removeById(Long id);
    ResponseDto updateSpeedById(Long id, ResquestSpeedDto speedDto);
    List<VehicleDto> searchByBrandAndYear(String brand, int startYear, int endYear);
    ResponseDto searchAverageCapacityByBrand(String brand);
    List<VehicleDto> searchByYearAndBrand(String color, int year);
    List<VehicleDto> searchByFuelType(String fuelType);
}
