package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

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

    public void addVehicle(VehicleDto vehicleDto){
        List<Vehicle> vehicleList = findAll();
        Vehicle vehicle = new Vehicle(vehicleDto.getId(),
                vehicleDto.getBrand(),
                vehicleDto.getModel(),
                vehicleDto.getRegistration(),
                vehicleDto.getColor(),
                vehicleDto.getYear(),
                vehicleDto.getMax_speed(),
                vehicleDto.getPassengers(),
                vehicleDto.getFuel_type(),
                vehicleDto.getTransmission(),
                vehicleDto.getHeight(),
                vehicleDto.getWidth(),
                vehicleDto.getWeight());
        vehicleList.add(vehicle);
    }

    @Override
    public List<Vehicle> findVehiclesByColorAndYear(String color, int year){
        List<Vehicle> vehicleList = findAll();
        return vehicleList.stream().filter(vehicle -> vehicle.getColor().equals(color) &&
                vehicle.getYear()==year).toList();
    }

    @Override
    public List<Vehicle> findVehiclesByBrandAndBeetweenYears(String brand, int startYear,int endYear){
        List<Vehicle> vehicleList = findAll();
        return vehicleList.stream().filter(vehicle -> vehicle.getBrand().equals(brand) &&
                vehicle.getYear()<=endYear && vehicle.getYear()>=startYear).toList();
    }

    @Override
    public Double checkAverageSpeedByBrand(String brand){
        List<Vehicle> vehicleList = findAll();
        return vehicleList.stream().filter(vehicle -> vehicle.getBrand().equals(brand)).
                mapToDouble(vehicle->Double.parseDouble(vehicle.getMax_speed())).average().orElse(0.0);
    };

    @Override
    public List<Vehicle> addVehicleList(List<VehicleDto> vehicleDtoList){
        List<Vehicle> vehicleList = findAll();
        List<Vehicle> vehicleDtoToEntity = vehicleDtoList.stream().map(vehicleDto ->
                new Vehicle(
                        vehicleDto.getId(),
                        vehicleDto.getBrand(),
                        vehicleDto.getModel(),
                        vehicleDto.getRegistration(),
                        vehicleDto.getColor(),
                        vehicleDto.getYear(),
                        vehicleDto.getMax_speed(),
                        vehicleDto.getPassengers(),
                        vehicleDto.getFuel_type(),
                        vehicleDto.getTransmission(),
                        vehicleDto.getHeight(),
                        vehicleDto.getWidth(),
                        vehicleDto.getWeight()
                )).toList();

        vehicleList.addAll(vehicleDtoToEntity);
        return vehicleList;
    };

    @Override
    public List<Vehicle> updateSpeedByVehicle(int id, VehicleDto vehicleDto){
        List<Vehicle> vehicleList = findAll();
        vehicleList.stream().filter(vehicle -> vehicle.getId()==id).forEach(
                vehicle -> vehicle.setMax_speed(vehicleDto.getMax_speed()));
        return vehicleList;
    }
}
