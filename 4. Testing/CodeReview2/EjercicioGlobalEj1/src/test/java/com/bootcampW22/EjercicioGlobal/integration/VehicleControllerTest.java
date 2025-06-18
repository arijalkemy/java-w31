package com.bootcampW22.EjercicioGlobal.integration;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
class VehicleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private String color;
    private Integer year;

    @BeforeEach
    public void setUp() {
        color = "Green";
        year = 1990;
    }

    @DisplayName("Obtener vehiculos por color y marca especificados")
    @Test
    public void testGetVehiclesByColorAndYear() throws Exception {
        List<VehicleDto> expectedVehicles = VehicleUtil.vehicleListColorAndYear(color, year).stream()
                .map(VehicleUtil::entitytoDto)
                .toList();

        mockMvc.perform(get("/vehicles/color/{color}/year/{year}", color, year)
                    .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(expectedVehicles.size()))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].color").value("Green"))
                .andExpect(jsonPath("$[0].id").value(497));
    }

    @DisplayName("Obtener vehiculos por un color que no existe")
    @Test
    public void testVehicleColorNotFound() throws Exception {
        String invalidColor = "test";
        String expectedMessage = "No se encontraron vehículos con esos criterios.";
        mockMvc.perform(get("/vehicles/color/{color}/year/{year}", invalidColor, year)
                    .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value(expectedMessage));
    }

    @DisplayName("Obtener vehiculos por un año que no existe")
    @Test
    public void testVehicleYearNotFound() throws Exception {
        int invalidYear = 99999;
        String expectedMessage = "No se encontraron vehículos con esos criterios.";
        mockMvc.perform(get("/vehicles/color/{color}/year/{year}", color, invalidYear)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value(expectedMessage));
    }
}