package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> findAll();
    boolean loadVehicle(Vehicle vehicle);
    List<Vehicle> findByBrand(String brand);
    List<Vehicle> findByDimensions(double minHeight, double maxHeight, double minWidth, double maxWidth);
    boolean removeVehicle(Long id);
    Vehicle findById(Long id);
    List<Vehicle> findByBrandAndYear(String color, int year);
    List<Vehicle> findByFuelType(String fuelType);
}
