package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{

    @Autowired
    IVehicleRepository repository;

    @Override
    public List<VehicleDto> searchAllVehicles() {
        List<Vehicle> vehicleList = repository.findAll();
        if(vehicleList.isEmpty())
        {
            throw new NotFoundException("No se encontro ningun auto en el sistema.");
        }

        List<VehicleDto> vehicleDtoList = new ArrayList<>();
        for(Vehicle v:vehicleList){
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
            vehicleDtoList.add(vehicleDto);
        }

        return vehicleDtoList;
    }

}
