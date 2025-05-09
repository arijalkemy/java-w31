package com.bootcampW22.EjercicioGlobal.integration;

import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgCapacityByBrandDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgSpeedByBrandDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.bootcampW22.EjercicioGlobal.utils.JsonUtils;
import com.bootcampW22.EjercicioGlobal.utils.VehicleFactory;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private VehicleRepositoryImpl vehicleRepository;

    private Vehicle vehicle1;
    private Vehicle vehicle2;
    private Vehicle vehicle3;
    private Vehicle vehicle4;

    @BeforeEach
    void setup() {
        vehicle1 = VehicleFactory.vehicle1;
        vehicle2 = VehicleFactory.vehicle2;
        vehicle3 = VehicleFactory.vehicle3;
        vehicle4 = VehicleFactory.vehicle4;

        vehicleRepository.clearAll();
        vehicleRepository.save(vehicle1);
        vehicleRepository.save(vehicle2);
        vehicleRepository.save(vehicle3);
        vehicleRepository.save(vehicle4);
    }

    /* Punto 1 */



    @Test
    @DisplayName("[SUCCESS] Integration test: Get vehicles by year and color")
    void getVehiclesByColorAndYear_ShouldReturnList_WhenColorAndYearMatch() throws Exception {
        String path = "/vehicles/color/{color}/year/{year}";
        String color = "green";
        int year = 2005;

        // Arrange
        String expected = JsonUtils.generateFromObject(List.of(vehicle1));

        // Act & Assert
        mockMvc.perform(get(path, color, year))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(content().json(expected));
    }

    @Test
    @DisplayName("[ERROR 404] Integration test: Get vehicles by year and color - Not found")
    void getVehiclesByColorAndYear_ShouldReturnError_WhenColorAndYearDontMatch() throws Exception {
        String path = "/vehicles/color/{color}/year/{year}";
        String color = "blue";
        int year = 2019;

        // Act & Assert
        mockMvc.perform(get(path, color, year))
                .andExpect(status().isNotFound())
                .andExpect(result ->
                    assertEquals(
                            "No se encontraron vehículos con esos criterios.",
                            Objects.requireNonNull(result.getResolvedException()).getMessage()
                    )
                )
        ;
    }

    /* Punto 2 */

    @Test
    @DisplayName("[SUCCESS] Integration test: Get vehicles by brand and range of year")
    void getVehiclesByBrandAndRangeOfYear_ShouldReturnList_WhenBrandAndYearsMatch() throws Exception {
        String path = "/vehicles/brand/{brand}/between/{start_year}/{end_year}";
        String brand = "toyota";
        int startYear = 2000;
        int endYear = 2006;

        // Arrange
        String expected = JsonUtils.generateFromObject(List.of(vehicle3));

        // Act & Assert
        mockMvc.perform(get(path, brand, startYear, endYear))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(content().json(expected));
    }

    @Test
    @DisplayName("[ERROR 404] Integration test: Get vehicles by brand and range of year - Not found")
    void getVehiclesByBrandAndRangeOfYear_ShouldReturnError_WhenBrandAndYearsDontMatch() throws Exception {
        String path = "/vehicles/brand/{brand}/between/{start_year}/{end_year}";
        String brand = "bmw";
        int startYear = 2015;
        int endYear = 2019;

        // Act & Assert
        mockMvc.perform(get(path, brand, startYear, endYear))
                .andExpect(status().isNotFound())
                .andExpect(result ->
                        assertEquals(
                                "No se encontraron vehículos con esos criterios.",
                                Objects.requireNonNull(result.getResolvedException()).getMessage()
                        )
                )
        ;
    }

    /* Punto 3 */

    @Test
    @DisplayName("[SUCCESS] Integration test: Get average speed by brand")
    void getAverageSpeedByBrand_ShouldReturnAvgSpeed_WhenBrandHasVehicles() throws Exception {
        String path = "/vehicles/average_speed/brand/{brand}";
        String brand = "lexus";
        Double maxSpeed2 = Double.valueOf(vehicle2.getMax_speed());
        Double maxSpeed4 = Double.valueOf(vehicle4.getMax_speed());
        double expectedAvgSpeed = (maxSpeed2 + maxSpeed4) / 2;

        // Arrange
        VehicleAvgSpeedByBrandDto expectedObj = new VehicleAvgSpeedByBrandDto(expectedAvgSpeed);
        String expected = JsonUtils.generateFromObject(expectedObj);

        // Act & Assert
        mockMvc.perform(get(path, brand))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().json(expected));
    }

    @Test
    @DisplayName("[ERROR 404] Integration test: Get average speed by brand - Not found")
    void getAverageSpeedByBrand_ShouldReturnError_WhenBrandHasNoVehicles() throws Exception {
        String path = "/vehicles/average_speed/brand/{brand}";
        String brand = "bmw";

        // Act & Assert
        mockMvc.perform(get(path, brand))
                .andExpect(status().isNotFound())
                .andExpect(result ->
                        assertEquals(
                                "No se encontraron vehículos de esa marca.",
                                Objects.requireNonNull(result.getResolvedException()).getMessage()
                        )
                )
        ;
    }

    /* Punto 4 */

    @Test
    @DisplayName("[SUCCESS] Integration test: Get average capacity by brand")
    void getAverageCapacityByBrand_ShouldReturnAvgSpeed_WhenBrandHasVehicles() throws Exception {
        String path = "/vehicles/average_capacity/brand/{brand}";
        String brand = "lexus";
        double expectedAvgCapacity = 4.0D;

        // Arrange
        VehicleAvgCapacityByBrandDto expectedObj = new VehicleAvgCapacityByBrandDto(expectedAvgCapacity);
        String expected = JsonUtils.generateFromObject(expectedObj);

        // Act & Assert
        mockMvc.perform(get(path, brand))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().json(expected));
    }

    @Test
    @DisplayName("[ERROR 404] Integration test: Get average capacity by brand - Not found")
    void getAverageCapacityByBrand_ShouldReturnError_WhenBrandHasNoVehicles() throws Exception {
        String path = "/vehicles/average_capacity/brand/{brand}";
        String brand = "bmw";

        // Act & Assert
        mockMvc.perform(get(path, brand))
                .andExpect(status().isNotFound())
                .andExpect(result ->
                        assertEquals(
                                "No se encontraron vehículos de esa marca.",
                                Objects.requireNonNull(result.getResolvedException()).getMessage()
                        )
                )
        ;
    }

    /* Punto 5 */

    @Test
    @DisplayName("[SUCCESS] Integration test: Get vehicles by range of weight")
    void getVehiclesByRangeOfWeight_ShouldReturnList_WhenThereAreVehiclesInTheWeightRange() throws Exception {
        String path = "/vehicles/weight";
        String weightMin = "168.0";
        String weightMax = "168.6";

        // Arrange
        String expected = JsonUtils.generateFromObject(List.of(vehicle2));

        // Act & Assert
        mockMvc.perform(get(path)
                        .param("min", weightMin)
                        .param("max", weightMax)
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(content().json(expected));
    }

    @Test
    @DisplayName("[ERROR 404] Integration test: Get vehicles by range of weight - Not found")
    void getVehiclesByRangeOfWeight_ShouldReturnError_WhenThereAreNoVehiclesInTheWeightRange() throws Exception {
        String path = "/vehicles/weight";
        String weightMin = "200.0";
        String weightMax = "210.6";

        // Act & Assert
        mockMvc.perform(get(path)
                        .param("min", weightMin)
                        .param("max", weightMax)
                )
                .andExpect(status().isNotFound())
                .andExpect(result ->
                        assertEquals(
                                "No se encontraron vehículos en ese rango de peso.",
                                Objects.requireNonNull(result.getResolvedException()).getMessage()
                        )
                )
        ;
    }

}
