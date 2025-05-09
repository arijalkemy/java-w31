package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.utils.TestDataFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class VehicleControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @ParameterizedTest
    @CsvSource({
            "yellow, 1984, 200",
            "blue, 2015, 404"
    })
    void testVehiclesByYearAndColor(String color, int year, int expectedStatus) throws Exception {
        mockMvc.perform(get("/vehicles/color/{color}/year/{year}", color, year)
                        .param("color", color)
                        .param("year", String.valueOf(year)))
                .andExpect(status().is(expectedStatus))
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().string(expectedStatus == 200
                        ? TestDataFactory.getVehiclesByYearAndColor()
                        : TestDataFactory.getVehicleNotFoundJson()));
    }

    @ParameterizedTest
    @CsvSource({
            "yellow, 1984, 200",
            "amarillo, 2200, 404"
    })
    void testVehiclesByColorAndYear(String color, int year, int statusCode) throws Exception{
        mockMvc.perform(get("/vehicles/color/{color}/year/{year}", color, year))
                .andExpect(status().is(statusCode))
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().string(statusCode == 200
                        ? TestDataFactory.getVehiclesByYearAndColor()
                        :TestDataFactory.getVehicleNotFoundJson()));
    }


    @ParameterizedTest
    @CsvSource({
            "renault, 1910, 2010, 200",
            "logan, 2015, 2020, 404"
    })
    void testVehiclesByBrandAndYear(String brand, int startYear, int endYear, int expectedStatus) throws Exception {
        mockMvc.perform(get("/vehicles/brand/{brand}/between/{start_year}/{end_year}", brand,startYear, endYear))
                .andExpect(status().is(expectedStatus))
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().string(expectedStatus == 200
                        ? TestDataFactory.getVehiclesByBrandAndYear()
                        : TestDataFactory.getVehicleNotFoundJson()));
    }

    @ParameterizedTest
    @CsvSource({
            "chevrolet, 200",
            "logan, 404"
    })
    void testAverageSpeedByBrand(String brand, int statusCode) throws Exception {
        mockMvc.perform(get("/vehicles/average_speed/brand/{brand}", brand))
                .andExpect(status().is(statusCode))
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().string(statusCode == 200
                        ? TestDataFactory.getAverageSpeedByBrand()
                        : TestDataFactory.getVehicleNotFoundByBrandJson()));
    }

    @ParameterizedTest
    @CsvSource({
            "Renault, 200",
            "Logan, 404"
    })
    void testAverageCapacityByBrand(String brand, int statusCode) throws Exception{
        mockMvc.perform(get("/vehicles/average_capacity/brand/{brand}", brand))
                .andExpect(status().is(statusCode))
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().string(statusCode == 200
                        ? TestDataFactory.getAverageCapacityByBrand()
                        :TestDataFactory.getVehicleNotFoundByBrandJson()));
    }

//    @ParameterizedTest
//    @CsvSource({
//            "200, 201, 200",
//            "5000,5001, 404"
//    })
//    void testRangeOfCapacity(String weightMin, String weightMax, int statusCode) throws Exception {
//        mockMvc.perform(get("/vehicles/weight")
//                        .param("min", weightMin)
//                        .param("max", weightMax))
//                .andExpect(status().is(statusCode))
//                .andExpect(content().contentType("application/json;charset=UTF-8"))
//                .andExpect(content().string(statusCode == 200
//                        ? TestDataFactory.getVehiclesByRangeOfCapacity()
//                        : TestDataFactory.getVehicleNotFoundByWeightJson()));
//    }


















    @ParameterizedTest
    @CsvSource({
            "200, 201, 200",
            "400, 401, 404"
    })
    void testVehiclesByRangeOfWeight(String min,String max, int statusCode) throws Exception{
        mockMvc.perform(get("/vehicles/weight")
                .param("min", min)
                .param("max", max))
                .andExpect(status().is(statusCode))
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().string(statusCode == 200
                ? TestDataFactory.getVehiclesByRangeOfCapacity()
                        : TestDataFactory.getVehicleNotFoundByWeightJson()
                ));
    }

}
