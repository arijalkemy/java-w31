package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;
import java.util.OptionalDouble;

public interface IVehicleRepository {
    List<Vehicle> findAll();
    boolean deleteVehicle(Long id);
    public void addVehicle(Vehicle vehicle);
    void addVehicles(List<Vehicle> vehicles);
    void updateSpeed(Long id, String newSpeed);
    void updateFuel(Long id, String newFuel);
    List<Vehicle> getByColorAndYear(String color, int year);
    List<Vehicle> getByFuelType(String fuelType);
    List<Vehicle> getByTransmission(String transmission);
    List<Vehicle> getByDimensions(double minLength, double maxLength, double minWidth, double maxWidth);
    List<Vehicle> getByWeight(double minWeight, double maxWeight);
    List<Vehicle> getByBrandAndYears(String brand, int startYear, int endYear);
    OptionalDouble getAvgSpeedByBrand(String brand);
    OptionalDouble getAvgCapacityByBrand(String brand);
}

