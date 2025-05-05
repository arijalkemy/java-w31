package com.bootcampW22.EjercicioGlobal.integration;

import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgCapacityByBrandDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgSpeedByBrandDto;
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

    @BeforeEach
    void setup() {
        vehicleRepository.clearAll();
        vehicleRepository.save(VehicleFactory.vehicle1);
        vehicleRepository.save(VehicleFactory.vehicle2);
        vehicleRepository.save(VehicleFactory.vehicle3);
        vehicleRepository.save(VehicleFactory.vehicle4);
    }

    /* Punto 1 */

    @Test
    @DisplayName("[SUCCESS] Integration test: Get vehicles by year and color")
    void testGetVehiclesByColorAndYear() throws Exception {
        String path = "/vehicles/color/{color}/year/{year}";

        // Arrange
        String expected = JsonUtils.generateFromObject(List.of(VehicleFactory.vehicle1));

        // Act & Assert
        mockMvc.perform(get(path, "green", 2005))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(content().json(expected));
    }

    @Test
    @DisplayName("[ERROR 404] Integration test: Get vehicles by year and color - Not found")
    void testSearchVehiclesByYearAndColorNotFound() throws Exception {
        String path = "/vehicles/color/{color}/year/{year}";

        // Act & Assert
        mockMvc.perform(get(path, "blue", 2019))
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
    void testSearchVehiclesByBrandAndRangeOfYear() throws Exception {
        String path = "/vehicles/brand/{brand}/between/{start_year}/{end_year}";

        // Arrange
        String expected = JsonUtils.generateFromObject(List.of(VehicleFactory.vehicle3));

        // Act & Assert
        mockMvc.perform(get(path, "toyota", 2000, 2006))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(content().json(expected));
    }

    @Test
    @DisplayName("[ERROR 404] Integration test: Get vehicles by brand and range of year - Not found")
    void testSearchVehiclesByBrandAndRangeOfYearNotFound() throws Exception {
        String path = "/vehicles/brand/{brand}/between/{start_year}/{end_year}";

        // Act & Assert
        mockMvc.perform(get(path, "bmw", 2015, 2019))
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
    void testGetAverageSpeedByBrand() throws Exception {
        String path = "/vehicles/average_speed/brand/{brand}";

        // Arrange
        VehicleAvgSpeedByBrandDto expectedObj = new VehicleAvgSpeedByBrandDto(134.5D);
        String expected = JsonUtils.generateFromObject(expectedObj);

        // Act & Assert
        mockMvc.perform(get(path, "lexus"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().json(expected));
    }

    @Test
    @DisplayName("[ERROR 404] Integration test: Get average speed by brand - Not found")
    void testGetAverageSpeedByBrandNotFound() throws Exception {
        String path = "/vehicles/average_speed/brand/{brand}";

        // Act & Assert
        mockMvc.perform(get(path, "bmw"))
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
    void testGetAverageCapacityByBrand() throws Exception {
        String path = "/vehicles/average_capacity/brand/{brand}";

        // Arrange
        VehicleAvgCapacityByBrandDto expectedObj = new VehicleAvgCapacityByBrandDto(4.0D);
        String expected = JsonUtils.generateFromObject(expectedObj);

        // Act & Assert
        mockMvc.perform(get(path, "lexus"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content().json(expected));
    }

    @Test
    @DisplayName("[ERROR 404] Integration test: Get average capacity by brand - Not found")
    void testGetAverageCapacityByBrandNotFound() throws Exception {
        String path = "/vehicles/average_capacity/brand/{brand}";

        // Act & Assert
        mockMvc.perform(get(path, "bmw"))
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
    void testGetVehiclesByRangeOfWeight() throws Exception {
        String path = "/vehicles/weight";

        // Arrange
        String expected = JsonUtils.generateFromObject(List.of(VehicleFactory.vehicle2));

        // Act & Assert
        mockMvc.perform(get(path)
                        .param("min", "168.0")
                        .param("max", "168.6")
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(content().json(expected));
    }

    @Test
    @DisplayName("[ERROR 404] Integration test: Get vehicles by range of weight - Not found")
    void testGetVehiclesByRangeOfWeightNotFound() throws Exception {
        String path = "/vehicles/weight";

        // Act & Assert
        mockMvc.perform(get(path)
                        .param("min", "200")
                        .param("max", "210")
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
