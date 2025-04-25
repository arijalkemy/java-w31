package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    public List<Vehicle> findAll();
    public Vehicle findById(long id);
    public void save(Vehicle vehicle);
    public void delete(Vehicle vehicle);
}
