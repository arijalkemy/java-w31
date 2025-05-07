package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgCapacityByBrandDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgSpeedByBrandDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.util.JsonUtils;
import com.bootcampW22.EjercicioGlobal.util.VehicleFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class VehicleControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private IVehicleRepository vehicleRepository;

    private Vehicle vehicle1;
    private Vehicle vehicle2;
    private Vehicle vehicle3;
    private Vehicle vehicle4;

    @BeforeEach
    void setUp(){
        vehicle1 = VehicleFactory.createVehicleToyotaBlack2005();
        vehicle2 = VehicleFactory.createVehicleLexusYellow2009();
        vehicle3 = VehicleFactory.createVehicleLexusOrange2003();
        vehicle4 = VehicleFactory.createVehicleBuickGreen2005();

        vehicleRepository.clearAll();
        vehicleRepository.save(vehicle1);
        vehicleRepository.save(vehicle2);
        vehicleRepository.save(vehicle3);
        vehicleRepository.save(vehicle4);
    }

    @Test
    @DisplayName("[SUCCESS] Integration test: Get vehicle by color and year")
    void testFindByColorAndYearSuccess() throws Exception {
        //Arrange
        String path = "/vehicles/color/{color}/year/{year}";

        String expected = JsonUtils.generateFromObject(List.of(vehicle1));

        //Act & Assert
        mockMvc.perform(get(path, "black", 2005))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(content().json(expected));

    }

    @Test
    @DisplayName("[ERROR] Integration test: Get vehicle by color and year - Not found")
    void testFindByColorAndYearNotFound() throws Exception {
        String path = "/vehicles/color/{color}/year/{year}";

        mockMvc.perform(get(path, "green", 2003))
                .andExpect(status().isNotFound())
                .andExpect(result ->
                        assertEquals(
                                "No se encontraron vehículos con esos criterios.",
                                Objects.requireNonNull(result.getResolvedException()).getMessage()
                        ));
    }

    //Punto 2
    @Test
    @DisplayName("[SUCCESS] Find by brand and year")
    void testFindByBrandAndYearSuccess() throws Exception {
        String path = "/vehicles/brand/{brand}/between/{start_year}/{end_year}";

        String expected = JsonUtils.generateFromObject(List.of(vehicle2, vehicle3));

        mockMvc.perform(get(path, "Lexus", 2000, 2010))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].id").value(vehicle2.getId()))
                .andExpect(jsonPath("$[1].id").value(vehicle3.getId()))
                .andExpect(content().json(expected));
    }

    @Test
    @DisplayName("[ERROR] Find by brand and year - Not found")
    void testFindByBrandAndYearNotFound() throws Exception {
        String path = "/vehicles/brand/{brand}/between/{start_year}/{end_year}";

        mockMvc.perform(get(path, "Orange", 2000, 2001))
                .andExpect(status().isNotFound())
                .andExpect(result ->
                        assertEquals(
                                "No se encontraron vehículos con esos criterios.",
                                Objects.requireNonNull(result.getResolvedException().getMessage())
                        ));
    }

    //Punto 3
    @Test
    @DisplayName("[SUCCESS] Calculate average speed by brand")
    void testCalculateAvgSpeedByBrandSuccess() throws Exception {
        String path = "/vehicles/average_speed/brand/{brand}";

        Double maxSpeed1 = Double.valueOf(vehicle2.getMax_speed());
        Double maxSpeed2 = Double.valueOf(vehicle3.getMax_speed());
        Double average = (maxSpeed1 + maxSpeed2) /2;

        VehicleAvgSpeedByBrandDto objectRes = new VehicleAvgSpeedByBrandDto(average);

        String expected = JsonUtils.generateFromObject(objectRes);

        mockMvc.perform(
                get(path, "Lexus"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$.average").value(average))
                .andExpect(content().json(expected));
    }

    @Test
    @DisplayName("[ERROR] Calculate average speed by brand - Not found")
    void testCalculateAvgSpeedByBrandError() throws Exception {
        String path = "/vehicles/average_speed/brand/{brand}";

        mockMvc.perform(
                get(path, "Ford"))
                .andExpect(status().isNotFound())
                .andExpect(result ->
                        assertEquals("No se encontraron vehículos de esa marca.",
                                Objects.requireNonNull(result.getResolvedException()).getMessage())
        );
    }

    //Punto 4
    @Test
    @DisplayName("[SUCCESS] Calculate average capacity by brand")
    void testCalculateAvgCapacityByBrandSuccess() throws Exception {
        String path = "/vehicles/average_capacity/brand/{brand}";

        double averageCapacity = ((double) vehicle2.getPassengers() + (double) vehicle3.getPassengers()) /2;
        VehicleAvgCapacityByBrandDto vehicleAvgCapacity = new VehicleAvgCapacityByBrandDto(averageCapacity);

        String expected = JsonUtils.generateFromObject(vehicleAvgCapacity);

        mockMvc.perform(
                get(path, "Lexus"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$.average").value(averageCapacity))
                .andExpect(content().json(expected));
    }

    @Test
    @DisplayName("[ERROR] Calculate average capacity by brand - Not found brand")
    void testCalculateAvgCapacityByBrandNotFound() throws Exception {
        String path = "/vehicles/average_capacity/brand/{brand}";

        mockMvc.perform(
                get(path, "Ford"))
                .andExpect(status().isNotFound())
                .andExpect(result ->
                        assertEquals("No se encontraron vehículos de esa marca.",
                                Objects.requireNonNull(result.getResolvedException()).getMessage())
                );
    }

    //Punto 5
    @Test
    @DisplayName("[SUCCESS] Find by range of weigth")
    void testSearchVehiclesByRangeOfWeightSuccess() throws Exception {
        String path = "/vehicles/weight";

        String expected = JsonUtils.generateFromObject(List.of(vehicle1));

        mockMvc.perform(get(path)
                        .param("min", String.valueOf(160.0))
                        .param("max", String.valueOf(161.0)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].id").value(vehicle1.getId()))
                .andExpect(jsonPath("$[0].brand").value(vehicle1.getBrand()))
                .andExpect(content().json(expected));
    }

    @Test
    @DisplayName("[ERROR] Find by range of weigth - Not found")
    void testSearchVehiclesByRangeOfWeightNotFound() throws Exception {
        String path = "/vehicles/weight";

        mockMvc.perform(get(path)
                .param("min", String.valueOf(1.0))
                .param("max", String.valueOf(2.0)))
                .andExpect(status().isNotFound())
                .andExpect(result ->
                    assertEquals("No se encontraron vehículos en ese rango de peso.",
                            Objects.requireNonNull(result.getResolvedException()).getMessage())
                );
    }
}
