package com.bootcampW22.EjercicioGlobal.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
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
    private Double expectedCapacity;

    @BeforeEach
    void setUp() {
        brand = "Subaru";
        expectedCapacity = 3.00;
    }

    @Test
    public void testGetAverageCapacityByBrand() throws Exception{
        mockMvc.perform(get("/vehicles/average_capacity/brand/{brand}", brand))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.average_capacity").value(expectedCapacity));
    }

    @Test
    public void testBrandNotFound() throws Exception{
        String invalidBrand = "test";
        String expectedMessage = "No se encontraron vehículos de esa marca.";
        mockMvc.perform(get("/vehicles/average_capacity/brand/{brand}", invalidBrand))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value(expectedMessage));
    }
}