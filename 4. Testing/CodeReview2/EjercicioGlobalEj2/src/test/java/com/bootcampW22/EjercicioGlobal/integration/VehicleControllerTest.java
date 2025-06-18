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
    private Integer startYear;
    private Integer endYear;

    @BeforeEach
    void setUp() {
        brand = "Subaru";
        startYear = 1990;
        endYear = 2005;
    }

    @DisplayName("Listado de vehiculos por rango de años y marca para el controller")
    @Test
    public void testGetVehiclesByColorAndRangeOfYear() throws Exception {
        List<VehicleDto> expectedList = VehicleUtil.entitytoDto(VehicleUtil
                                            .vehicleListBranAndRangeOfYear(brand, startYear, endYear));
        mockMvc.perform(get("/vehicles/brand/{brand}/between/{startYear}/{endYear}",
                    brand, startYear, endYear)
                    .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(expectedList.size()))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].brand").value(brand))
                .andExpect(jsonPath("$[0].id").value(73));

    }

    @DisplayName("Marca no existente para el controller")
    @Test
    public void testBrandNotFoundInVehiclesByRangeOfYear() throws Exception {
        String expectedMessage = "No se encontraron vehículos con esos criterios.";
        String invalidBrand = "test";

        mockMvc.perform(get("/vehicles/brand/{brand}/between/{startYear}/{endYear}",
                    invalidBrand, startYear, endYear)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value(expectedMessage));
    }

    @DisplayName("Año no existente para el controller")
    @Test
    public void testYearNotFoundInVehiclesByRangeOfYear() throws Exception {
        String expectedMessage = "No se encontraron vehículos con esos criterios.";
        int invalidYear = 999999;

        mockMvc.perform(get("/vehicles/brand/{brand}/between/{startYear}/{endYear}",
                        brand, invalidYear, endYear)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value(expectedMessage));
    }

}