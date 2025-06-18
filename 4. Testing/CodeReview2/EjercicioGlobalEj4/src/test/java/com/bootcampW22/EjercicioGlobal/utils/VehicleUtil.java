package com.bootcampW22.EjercicioGlobal.utils;

import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgCapacityByBrandDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgSpeedByBrandDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class VehicleUtil {

    public static ObjectWriter writer(){
        return new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE,false).
                writer().withDefaultPrettyPrinter();
    }

    public static List<Vehicle> vehicleListColorAndYear(String color, Integer year) {
        List<Vehicle> vehicles = new ArrayList<>();
        String jsonData = "";
        String filePath = "target/classes/vehicles_100.json";

        try {
            jsonData = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Vehicle> allVehicles = parseJsonData(jsonData);

        for (Vehicle vehicle : allVehicles) {
            if (color.equalsIgnoreCase(vehicle.getColor()) && year.equals(vehicle.getYear())) {
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    public static List<Vehicle> vehicleListBranAndRangeOfYear(String brand, Integer startYear, Integer endYear) {
        String filePath = "target/classes/vehicles_100.json";
        List<Vehicle> allVehicles;

        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(filePath)));

            allVehicles = parseJsonData(jsonData);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
        List<Vehicle> filteredVehicles = new ArrayList<>();
        for (Vehicle vehicle : allVehicles) {
            if (brand.equalsIgnoreCase(vehicle.getBrand()) &&
                    vehicle.getYear() >= startYear &&
                    vehicle.getYear() <= endYear) {
                filteredVehicles.add(vehicle);
            }
        }

        return filteredVehicles;
    }

    public static List<Vehicle> vehicleListByBrand(String brand) {
        List<Vehicle> vehicles = new ArrayList<>();
        String jsonData = "";
        String filePath = "target/classes/vehicles_100.json";

        try {
            jsonData = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Vehicle> allVehicles = parseJsonData(jsonData);

        for (Vehicle vehicle : allVehicles) {
            if (brand.equals(vehicle.getBrand())) {
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    private static List<Vehicle> parseJsonData(String jsonData) {
        List<Vehicle> vehicles = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            vehicles = objectMapper.readValue(jsonData, new TypeReference<List<Vehicle>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }

        return vehicles;
    }


}