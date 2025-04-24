package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public interface IVehicleRepository {
    List<Vehicle> findAll();
    void deleteVehicle(Vehicle vehicle);
    void addVehicle(Vehicle vehicle);
    void addVehicles(List<Vehicle> vehicles);
    void updateSpeed(Vehicle vehicle, String newSpeed);
    void updateFuel(Vehicle vehicle, String newFuel);
    List<Vehicle> getByColorAndYear(String color, int year);
    List<Vehicle> getByFuelType(String fuelType);
    List<Vehicle> getByTransmission(String transmission);
    List<Vehicle> getByDimensions(double minLength, double maxLength, double minWidth, double maxWidth);
    List<Vehicle> getByWeight(double minWeight, double maxWeight);
    List<Vehicle> getByBrandAndYears(String brand, int startYear, int endYear);
    List<Vehicle> getByBrand(String brand);
    Optional<Vehicle> getVehicleById(Long id);
}

