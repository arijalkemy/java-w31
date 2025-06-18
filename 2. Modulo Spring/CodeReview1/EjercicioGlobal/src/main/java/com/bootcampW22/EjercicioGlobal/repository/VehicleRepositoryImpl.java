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
import java.util.Objects;

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

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Vehicle> vehicles ;

        file= ResourceUtils.getFile("classpath:vehicles_100.json");
        vehicles= objectMapper.readValue(file,new TypeReference<List<Vehicle>>(){});

        listOfVehicles = vehicles;
    }

    public void saveDataBase() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile("classpath:vehicles_100.json");
            objectMapper.writeValue(file, listOfVehicles);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Vehicle findById(Long vehicleId){
        for(Vehicle vehicle : listOfVehicles){
            if(Objects.equals(vehicle.getId(), vehicleId)){
                return vehicle;
            }
        }
        return null;
    }

    public boolean findedId(Long vehicleId){
        for(Vehicle vehicle : listOfVehicles){
            if(Objects.equals(vehicle.getId(), vehicleId)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void deleteById(Long id) {
        listOfVehicles.removeIf(v -> v.getId().equals(id));
        saveDataBase();
    }

    @Override
    public List<Vehicle> filterByTransmission(String type) {
        List<Vehicle> vehicleDtoList = listOfVehicles.stream().filter(v -> v.getTransmission().equals(type))
                .toList();
        return vehicleDtoList;
    }

    @Override
    public List<Vehicle> filterByFuelType(String type) {
        List<Vehicle> vehicleByFuel = listOfVehicles.stream()
                .filter(v -> v.getFuel_type().equals(type)).toList();
        return vehicleByFuel;
    }

    @Override
    public boolean loadVehicle(Vehicle vehicle) {
        if (!findedId(vehicle.getId())) {
            listOfVehicles.add(vehicle);
            saveDataBase();
            return true;
        }
        return false;
    }

    @Override
    public List<Vehicle> filterByBrand(String brand) {
        return listOfVehicles.stream().filter(v -> v.getBrand().equals(brand)).toList();
    }

    @Override
    public List<Vehicle> filterByBrandAndYear(String brand, int startYear, int endYear) {
        return  listOfVehicles.stream()
                .filter(v -> v.getBrand().equals(brand) && v.getYear() >= startYear && v.getYear() <= endYear)
                .toList();
    }

    @Override
    public List<Vehicle> filterByColorAndYear(String color, int year) {
        return listOfVehicles.stream()
                .filter(v -> v.getColor().equals(color) && v.getYear() == year)
                .toList();
    }

    @Override
    public List<Vehicle> filterByDimensions(double min_height, double max_height, double min_width, double max_width) {
        return listOfVehicles.stream().filter(v -> v.getHeight() >= min_height && v.getHeight() <= max_height
                                        && v.getWidth() >= min_width && v.getWidth() <= max_width).toList();
    }

    @Override
    public List<Vehicle> findByWeight(double weightMin, double weightMax) {
        return listOfVehicles.stream()
                .filter(v -> v.getWeight() >= weightMin && v.getWeight() <= weightMax).toList();
    }
}
