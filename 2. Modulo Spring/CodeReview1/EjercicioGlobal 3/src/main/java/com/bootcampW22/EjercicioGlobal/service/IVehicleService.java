package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.RequestFuelTypeDto;
import com.bootcampW22.EjercicioGlobal.dto.ResponseDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    boolean deleteVehicleById(Long id);
    ResponseDto addListOfVehicles(List<VehicleDto> vehicles);
    List<VehicleDto> searchVehiclesByDimensions(String height, String width);
    ResponseDto searchAverageCapacityByBrand(String brand);
    ResponseDto updateFuelType(Long id, RequestFuelTypeDto fuelType);
    List<VehicleDto> searchVehiclesByTransmission(String type);
    List<VehicleDto> searchVehiclesByWeight(double minWeight, double maxWeight);
    List<VehicleDto> searchVehiclesByBrandAndYear(String brand, int startYear, int endYear);
}
