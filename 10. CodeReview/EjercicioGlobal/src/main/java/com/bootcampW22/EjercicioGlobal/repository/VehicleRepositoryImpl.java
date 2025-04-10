package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.dto.ExceptionDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.utils.MapperPersonal;
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

    public void addVehicle(Vehicle vehicle){
        List<Vehicle> vehicleList = findAll();
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
    public double[] checkAverageSpeedByBrand(String brand){
        List<Vehicle> vehicleList = findAll();
        return vehicleList.stream().filter(vehicle -> vehicle.getBrand().equals(brand)).
                mapToDouble(vehicle->Double.parseDouble(vehicle.getMax_speed())).toArray();
    };

    @Override
    public List<Vehicle> addVehicleList(List<Vehicle> vehicleListRequest){
        List<Vehicle> vehicleList = findAll();
        vehicleList.addAll(vehicleListRequest);
        return vehicleList;
    };

    @Override
    public List<Vehicle> updateSpeedByVehicle(int id, Vehicle vehicleRequest){
        List<Vehicle> vehicleList = findAll();
        vehicleList.stream().filter(vehicle -> vehicle.getId()==id).forEach(
                vehicle -> vehicle.setMax_speed(vehicleRequest.getMax_speed()));
        return vehicleList;
    }

    @Override
    public List<Vehicle> findAllByFuelType(String fuelType){
        List<Vehicle> vehicleList= findAll();
        return vehicleList.stream().filter(vehicle -> vehicle.getFuel_type().equals(fuelType)).toList();
    }

    @Override
    public void deleteVehicle(int id){
        List<Vehicle> vehicleList = findAll();
        vehicleList.removeAll(vehicleList.stream().filter(vehicle -> vehicle.getId()==id).toList());
    }

    @Override
    public List<Vehicle> findAllByTransmissionType(String transmissionType){
        List<Vehicle> vehicleList = findAll();
        return vehicleList.stream().filter(vehicle -> vehicle.getTransmission().equals(transmissionType)).toList();
    }

    @Override
    public void updateFuelTypeByVehicle(int id, Vehicle vehicle){
        List<Vehicle> vehicleList = findAll();
        vehicleList.stream().filter(veh -> veh.getId()==id).
                forEach(veh -> veh.setFuel_type(vehicle.getFuel_type()));
    }

    @Override
    public Double getAverageCapacityPeoplePerBrand(String brand){
       List<Vehicle> vehicleList = findAll();
       return vehicleList.stream().filter(vehicle -> vehicle.getBrand().equals(brand)).
               mapToDouble(Vehicle::getPassengers).average().orElse(0.);

    }

    @Override
    public List<Vehicle> findVehiclesPerWidthAndLengthRange(Double min_length, Double max_length,
                                            Double min_width, Double max_width){
       List<Vehicle> vehicleList = findAll();

       return vehicleList.stream().filter(vehicle -> vehicle.getWidth()<= max_width &&
               vehicle.getWidth()>= min_width && vehicle.getHeight()<= max_length &&
               vehicle.getHeight()>= min_length).toList();
    }

    @Override
    public List<Vehicle> findVehiclesPerWeightRange(Double weightMin, Double weightMax){
        List<Vehicle> vehicleList = findAll();
        return vehicleList.stream().filter(vehicle -> vehicle.getWeight()>=weightMin &&
                vehicle.getWeight()<=weightMax).toList();
    }
}
