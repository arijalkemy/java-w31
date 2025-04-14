package com.example.ConcesionariaAutos.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.ConcesionariaAutos.Entities.Vehicle;

@Repository
public class ConcesionariaAutosRepositoryImpl implements ConcesionariaAutosRepository {

    private List<Vehicle> vehicles;

    public ConcesionariaAutosRepositoryImpl() {
        this.vehicles = new ArrayList<>();
    }

    @Override
    public void newVehicle(Vehicle vehicle) {
        Vehicle newVehicle = new Vehicle(
                vehicle.getBrand(),
                vehicle.getModel(),
                vehicle.getManufacturingDate(),
                vehicle.getNumberOfKilometers(),
                vehicle.getDoors(),
                vehicle.getPrice(),
                vehicle.getCurrency(),
                vehicle.getServices(),
                vehicle.getCountOfOwners());
        vehicles.add(newVehicle);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicles;
    }

    @Override
    public List<Vehicle> getVehiclesByManufacturingDate(LocalDate startLocalDate, LocalDate endLocalDate) {
        return vehicles.stream()
                .filter(v -> v.getManufacturingDate().isAfter(startLocalDate)
                        && v.getManufacturingDate().isBefore(endLocalDate))
                .toList();
    }

    @Override
    public List<Vehicle> getVehiclesByPriceRange(Double startPriceDouble, Double endPriceDouble) {
        return vehicles.stream()
                .filter(v -> v.getPrice() >= startPriceDouble && v.getPrice() <= endPriceDouble)
                .toList();
    }

    @Override
    public Vehicle getVehicleById(Integer id) {
        return vehicles.stream()
                .filter(v -> v.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Boolean doesVehicleExists(Vehicle vehicle) {
        for (Vehicle v : vehicles) {
            if (v.getId().equals(vehicle.getId())) {
                return true;
            }
        }
        return false;
    }
}
