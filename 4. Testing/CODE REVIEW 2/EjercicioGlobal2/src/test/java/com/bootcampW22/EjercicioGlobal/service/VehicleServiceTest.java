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
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VehicleServiceTest {

    @Mock
    private VehicleRepositoryImpl vehicleRepository;

    @InjectMocks
    private VehicleServiceImpl vehicleService;

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
    }

    /* Punto 1 */

    @Test
    @DisplayName("[SUCCESS] Unit test: Get vehicles by year and color")
    void searchVehiclesByColorYearAndColor_ShouldReturnList_WhenColorAndYearMatch() {
        String color = "green";
        int year = 2005;

        // Arrange
        List<Vehicle> vehicleList = List.of(vehicle1);
        List<VehicleDto> expectedResult = List.of(VehicleFactory.convertToVehicleDto(vehicle1));
        when(vehicleRepository.findVehiclesByYearAndColor(color, year)).thenReturn(vehicleList);

        // Act
        List<VehicleDto> result = vehicleService.searchVehiclesByYearAndColor(color, year);

        // Assert
        assertAll(
                () -> assertEquals(expectedResult.size(), result.size()),
                () -> assertEquals(expectedResult.getFirst(), result.getFirst())
        );

        verify(vehicleRepository).findVehiclesByYearAndColor(color, year);
        verifyNoMoreInteractions(vehicleRepository);
    }

    @Test
    @DisplayName("[ERROR 404] Unit test: Get vehicles by year and color - Not found")
    void searchVehiclesByColorYearAndColor_ShouldReturnError_WhenColorAndYearDontMatch() {
        String color = "blue";
        int year = 2019;

        // Arrange
        when(vehicleRepository.findVehiclesByYearAndColor(color, year))
                .thenReturn(Collections.emptyList());

        // Act
        NotFoundException notFoundException = assertThrows(NotFoundException.class, () ->
                vehicleService.searchVehiclesByYearAndColor(color, year)
        );

        // Assert
        assertEquals("No se encontraron vehículos con esos criterios.", notFoundException.getMessage());

        verify(vehicleRepository).findVehiclesByYearAndColor(color, year);
        verifyNoMoreInteractions(vehicleRepository);
    }

    /* Punto 2 */

    @Test
    @DisplayName("[SUCCESS] Unit test: Get vehicles by brand and range of year")
    void searchVehiclesByBrandAndRangeOfYear_ShouldReturnList_WhenBrandAndYearsMatch() {
        String brand = "toyota";
        int startYear = 2000;
        int endYear = 2006;

        // Arrange
        List<Vehicle> vehicleList = List.of(vehicle3);
        List<VehicleDto> expectedResult = List.of(VehicleFactory.convertToVehicleDto(vehicle3));
        when(vehicleRepository.findVehiclesByBrandAndRangeOfYear(brand, startYear, endYear)).thenReturn(vehicleList);

        // Act
        List<VehicleDto> result = vehicleService.searchVehiclesByBrandAndRangeOfYear(brand, startYear, endYear);

        // Assert
        assertAll(
                () -> assertEquals(expectedResult.size(), result.size()),
                () -> assertEquals(expectedResult.getFirst(), result.getFirst())
        );

        verify(vehicleRepository).findVehiclesByBrandAndRangeOfYear(brand, startYear, endYear);
        verifyNoMoreInteractions(vehicleRepository);
    }

    @Test
    @DisplayName("[ERROR 404] Unit test: Get vehicles by brand and range of year - Not found")
    void searchVehiclesByBrandAndRangeOfYear_ShouldReturnError_WhenBrandAndYearsDontMatch() {
        String brand = "bmw";
        int startYear = 2015;
        int endYear = 2019;

        // Arrange
        when(vehicleRepository.findVehiclesByBrandAndRangeOfYear(brand, startYear, endYear))
                .thenReturn(Collections.emptyList());

        // Act
        NotFoundException notFoundException = assertThrows(NotFoundException.class, () ->
                vehicleService.searchVehiclesByBrandAndRangeOfYear(brand, startYear, endYear)
        );

        // Assert
        assertEquals("No se encontraron vehículos con esos criterios.", notFoundException.getMessage());

        verify(vehicleRepository).findVehiclesByBrandAndRangeOfYear(brand, startYear, endYear);
        verifyNoMoreInteractions(vehicleRepository);
    }

    /* Punto 3 */

    @Test
    @DisplayName("[SUCCESS] Unit test: Get average speed by brand")
    void calculateAvgSpeedByBrand_ShouldReturnAvgSpeed_WhenBrandHasVehicles() {
        String brand = "lexus";

        // Arrange
        List<Vehicle> vehicleList = List.of(vehicle2, vehicle4);
        when(vehicleRepository.findVehiclesByBrand(brand)).thenReturn(vehicleList);

        Double maxSpeed2 = Double.valueOf(vehicle2.getMax_speed());
        Double maxSpeed4 = Double.valueOf(vehicle4.getMax_speed());
        double expectedAvgSpeed = (maxSpeed2 + maxSpeed4) / 2;
        VehicleAvgSpeedByBrandDto expected = new VehicleAvgSpeedByBrandDto(expectedAvgSpeed);

        // Act
        VehicleAvgSpeedByBrandDto result = vehicleService.calculateAvgSpeedByBrand(brand);

        // Assert
        assertEquals(expected, result);

        verify(vehicleRepository).findVehiclesByBrand(brand);
        verifyNoMoreInteractions(vehicleRepository);
    }

    @Test
    @DisplayName("[ERROR 404] Unit test: Get average speed by brand - Not found")
    void calculateAvgSpeedByBrand_ShouldReturnError_WhenBrandHasNoVehicles() {
        String brand = "bmw";

        // Arrange
        when(vehicleRepository.findVehiclesByBrand(brand)).thenReturn(Collections.emptyList());

        // Act
        NotFoundException notFoundException = assertThrows(NotFoundException.class, () ->
                vehicleService.calculateAvgSpeedByBrand(brand)
        );

        // Assert
        assertEquals("No se encontraron vehículos de esa marca.", notFoundException.getMessage());

        verify(vehicleRepository).findVehiclesByBrand(brand);
        verifyNoMoreInteractions(vehicleRepository);
    }

    /* Punto 4 */

    @Test
    @DisplayName("[SUCCESS] Unit test: Get average capacity by brand")
    void calculateAvgCapacityByBrand_ShouldReturnAvgSpeed_WhenBrandHasVehicles() {
        String brand = "lexus";

        // Arrange
        List<Vehicle> vehicleList = List.of(vehicle2, vehicle4);
        when(vehicleRepository.findVehiclesByBrand(brand)).thenReturn(vehicleList);

        double passengers2 = vehicle2.getPassengers();
        double passengers4 = vehicle4.getPassengers();
        double expectedAvgCapacity = (passengers2 + passengers4) / 2;
        VehicleAvgCapacityByBrandDto expected = new VehicleAvgCapacityByBrandDto(expectedAvgCapacity);

        // Act
        VehicleAvgCapacityByBrandDto result = vehicleService.calculateAvgCapacityByBrand(brand);

        // Assert
        assertEquals(expected, result);

        verify(vehicleRepository).findVehiclesByBrand(brand);
        verifyNoMoreInteractions(vehicleRepository);
    }

    @Test
    @DisplayName("[ERROR 404] Unit test: Get average capacity by brand - Not found")
    void calculateAvgCapacityByBrand_ShouldReturnError_WhenBrandHasNoVehicles() {
        String brand = "bmw";

        // Arrange
        when(vehicleRepository.findVehiclesByBrand(brand)).thenReturn(Collections.emptyList());

        // Act
        NotFoundException notFoundException = assertThrows(NotFoundException.class, () ->
                vehicleService.calculateAvgCapacityByBrand(brand)
        );

        // Assert
        assertEquals("No se encontraron vehículos de esa marca.", notFoundException.getMessage());

        verify(vehicleRepository).findVehiclesByBrand(brand);
        verifyNoMoreInteractions(vehicleRepository);
    }

    /* Punto 5 */

    @Test
    @DisplayName("[SUCCESS] Unit test: Get vehicles by range of weight")
    void searchVehiclesByRangeOfWeight_ShouldReturnList_WhenThereAreVehiclesInTheWeightRange() {
        double weightMin = 168.0D;
        double weightMax = 168.6D;

        // Arrange
        List<Vehicle> vehicleList = List.of(vehicle2);
        List<VehicleDto> expectedResult = List.of(VehicleFactory.convertToVehicleDto(vehicle2));

        when(vehicleRepository.findVehiclesByRangeOfWeight(weightMin, weightMax)).thenReturn(vehicleList);

        // Act
        List<VehicleDto> result = vehicleService.searchVehiclesByRangeOfWeight(weightMin, weightMax);

        // Assert
        assertAll(
                () -> assertEquals(expectedResult.size(), result.size()),
                () -> assertEquals(expectedResult.getFirst(), result.getFirst())
        );

        verify(vehicleRepository).findVehiclesByRangeOfWeight(weightMin, weightMax);
        verifyNoMoreInteractions(vehicleRepository);
    }

    @Test
    @DisplayName("[ERROR 404] Unit test: Get vehicles by range of weight - Not found")
    void searchVehiclesByRangeOfWeight_ShouldReturnError_WhenThereAreNoVehiclesInTheWeightRange() {
        double weightMin = 200.0D;
        double weightMax = 210.0D;

        // Arrange
        when(vehicleRepository.findVehiclesByRangeOfWeight(weightMin, weightMax)).thenReturn(Collections.emptyList());

        // Act
        NotFoundException notFoundException = assertThrows(NotFoundException.class, () ->
                vehicleService.searchVehiclesByRangeOfWeight(weightMin, weightMax)
        );

        // Assert
        assertEquals("No se encontraron vehículos en ese rango de peso.", notFoundException.getMessage());

        verify(vehicleRepository).findVehiclesByRangeOfWeight(weightMin, weightMax);
        verifyNoMoreInteractions(vehicleRepository);
    }
}
