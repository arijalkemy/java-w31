package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;
import java.util.OptionalDouble;

public interface IVehicleRepository {
    List<Vehicle> findAll();
    void addVehicle(VehicleDto vehicleDto);
    List<Vehicle> findVehiclesByColorAndYear(String color, int year);
    List<Vehicle> findVehiclesByBrandAndBeetweenYears(String brand, int startYear,int endYear);
    Double checkAverageSpeedByBrand(String brand);
    List<Vehicle> addVehicleList(List<VehicleDto> vehicleDtoList);
    List<Vehicle> updateSpeedByVehicle(int id, VehicleDto vehicleDto);
}
