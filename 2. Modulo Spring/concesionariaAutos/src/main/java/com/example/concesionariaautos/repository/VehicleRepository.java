package com.example.concesionariaautos.repository;

import com.example.concesionariaautos.model.Vehicle;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class VehicleRepository  implements  IVehicleRepository{
    List<Vehicle> vehicleList = new ArrayList<>();
    private Integer currentId = 1;

    public VehicleRepository() {
        loadVehicles();
    }

    private void loadVehicles(){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile("classpath:vehiculos.json");
            List<Vehicle> vehicles = objectMapper.readValue(file, new TypeReference<List<Vehicle>>() {});
            for (Vehicle vehicle : vehicles) {
                vehicle.setId(currentId.toString());
                currentId++;
            }
            vehicleList = vehicles;
        } catch (IOException e) {
            System.err.println("Error al cargar el archivo de la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicleList;
    }

    @Override
    public void loadVehicle(Vehicle vehicle) {
        vehicle.setId(currentId.toString());
        vehicleList.add(vehicle);
        currentId++;
    }
}
