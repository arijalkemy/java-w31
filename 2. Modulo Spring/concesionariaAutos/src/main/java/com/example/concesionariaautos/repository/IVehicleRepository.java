package com.example.concesionariaautos.repository;

import com.example.concesionariaautos.model.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> findAll();
    void loadVehicle(Vehicle vehicle);
}
