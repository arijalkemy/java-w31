package com.bootcampW22.EjercicioGlobal.repository;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> findAll();
    void addVehicle(Vehicle vehicle);
    List<Vehicle> findVehiclesByColorAndYear(String color, int year);
    List<Vehicle> findVehiclesByBrandAndBeetweenYears(String brand, int startYear,int endYear);
    double[] checkAverageSpeedByBrand(String brand);
    List<Vehicle> addVehicleList(List<Vehicle> vehicleList);
    List<Vehicle> updateSpeedByVehicle(int id, Vehicle vehicle);
    List<Vehicle> findAllByFuelType(String fuelType);
    void deleteVehicle(int id);
    List<Vehicle> findAllByTransmissionType(String transmissionType);
    void updateFuelTypeByVehicle(int id, Vehicle vehicle);
    Double getAverageCapacityPeoplePerBrand(String brand);
    List<Vehicle> findVehiclesPerWidthAndLengthRange(Double min_length, Double max_length,
                                           Double min_width, Double max_width);
    List<Vehicle> findVehiclesPerWeightRange(Double weightMin, Double weightMax);

}
