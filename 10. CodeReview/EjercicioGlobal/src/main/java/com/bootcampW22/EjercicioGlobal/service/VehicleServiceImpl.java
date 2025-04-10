package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{

    IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }
    @Override
    public List<VehicleDto> searchAllVehicles() {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v,VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void addVehicle(VehicleDto vehicleDto) {
        vehicleRepository.addVehicle(vehicleDto);
    }

    @Override
    public List<VehicleDto> findVehiclesByColorAndYear(String color, int year){
        List<Vehicle> vehicleList = vehicleRepository.findVehiclesByColorAndYear(color,year);
        return vehicleList.stream().map(vehicle -> new VehicleDto(
                vehicle.getId(),
                vehicle.getBrand(),
                vehicle.getModel(),
                vehicle.getRegistration(),
                vehicle.getColor(),
                vehicle.getYear(),
                vehicle.getMax_speed(),
                vehicle.getPassengers(),
                vehicle.getFuel_type(),
                vehicle.getTransmission(),
                vehicle.getHeight(),
                vehicle.getWidth(),
                vehicle.getWeight()
        )).toList();
    }

    @Override
    public List<VehicleDto> findVehiclesByBrandAndBeetweenYears(String brand, int startYear,int endYear){
        List<Vehicle> vehicleList = vehicleRepository.findVehiclesByBrandAndBeetweenYears(brand,startYear,endYear);
        return vehicleList.stream().map(vehicle -> new VehicleDto(
                vehicle.getId(),
                vehicle.getBrand(),
                vehicle.getModel(),
                vehicle.getRegistration(),
                vehicle.getColor(),
                vehicle.getYear(),
                vehicle.getMax_speed(),
                vehicle.getPassengers(),
                vehicle.getFuel_type(),
                vehicle.getTransmission(),
                vehicle.getHeight(),
                vehicle.getWidth(),
                vehicle.getWeight()
        )).toList();
    }

    @Override
    public Double checkAverageSpeedByBrand(String brand){
       return vehicleRepository.checkAverageSpeedByBrand(brand);
    }

    @Override
    public List<VehicleDto> addVehicleList(List<VehicleDto> vehicleDtoList){
        List<Vehicle> vehicleDtoFinalList= vehicleRepository.addVehicleList(vehicleDtoList);
        return vehicleDtoFinalList.stream().map(vehicleDto -> new VehicleDto(
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
    }

    @Override
    public List<VehicleDto> updateSpeedByVehicle(int id, VehicleDto vehicleDto){
        List<Vehicle> vehicleList = vehicleRepository.updateSpeedByVehicle(id,vehicleDto);
        return vehicleList.stream().map(vehicle -> new VehicleDto(
                vehicle.getId(),
                vehicle.getBrand(),
                vehicle.getModel(),
                vehicle.getRegistration(),
                vehicle.getColor(),
                vehicle.getYear(),
                vehicle.getMax_speed(),
                vehicle.getPassengers(),
                vehicle.getFuel_type(),
                vehicle.getTransmission(),
                vehicle.getHeight(),
                vehicle.getWidth(),
                vehicle.getWeight()
        )).toList();
    }

}
