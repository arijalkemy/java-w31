package com.bootcampW22.EjercicioGlobal.Mapper;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperImpl implements IMapper{
    @Override
    public VehicleDto vehicleToVehicleDto(Vehicle v) {
        VehicleDto vehicleDto = new VehicleDto(
                v.getId(),
                v.getBrand(),
                v.getModel(),
                v.getRegistration(),
                v.getColor(),
                v.getYear(),
                v.getMax_speed(),
                v.getPassengers(),
                v.getFuel_type(),
                v.getTransmission(),
                v.getHeight(),
                v.getWidth(),
                v.getWeight()
        );
        return vehicleDto;
    }

    @Override
    public Vehicle vehicleDtoToVehicle(VehicleDto v) {
        Vehicle vehicle = new Vehicle(
                v.getId(),
                v.getBrand(),
                v.getModel(),
                v.getRegistration(),
                v.getColor(),
                v.getYear(),
                v.getMax_speed(),
                v.getPassengers(),
                v.getFuel_type(),
                v.getTransmission(),
                v.getHeight(),
                v.getWidth(),
                v.getWeight()
        );
        return vehicle;
    }

    public List<VehicleDto> vehicleListToVehicleDtoList(List<Vehicle> v){
        List<VehicleDto> vehicleDtoList = new ArrayList<>();
        for(Vehicle v1: v){
            vehicleDtoList.add(vehicleToVehicleDto(v1));
        }
        return vehicleDtoList;
    }
    public List<Vehicle> vehicleDtoListToVehicleList(List<VehicleDto> v){
        List<Vehicle> vehicleList = new ArrayList<>();
        for(VehicleDto v1: v){
            vehicleList.add(vehicleDtoToVehicle(v1));
        }
        return vehicleList;
    }
}
