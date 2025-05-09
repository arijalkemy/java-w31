package com.bootcampW22.EjercicioGlobal.utils;

import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgCapacityByBrandDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgSpeedByBrandDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public final class TestDataFactory {

    private static final ObjectMapper mapper = new ObjectMapper();
    private static final ObjectWriter writer = mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

    private static String readJsonFromResource(String path) throws IOException {
        ClassPathResource resource = new ClassPathResource(path);
        try (Reader reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8)) {
            return FileCopyUtils.copyToString(reader);
        }
    }

    //PARA RESPUESTAS EXITOSAS

    //Punto 1
    //Data: "yellow, 1984"
    public static String getVehiclesByYearAndColor() throws JsonProcessingException {
        VehicleDto vehicle = new VehicleDto(
                433L, "Saab", "900", "0932", "Yellow", 1984,
                "119", 5, "gas", "automatic", 76.36, 129.09, 196.19
        );

        return writer.writeValueAsString(Collections.singletonList(vehicle));
    }

    //Punto 2
    //Data: "renault, 1910, 2010"
    public static String getVehiclesByBrandAndYear() throws JsonProcessingException {
        VehicleDto vehicle = new VehicleDto(
                117L, "Renault", "Alliance", "9473", "Blue", 1983,
                "167", 5, "diesel", "semi-automatic", 299.47, 116.08, 199.94
        );
        return writer.writeValueAsString(Collections.singletonList(vehicle));
    }

    //Punto 3
    //Data: "chevrolet"
    public static String getAverageSpeedByBrand() throws JsonProcessingException {
        VehicleAvgSpeedByBrandDto averageSpeedVehicle = new VehicleAvgSpeedByBrandDto(156.7);
        return writer.writeValueAsString((averageSpeedVehicle));
    }

    //Punto 4
    //Data: "Renault"
    public static String getAverageCapacityByBrand() throws JsonProcessingException {
        VehicleAvgCapacityByBrandDto VehicleAvgCapacity = new VehicleAvgCapacityByBrandDto(5.0);
        return writer.writeValueAsString((VehicleAvgCapacity));
    }

    //Punto 5
    //Data: "200, 201"
    public static String getVehiclesByRangeOfCapacity() throws JsonProcessingException {
        VehicleDto vehicle = new VehicleDto(
                79L, "Hyundai", "Azera", "94730", "Blue", 2007,
                "160", 5, "diesel", "manual", 71.42, 240.91, 200.43
        );
        
        //List<VehicleDto> vehicles = new ArrayList<>(Arrays.asList(vehicle, vehicle2));
        return writer.writeValueAsString(Collections.singletonList(vehicle));
    }

    //PARA LAS EXCEPCIONES

    //Para punto 1 y 2
    public static String getVehicleNotFoundJson() throws IOException {
        return readJsonFromResource("jsons/vehicle_not_found.json");
    }

    //Para punto 3 y 4
    public static String getVehicleNotFoundByBrandJson() throws IOException {
        return readJsonFromResource("jsons/vehicle_not_found_by_brand.json");
    }

    //Para punto 5
    public static String getVehicleNotFoundByWeightJson() throws IOException {
        return readJsonFromResource("jsons/vehicle_not_found_by_weight.json");
    }
}