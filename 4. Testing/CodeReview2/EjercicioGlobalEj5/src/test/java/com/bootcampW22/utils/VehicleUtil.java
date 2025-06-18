package com.bootcampW22.EjercicioGlobal.utils;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class VehicleUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static VehicleDto entitytoDto(Vehicle vehicle){
        return objectMapper.convertValue(vehicle,VehicleDto.class);
    }

    public static List<Vehicle> vehicleListColorAndYear(String color, Integer year) {
        String jsonData = "";
        String filePath = "target/classes/vehicles_100.json";

        try {
            jsonData = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Vehicle> allVehicles = parseJsonData(jsonData);
        return allVehicles.stream()
                .filter(v -> v.getColor().equals(color) && v.getYear() == year)
                .toList();
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
        return allVehicles.stream()
                .filter(v -> v.getBrand().equals(brand) && v.getYear() <= startYear && v.getYear() >= endYear)
                .toList();
    }

    public static List<Vehicle> vehicleListByBrand(String brand) {
        String jsonData = "";
        String filePath = "target/classes/vehicles_100.json";

        try {
            jsonData = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Vehicle> allVehicles = parseJsonData(jsonData);

        return allVehicles.stream().filter(v -> v.getBrand().equals(brand))
                .toList();
    }

    public static List<Vehicle> vehicleListByRangeOfWeight(Double minWeight, Double maxWeight) {
        String jsonData = "";
        String filePath = "target/classes/vehicles_100.json";

        try {
            jsonData = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Vehicle> allVehicles = parseJsonData(jsonData);

        return allVehicles.stream()
                .filter(v -> v.getWeight() >= minWeight && v.getWeight() <= maxWeight)
                .toList();
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