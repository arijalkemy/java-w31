package com.bootcampW22.EjercicioGlobal.integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
class VehicleControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private String brand;
    private Double avgSpeed;

    @BeforeEach
    void setUp() {
        brand = "Subaru";
        avgSpeed = 150.38;
    }

    @DisplayName("Test controller calculate average speed")
    @Test
    public void testGetAverageSpeedByBrand() throws Exception{
        mockMvc.perform(get("/vehicles/average_speed/brand/{brand}", brand)
                    .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.average_speed").value(avgSpeed));
    }

    @DisplayName("Test brand not found calculating avgerage speed")
    @Test
    public void testAvgSpeedByBrandNotFound() throws Exception{
        String expectedMessage = "No se encontraron vehículos de esa marca.";
        String invalidBrand = "test";
        mockMvc.perform(get("/vehicles/average_speed/brand/{brand}", invalidBrand)
                    .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value(expectedMessage));
    }
}