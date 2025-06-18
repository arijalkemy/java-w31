package com.bootcampW22.EjercicioGlobal.integration;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.utils.VehicleUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
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
        minWeight = 150.5;
        maxWeight = 200.8;
    }

    @Test
    public void testGetVehiclesByRangeOfWeight() throws Exception{
        List<Vehicle> vehicleListExpected = VehicleUtil.vehicleListByRangeOfWeight(minWeight,maxWeight);
        int expectedLenght = vehicleListExpected.size();
        mockMvc.perform(get("/vehicles/weight?min={minWeight}&max={maxWeight}", minWeight,maxWeight)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(expectedLenght))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].weight").value(199.22))
                .andExpect(jsonPath("$[0].id").value(2));
    }

    @Test
    public void testInvalidMinWeight() throws Exception {
        Double invalidMinWeigth = 999999.0;
        String expectedMessage = "No se encontraron vehículos en ese rango de peso.";
        mockMvc.perform(get("/vehicles/weight?min={invalidMinWeigth}&max={maxWeight}",
                        invalidMinWeigth,maxWeight)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value(expectedMessage));
    }

    @Test
    public void testInvalidMaxWeight() throws Exception {
        Double invalidMaxWeight = -120.0;
        String expectedMessage = "No se encontraron vehículos en ese rango de peso.";
        mockMvc.perform(get("/vehicles/weight?min={minWeigth}&max={invalidMaxWeight}",
                        minWeight,invalidMaxWeight)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value(expectedMessage));
    }
}