package com.mercadolibre.concesionariaauto.repository;

import com.mercadolibre.concesionariaauto.model.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepository {
    private List<Vehicle> vehicles;

    public VehicleRepository(){
        this.vehicles = new ArrayList<>();
    }

    public void saveVehicle(Vehicle vehicle){
        this.vehicles.add(vehicle);
    }

    public List<Vehicle> findAll() {
        return vehicles;
    }
}
