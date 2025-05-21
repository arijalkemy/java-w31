package com.bootcampW22.EjercicioGlobal.utils;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;
import java.util.stream.Collectors;

public class Mapper {

    public static List<VehicleDto> listToListDto(List<Vehicle> expectedList){

        return expectedList.stream().map(a-> new VehicleDto(a.getId(),a.getBrand(),a.getModel(),
                a.getRegistration(),a.getColor(),a.getYear(),a.getMax_speed(),a.getPassengers(),
                a.getFuel_type(),a.getTransmission(),a.getHeight(),a.getWidth(),a.getWeight())).collect(Collectors.toList());
    }
}
