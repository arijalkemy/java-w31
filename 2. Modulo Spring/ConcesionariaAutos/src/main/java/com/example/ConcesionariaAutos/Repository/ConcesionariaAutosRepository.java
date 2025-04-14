package com.example.ConcesionariaAutos.Repository;

import java.time.LocalDate;
import java.util.List;

import com.example.ConcesionariaAutos.Entities.Vehicle;

public interface ConcesionariaAutosRepository {
    public void newVehicle(Vehicle vehicle);

    public Boolean doesVehicleExists(Vehicle vehicle);

    public List<Vehicle> getAllVehicles();

    public List<Vehicle> getVehiclesByManufacturingDate(LocalDate startLocalDate, LocalDate endLocalDate);

    public List<Vehicle> getVehiclesByPriceRange(Double startPriceDouble, Double endPriceDouble);

    public Vehicle getVehicleById(Integer id);
}
