package com.bootcampW22.EjercicioGlobal.util;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

public class TestVehicleGenerator {

    private static String SCOPE;
    private static ObjectWriter mapper;

    public static void emptyVehiclesFile() {
        Properties properties = new Properties();

        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            SCOPE = properties.getProperty("api.scope");
        } catch (IOException e) {
            e.printStackTrace();
        }

        PrintWriter writer = null;

        try {
            writer = new PrintWriter(ResourceUtils.getFile("./src/" + SCOPE + "/resources/vehicles_100.json"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        writer.print("[]");
        writer.close();
    }

    public static VehicleDto getVehicle(String brand, int year, String color, String gasoline, String maxSpeed, int passengers, double weight) {
        VehicleDto vehicle = new VehicleDto();
        vehicle.setId(999L);
        vehicle.setBrand(brand);
        vehicle.setModel("Fiero");
        vehicle.setRegistration("9999");
        vehicle.setYear(year);
        vehicle.setColor(color);
        vehicle.setMax_speed(maxSpeed);
        vehicle.setFuel_type(gasoline);
        vehicle.setTransmission("semi-automatic");
        vehicle.setPassengers(passengers);
        vehicle.setHeight(105.43);
        vehicle.setWidth(280.28);
        vehicle.setWeight(weight);

        return vehicle;
    }

    public static VehicleDto getVehicleById(Long id, String registration) {
        VehicleDto vehicle = new VehicleDto();
        vehicle.setId(id);
        vehicle.setBrand("Porche");
        vehicle.setModel("Fiero");
        vehicle.setRegistration(registration);
        vehicle.setYear(1986);
        vehicle.setColor("Mauv");
        vehicle.setMax_speed("85");
        vehicle.setFuel_type("gasoline");
        vehicle.setTransmission("semi-automatic");
        vehicle.setPassengers(2);
        vehicle.setHeight(105.43);
        vehicle.setWidth(280.28);
        vehicle.setWeight(288.8);

        return vehicle;
    }

    public static void appendNewVehicle(VehicleDto vehicle) {
        mapper = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        PrintWriter writer = null;

        try {
            String content = Files.readString(new File("./src/" + SCOPE + "/resources/vehicles_100.json")
                    .getAbsoluteFile().toPath(), StandardCharsets.US_ASCII);
            writer = new PrintWriter(ResourceUtils.getFile("./src/" + SCOPE + "/resources/vehicles_100.json"));

            try {
                String studentAsString = mapper.writeValueAsString(vehicle);
                writer.print(content.substring(0, content.length()-1));
                if (content.length()>2) writer.print(", ");
                writer.print(studentAsString);
                writer.print("]");
            } catch (JsonProcessingException jsonProcessingException) {
                jsonProcessingException.printStackTrace();
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        writer.close();
    }

    public static List<VehicleDto> getVehicleSet() {
        VehicleDto veh1 =
                getVehicle("Pontiac", 1986, "Mauv", "gasoline", "85", 4, 280);
        VehicleDto veh2 =
                getVehicle("Chevrolet", 1999, "Green", "gas", "100",2, 172.9);
        VehicleDto veh3 =
                getVehicle("Honda", 2005, "Grey", "gasoline", "94",3, 234.80);
        VehicleDto veh4 =
                getVehicle("Ford", 1986, "Mauv", "organic", "200", 4, 120);
        VehicleDto veh5 =
                getVehicle("Ford", 1986, "Mauv", "gas", "70",3, 156.4);
        VehicleDto veh6 =
                getVehicle("Porche", 1986, "Mauv", "gas", "55",2, 210);
        VehicleDto veh7 =
                getVehicle("Pontiac", 1990, "Green", "gasoline", "100",1, 140);
        VehicleDto veh8 =
                getVehicle("Chevrolet", 1999, "Green", "gas", "67",3, 314.3);

        return new ArrayList<>() {{
            add(veh1);
            add(veh2);
            add(veh3);
            add(veh4);
            add(veh5);
            add(veh6);
            add(veh7);
            add(veh8);
        }};
    }

    public static List<VehicleDto> getVehicleWithIdSet() {
        VehicleDto veh1 = getVehicleById(1L, "1L");
        VehicleDto veh2 = getVehicleById(2L, "2L");
        VehicleDto veh3 = getVehicleById(3L, "3L");
        VehicleDto veh4 = getVehicleById(4L, "4L");
        VehicleDto veh5 = getVehicleById(5L, "5L");


        return new ArrayList<>() {{
            add(veh1);
            add(veh2);
            add(veh3);
            add(veh4);
            add(veh5);
        }};
    }

    public static List<Vehicle> mapVehicleList() {
        ObjectMapper oMapper = new ObjectMapper();
        return getVehicleSet().stream().map(v -> oMapper.convertValue(v, Vehicle.class)).collect(Collectors.toList());
    }

    public static List<Vehicle> listByBrand(String brand) {
        ObjectMapper oMapper = new ObjectMapper();
        List<VehicleDto> listFiltered = getVehicleSet().stream().filter(v -> v.getBrand().equals(brand))
                .toList();
        return listFiltered.stream().map(v -> oMapper.convertValue(v, Vehicle.class)).collect(Collectors
                .toList());
    }

    public static List<Vehicle> getVehiclesByRangeWeight(double min, double max) {
        return mapVehicleList().stream()
                .filter(vehicle -> vehicle.getWeight()>= min && vehicle.getWeight()<= max)
                .toList();
    }

    public static List<VehicleDto> getVehiclesDTOByRangeWeight(double min, double max) {
        return getVehicleSet().stream()
                .filter(vehicle -> vehicle.getWeight()>= min && vehicle.getWeight()<= max)
                .toList();
    }

    public static List<Vehicle> getVehiclesByRangeOfYearAndBrand(int startYear, int endYear, String brand){
        return mapVehicleList().stream().filter(v ->
                v.getYear() >= startYear && v.getYear() <= endYear && v.getBrand().equals(brand)).toList();
    }

    public static List<VehicleDto> getVehiclesDTOByRangeOfYearAndBrand(int startYear, int endYear, String brand) {
        return getVehicleSet().stream().filter(v ->
                v.getYear() >= startYear && v.getYear() <= endYear && v.getBrand().equals(brand)).toList();
    }

    public static List<Vehicle> getVehicleListByColorAndYear(String color, int year) {
        return TestVehicleGenerator.mapVehicleList().stream()
                .filter(v -> v.getYear() == year && v.getColor().equals(color)).toList();
    }

    public static List<VehicleDto> getVehicleDtoListByColorAndYear(String color, int year) {
        return TestVehicleGenerator.getVehicleSet().stream()
                .filter(v -> v.getYear() == year && v.getColor().equals(color)).toList();
    }
}
