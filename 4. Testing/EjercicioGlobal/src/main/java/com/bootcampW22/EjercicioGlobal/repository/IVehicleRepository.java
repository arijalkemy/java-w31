package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> findAll();
    public Long addNewVehicle(Vehicle vehicle);
    public List<Vehicle> findByColorYear(String color, int year);
    public List<Vehicle> findByBrandYear(String brand, int start_year, int end_year);
    public Double averageSpeed(String brand);
    public String addAllVehicles(List<Vehicle> vehicleList);
    public Boolean editSpeed(Long id);
    public List<Vehicle> fuelList(String type);
    public Boolean deleteVehicle(Long id);
    public List<Vehicle> findByTransmission(String type);
    public List<Vehicle> findByDimension(Double minLength, Double maxLength, Double minWidth, Double maxWidth);
}
