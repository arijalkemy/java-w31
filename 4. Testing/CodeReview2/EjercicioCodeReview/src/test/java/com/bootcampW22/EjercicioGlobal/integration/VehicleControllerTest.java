package com.bootcampW22.EjercicioGlobal.integration;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.utils.VehicleUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
class VehicleControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private Double minWeight;
    private Double maxWeight;

    @BeforeEach
    void setUp() {
        minWeight = 150.8;
        maxWeight = 250.8;
    }

    @Test
    @DisplayName("Test controller listado de vehiculos por rando de peso")
    public void testGetVehiclesByRangeOfWeight() throws Exception{
        List<Vehicle> vehicleList = VehicleUtil.vehicleListByRangeOfWeight(minWeight, maxWeight);
        mockMvc.perform(get("/vehicles/weight?min={weight_min}&max={weight_max}", minWeight, maxWeight)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(vehicleList.size()))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].weight").value(199.22))
                .andExpect(jsonPath("$[0].id").value(2));
    }

    @Test
    @DisplayName("Test rango de pesos no encontrado en el controller")
    public void testGetVehiclesByRangeOfWeightNotFound() throws Exception{
        double invalidMinWeight = 999999;
        String expectedMessage = "No se encontraron vehículos en ese rango de peso.";
        mockMvc.perform(get("/vehicles/weight?min={weight_min}&max={weight_max}", invalidMinWeight, maxWeight)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value(expectedMessage));

    }
}