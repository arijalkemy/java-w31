package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> findAll();
    void addVehicle(Vehicle vehicle);
    List<Vehicle> getVehiclesByColorAndYear(String color, int year);
    List<Vehicle> getVehiclesByBrandAndYearRange(String brand, int startYear, int endYear);
    Double getAvgSpeedByBrand(String brand);
    void addVehicles(List<Vehicle> vehicles);
    boolean updateSpeed(Long id, String newSpeed);
    List<Vehicle> getVehiclesByFuelType(String type);
    boolean deleteVehicle(Long id);
    List<Vehicle> getVehiclesByTransmissionType(String transmission);
    Double getAvgCapacityByBrand(String brand);
    boolean updateFuel(Long id, String newFuel);
    List<Vehicle> getByDimensionsRange(double minLength, double maxLength, double minWidth, double maxWidth);
    List<Vehicle> getByWeightRange(double min, double max);
}
