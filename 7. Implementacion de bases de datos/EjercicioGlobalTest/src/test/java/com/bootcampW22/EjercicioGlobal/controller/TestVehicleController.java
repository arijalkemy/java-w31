package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class TestVehicleController {

    @Autowired
    MockMvc mockMvc;

    @Test
    void testGetVehiclesHappyPath() throws Exception {
        mockMvc.perform(get("/vehicles"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray());
    }
    @Test
    void testGetVehiclesByColorAndYearHappyPath() throws  Exception{
        String color = "Mauv";
        int year = 1986;
        mockMvc.perform(get("/vehicles/color/{color}/year/{year}",color,year))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[*].color").value(everyItem(is(color))))
                .andExpect(jsonPath("$[*].year").value(everyItem(is(year))));
    }
    @Test
    void testGetVehiclesByColorAndYearSadPath() throws  Exception{
        String color = "Sin color";
        int year = 1986;
        mockMvc.perform(get("/vehicles/color/{color}/year/{year}",color,year))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("No se encontraron vehículos con esos criterios."));
    }

    @Test
    void testGetVehiclesByColorAndRangeOfYearHappyPath() throws Exception{
        String brand = "Pontiac";
        int start_year = 1900;
        int end_year = 2025;

        mockMvc.perform(get("/vehicles/brand/{brand}/between/{start_year}/{end_year}",
                brand,start_year,end_year))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[*].brand").value(everyItem(is(brand))))
                .andExpect(jsonPath("$[*].year").value(everyItem(
                        allOf(greaterThanOrEqualTo(start_year),lessThanOrEqualTo(end_year))
                )));

    }

    @Test
    void testGetVehiclesByColorAndRangeOfYearSadPath() throws Exception{
        String brand = "Sin Marca";
        int start_year = 1900;
        int end_year = 2025;

        mockMvc.perform(get("/vehicles/brand/{brand}/between/{start_year}/{end_year}",
                        brand,start_year,end_year))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("No se encontraron vehículos con esos criterios."));

    }

    //@GetMapping("/average_speed/brand/{brand}")
    //    public ResponseEntity<?> getAverageSpeedByBrand(@PathVariable String brand){
    //        return new ResponseEntity<>(vehicleService.calculateAvgSpeedByBrand(brand),HttpStatus.OK);
    //    }

    @Test
    void testGetAverageSpeedByBrandHappyPath() throws  Exception{
        //Arrage
        String brand = "Pontiac";

        //Act & Assert
        mockMvc.perform(get("/vehicles/average_speed/brand/{brand}",brand))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.average_speed").isNumber())
                .andExpect(jsonPath("$.average_speed").value(greaterThan(0.0)));
    }
    @Test
    void testGetAverageSpeedByBrandSadPath() throws  Exception{
        //Arrage
        String brand = "Sin Marca";

        //Act & Assert
        mockMvc.perform(get("/vehicles/average_speed/brand/{brand}",brand))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("No se encontraron vehículos de esa marca."));
    }

    @Test
    void testGetAverageCapacityByBrandHappyPath() throws Exception{
        //Arrange
        String brand = "Pontiac";

        //Act & Assert
        mockMvc.perform(get("/vehicles/average_capacity/brand/{brand}",brand))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.average_capacity").isNumber())
                .andExpect(jsonPath("$.average_capacity").value(greaterThan(0.0)));

    }

    @Test
    void testGetAverageCapacityByBrandSadPath() throws Exception{
        //Arrange
        String brand = "Sin Marca";

        //Act & Assert
        mockMvc.perform(get("/vehicles/average_capacity/brand/{brand}",brand))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("No se encontraron vehículos de esa marca."));

    }

    //@GetMapping("/weight")
    //    public ResponseEntity<?> getVehiclesByRangeOfWeight(@RequestParam double min, @RequestParam double max){
    //        return new ResponseEntity<>(vehicleService.searchVehiclesByRangeOfWeight(min,max),HttpStatus.OK);
    //    }

    @Test
    void testGetVehiclesByRangeOfWeightHappyPath() throws Exception{
        //Arrange
        double min = 100, max = 500;

        //Act & Assert
        mockMvc.perform(get("/vehicles/weight")
                .param("min", String.valueOf(min))
                .param("max", String.valueOf(max)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[*].weight").value(everyItem(allOf(greaterThanOrEqualTo(min),lessThanOrEqualTo(max)))));
    }

    @Test
    void testGetVehiclesByRangeOfWeightSadPath() throws Exception{
        //Arrange
        double min = 100, max = 100;

        //Act & Assert
        mockMvc.perform(get("/vehicles/weight")
                        .param("min", String.valueOf(min))
                        .param("max", String.valueOf(max)))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("No se encontraron vehículos en ese rango de peso."));
    }

}
