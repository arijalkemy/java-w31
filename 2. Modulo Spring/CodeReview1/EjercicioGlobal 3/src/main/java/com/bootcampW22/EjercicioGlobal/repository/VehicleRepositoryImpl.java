package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepositoryImpl implements IVehicleRepository{

    private List<Vehicle> listOfVehicles = new ArrayList<>();

    public VehicleRepositoryImpl() throws IOException {
        loadDataBase();
    }
    @Override
    public List<Vehicle> findAll() {
        return listOfVehicles;
    }

    @Override
    public boolean removeVehicle(Long id) {
        return listOfVehicles.removeIf(vehicle -> vehicle.getId().equals(id));
    }

    private boolean findedId(Long id){
        return listOfVehicles.stream().anyMatch(vehicle -> vehicle.getId().equals(id));
    }

    @Override
    public boolean addVehicles(List<Vehicle> vehicles) {
        boolean vehiclesCanBeAdd = vehicles.stream().noneMatch(vehicle -> findedId(vehicle.getId()));
        if(vehiclesCanBeAdd){
            listOfVehicles.addAll(vehicles);
        }
        return vehiclesCanBeAdd;
    }

    @Override
    public List<Vehicle> findByDimensions(double minHeight, double maxHeight, double minWidth, double maxWidth) {
        return listOfVehicles.stream()
                .filter(v -> (v.getHeight() >= minHeight && v.getHeight() <= maxHeight) &&
                        (v.getWidth() >= minWidth && v.getWidth() <= maxWidth)).toList();
    }

    @Override
    public List<Vehicle> findByBrand(String brand) {
        return listOfVehicles.stream().filter(v -> v.getBrand().equals(brand)).toList();
    }

    @Override
    public Vehicle findById(Long id) {
        return listOfVehicles.stream().filter(v -> v.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Vehicle> findByTransmission(String type) {
        return listOfVehicles.stream().filter(v -> v.getTransmission().equals(type)).toList();
    }

    @Override
    public List<Vehicle> findByWeight(double minWeight, double maxWeight) {
        return listOfVehicles.stream().filter(v -> v.getWeight() >= minWeight && v.getWeight() <= maxWeight).toList();
    }

    @Override
    public List<Vehicle> findByBrandAndYear(String brand, int startYear, int endYear) {
        return listOfVehicles.stream()
                .filter(v -> v.getBrand().equals(brand) && (v.getYear() >= startYear && v.getYear() <= endYear))
                .toList();
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Vehicle> vehicles ;

        file= ResourceUtils.getFile("classpath:vehicles_100.json");
        vehicles= objectMapper.readValue(file,new TypeReference<List<Vehicle>>(){});

        listOfVehicles = vehicles;
    }
}
