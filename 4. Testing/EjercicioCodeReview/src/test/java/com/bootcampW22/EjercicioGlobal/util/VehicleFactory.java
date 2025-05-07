package com.bootcampW22.EjercicioGlobal.util;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public final class VehicleFactory {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static Vehicle createVehicleToyotaBlack2005() {
        return new Vehicle(31L, "Toyota", "Camry", "126", "Black",
                2005, "250", 3, "biodiesel", "automatic",
                52.66, 137.35, 160.76);
    }
    public static Vehicle createVehicleLexusOrange2003() {
        return new Vehicle(382L,"Lexus", "LS", "03857","Orange",
                2003, "159",3, "diesel", "automatic",
                9.49, 118.21,168.54);
    }

    public static Vehicle createVehicleBuickGreen2005() {
        return new Vehicle(2L, "Buick", "LeSabre", "81962", "Green",
                2005, "240", 6, "gasoline", "semi-automatic",
                207.93, 125.94,199.22);
    }

    public static Vehicle createVehicleLexusYellow2009() {
        return new Vehicle(382L, "Lexus", "IS", "4","Yellow",
                2009, "110", 5, "biodiesel", "automatic",
                176.45, 170.04,169.23);
    }


    public static List<VehicleDto> convertListVehicleDto(List<Vehicle> vehicleList){
        return vehicleList.stream().map(vehicle ->  mapper.convertValue(vehicle, VehicleDto.class)).toList();
    }

    public static VehicleDto convertToVehicleDto(Vehicle vehicle) {
        return mapper.convertValue(vehicle, VehicleDto.class);
    }

}