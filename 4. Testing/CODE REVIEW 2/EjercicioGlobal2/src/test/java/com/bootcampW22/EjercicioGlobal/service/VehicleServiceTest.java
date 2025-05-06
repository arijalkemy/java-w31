package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgCapacityByBrandDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgSpeedByBrandDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.bootcampW22.EjercicioGlobal.utils.VehicleFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VehicleServiceTest {

    @Mock
    private VehicleRepositoryImpl vehicleRepository;

    @InjectMocks
    private VehicleServiceImpl vehicleService;

    /* Punto 1 */

    @Test
    @DisplayName("[SUCCESS] Unit test: Get vehicles by year and color")
    void searchVehiclesByYearAndColor() {
        // Arrange
        List<Vehicle> vehicleList = List.of(VehicleFactory.vehicle1);
        List<VehicleDto> expectedResult = List.of(VehicleFactory.convertToVehicleDto(VehicleFactory.vehicle1));
        when(vehicleRepository.findVehiclesByYearAndColor("green", 2005)).thenReturn(vehicleList);

        // Act
        List<VehicleDto> result = vehicleService.searchVehiclesByYearAndColor("green", 2005);

        // Assert
        assertAll(
                () -> assertEquals(1, result.size()),
                () -> assertEquals(expectedResult.getFirst(), result.getFirst())
        );
    }

    @Test
    @DisplayName("[ERROR 404] Unit test: Get vehicles by year and color - Not found")
    void searchVehiclesByYearAndColorNotFound() {
        // Arrange
        when(vehicleRepository.findVehiclesByYearAndColor("blue", 2019))
                .thenReturn(Collections.emptyList());

        // Act & Assert
        assertThrows(NotFoundException.class, () ->
                vehicleService.searchVehiclesByYearAndColor("blue", 2019)
        );
    }

    /* Punto 2 */

    @Test
    @DisplayName("[SUCCESS] Unit test: Get vehicles by brand and range of year")
    void searchVehiclesByBrandAndRangeOfYear() {
        // Arrange
        List<Vehicle> vehicleList = List.of(VehicleFactory.vehicle3);
        List<VehicleDto> expectedResult = List.of(VehicleFactory.convertToVehicleDto(VehicleFactory.vehicle3));
        when(vehicleRepository.findVehiclesByBrandAndRangeOfYear("toyota", 2000, 2006)).thenReturn(vehicleList);

        // Act
        List<VehicleDto> result = vehicleService.searchVehiclesByBrandAndRangeOfYear("toyota", 2000, 2006);

        // Assert
        assertAll(
                () -> assertEquals(1, result.size()),
                () -> assertEquals(expectedResult.getFirst(), result.getFirst())
        );
    }

    @Test
    @DisplayName("[ERROR 404] Unit test: Get vehicles by brand and range of year - Not found")
    void searchVehiclesByBrandAndRangeOfYearNotFound() {
        // Arrange
        when(vehicleRepository.findVehiclesByBrandAndRangeOfYear("bmw", 2015, 2019))
                .thenReturn(Collections.emptyList());

        // Act & Assert
        assertThrows(NotFoundException.class, () ->
                vehicleService.searchVehiclesByBrandAndRangeOfYear("bmw", 2015, 2019)
        );
    }

    /* Punto 3 */

    @Test
    @DisplayName("[SUCCESS] Unit test: Get average speed by brand")
    void calculateAvgSpeedByBrand() {
        // Arrange
        Vehicle vehicle2 = VehicleFactory.vehicle2;
        Vehicle vehicle4 = VehicleFactory.vehicle4;
        List<Vehicle> vehicleList = List.of(vehicle2, vehicle4);
        VehicleAvgSpeedByBrandDto expected = new VehicleAvgSpeedByBrandDto(134.5D);

        when(vehicleRepository.findVehiclesByBrand("lexus")).thenReturn(vehicleList);

        // Act
        VehicleAvgSpeedByBrandDto result = vehicleService.calculateAvgSpeedByBrand("lexus");

        // Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("[ERROR 404] Unit test: Get average speed by brand - Not found")
    void calculateAvgSpeedByBrandNotFound() {
        // Arrange
        when(vehicleRepository.findVehiclesByBrand("bmw"))
                .thenReturn(Collections.emptyList());

        // Act & Assert
        assertThrows(NotFoundException.class, () ->
                vehicleService.calculateAvgSpeedByBrand("bmw")
        );
    }

    /* Punto 4 */

    @Test
    @DisplayName("[SUCCESS] Unit test: Get average capacity by brand")
    void calculateAvgCapacityByBrand() {
        // Arrange
        Vehicle vehicle2 = VehicleFactory.vehicle2;
        Vehicle vehicle4 = VehicleFactory.vehicle4;
        List<Vehicle> vehicleList = List.of(vehicle2, vehicle4);
        VehicleAvgCapacityByBrandDto expected = new VehicleAvgCapacityByBrandDto(4.0D);

        when(vehicleRepository.findVehiclesByBrand("lexus")).thenReturn(vehicleList);

        // Act
        VehicleAvgCapacityByBrandDto result = vehicleService.calculateAvgCapacityByBrand("lexus");

        // Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("[ERROR 404] Unit test: Get average capacity by brand - Not found")
    void calculateAvgCapacityByBrandNotFound() {
        // Arrange
        when(vehicleRepository.findVehiclesByBrand("bmw"))
                .thenReturn(Collections.emptyList());

        // Act & Assert
        assertThrows(NotFoundException.class, () ->
                vehicleService.calculateAvgCapacityByBrand("bmw")
        );
    }

    /* Punto 5 */

    @Test
    @DisplayName("[SUCCESS] Unit test: Get vehicles by range of weight")
    void searchVehiclesByRangeOfWeight() {
        // Arrange
        Vehicle vehicle2 = VehicleFactory.vehicle2;
        List<Vehicle> vehicleList = List.of(vehicle2);
        List<VehicleDto> expectedResult = List.of(VehicleFactory.convertToVehicleDto(vehicle2));

        when(vehicleRepository.findVehiclesByRangeOfWeight(168.0, 168.6)).thenReturn(vehicleList);

        // Act
        List<VehicleDto> result = vehicleService.searchVehiclesByRangeOfWeight(168.0, 168.6);

        // Assert
        assertAll(
                () -> assertEquals(1, result.size()),
                () -> assertEquals(expectedResult.getFirst(), result.getFirst())
        );
    }

    @Test
    @DisplayName("[ERROR 404] Unit test: Get vehicles by range of weight - Not found")
    void searchVehiclesByRangeOfWeightNotFound() {
        // Arrange
        when(vehicleRepository.findVehiclesByRangeOfWeight(200, 210))
                .thenReturn(Collections.emptyList());

        // Act & Assert
        assertThrows(NotFoundException.class, () ->
                vehicleService.searchVehiclesByRangeOfWeight(200, 210)
        );
    }
}
