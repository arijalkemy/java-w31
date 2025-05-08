package com.bootcampW22.EjercicioGlobal.utils;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class VehicleFactory {

    private static final ObjectMapper mapper = new ObjectMapper();
    public static Vehicle vehicle1 = new Vehicle(2L, "Buick", "LeSabre", "81962", "Green", 2005, "240", 6, "gasoline", "semi-automatic", 207.93, 125.94,199.22);
    public static Vehicle vehicle2 = new Vehicle(5L, "Lexus", "LS", "03857","Orange", 2003, "159",3, "diesel", "automatic", 9.49, 118.21,168.54);
    public static Vehicle vehicle3 = new Vehicle(31L, "Toyota", "Camry", "126", "Crimson", 2000, "250", 3, "biodiesel", "automatic", 52.66, 137.35, 160.76);
    public static Vehicle vehicle4 = new Vehicle(382L, "Lexus", "IS", "4","Yellow", 2009, "110", 5, "biodiesel", "automatic", 176.45, 170.04,169.23);

    public static VehicleDto convertToVehicleDto(Vehicle vehicle) {
        return mapper.convertValue(vehicle, VehicleDto.class);
    }
}
