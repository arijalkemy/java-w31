package com.bootcampW22.EjercicioGlobal.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class VehicleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void testGetVehiclesByBrandAndRangeOfYearHappyPath() throws Exception{
        //Arrange
        String brand = "Pontiac";
        int start_year = 1900, end_year = 2025;

        //Act & Assert
        mockMvc.perform(get("/vehicles/brand/{brand}/between/{start_year}/{end_year}",brand,start_year,end_year))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[*].brand").value(everyItem(is(brand))))
                .andExpect(jsonPath("$[*].year").value(everyItem(allOf(greaterThanOrEqualTo(start_year),lessThanOrEqualTo(end_year)))));

    }

    @Test
    void testGetVehiclesByBrandAndRangeOfYearSadPath() throws Exception{
        //Arrange
        String brand = "Sin Marca";
        int start_year = 1900, end_year = 2025;

        //Act & Assert
        mockMvc.perform(get("/vehicles/brand/{brand}/between/{start_year}/{end_year}",brand,start_year,end_year))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("No se encontraron vehículos con esos criterios."));


    }
}