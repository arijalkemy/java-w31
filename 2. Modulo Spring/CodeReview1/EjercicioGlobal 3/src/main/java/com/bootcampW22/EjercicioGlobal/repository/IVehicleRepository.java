package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> findAll();
    boolean removeVehicle(Long id);
    boolean addVehicles(List<Vehicle> vehicles);
    List<Vehicle> findByDimensions(double minHeight, double maxHeight, double minWidth, double maxWidth);
    List<Vehicle> findByBrand(String brand);
    Vehicle findById(Long id);
    List<Vehicle> findByTransmission(String type);
    List<Vehicle> findByWeight(double minWeight, double maxWeight);
    List<Vehicle> findByBrandAndYear(String brand, int startYear, int endYear);
}
