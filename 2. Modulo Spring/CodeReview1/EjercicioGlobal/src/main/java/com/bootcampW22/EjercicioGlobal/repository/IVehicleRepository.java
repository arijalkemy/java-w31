package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> findAll();
    void saveDataBase();
    Vehicle findById(Long vehicleId);
    boolean findedId(Long vehicleId);
    void deleteById(Long id);
    List<Vehicle> filterByTransmission(String type);
    List<Vehicle> filterByFuelType(String type);
    boolean loadVehicle(Vehicle vehicle);
    List<Vehicle> filterByBrand(String brand);
    List<Vehicle> filterByBrandAndYear(String brand, int startYear, int endYear);
    List<Vehicle> filterByColorAndYear(String color, int year);
    List<Vehicle> filterByDimensions(double min_lenght, double max_lenght, double min_width, double max_width);
    List<Vehicle> findByWeight(double weightMin, double weightMax);
}
