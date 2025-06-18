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


    private boolean findedId(Long id){
        for (Vehicle vehicle : listOfVehicles){
            if(vehicle.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean loadVehicle(Vehicle vehicle) {
        if(findedId(vehicle.getId())){
            return false;
        }
        listOfVehicles.add(vehicle);
        return true;
    }

    @Override
    public List<Vehicle> findByBrand(String brand) {
        return listOfVehicles.stream().filter(v -> v.getBrand().equals(brand)).toList();
    }

    @Override
    public List<Vehicle> findByDimensions(double minHeight, double maxHeight, double minWidth, double maxWidth) {
        return listOfVehicles.stream()
                .filter(v -> (v.getHeight() >= minHeight && v.getHeight() <= maxHeight
                        && v.getWidth() >= minWidth && v.getWidth() <= maxWidth)
                ).toList();
    }

    @Override
    public boolean removeVehicle(Long id) {
        return listOfVehicles.removeIf(v -> v.getId().equals(id));
    }

    @Override
    public Vehicle findById(Long id) {
        return listOfVehicles.stream().filter(v -> v.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Vehicle> findByBrandAndYear(String color, int year) {
        return listOfVehicles.stream().filter(v -> v.getYear() == year && v.getColor().equals(color)).toList();
    }

    @Override
    public List<Vehicle> findByFuelType(String fuelType) {
       return listOfVehicles.stream().filter(v -> v.getFuel_type().equals(fuelType)).toList();
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
