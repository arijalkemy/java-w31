package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.bootcampW22.EjercicioGlobal.util.TestVehicleGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ServicesTests {

    @Mock
    VehicleRepositoryImpl repository;

    @InjectMocks
    VehicleServiceImpl service;

    @ParameterizedTest(name = "Test: {index} => Min: {0} - Max: {1}")
    @CsvSource({
            "280, 290",
            "123.31, 170.13",
            "300, 350.13"
    })
    @DisplayName("Should return vehicles list when range weight matches")
    void testGetVehiclesByRangeOfWeight_shouldReturnVehiclesList_whenRangeWeightMatches(double min, double max) {
        // Arrange
        List<VehicleDto> expected = TestVehicleGenerator.getVehiclesDTOByRangeWeight(min, max);
        List<Vehicle> vehicleByRange = TestVehicleGenerator.getVehiclesByRangeWeight(min, max);

        // Act
        when(repository.findVehiclesByRangeOfWeight(min, max)).thenReturn(vehicleByRange);

        List<VehicleDto> response = service.searchVehiclesByRangeOfWeight(min, max);

        // Assert
        Assertions.assertEquals(expected, response);
        verify(repository, atLeast(1)).findVehiclesByRangeOfWeight(min, max);
    }

    @ParameterizedTest(name = "Test: {index} => Min: {0} - Max: {1}")
    @CsvSource({
            "110, 119",
            "999.31, 1000",
            "390, 340"
    })
    @DisplayName("Should throw Not Found Exception when weight doesn´t match")
    void testGetVehiclesByRangeOfWeight_shouldThrowNotFoundException_whenRangeWeightDontMatches(double min, double max) {
        // Arrange
        String expected = "No se encontraron vehículos en ese rango de peso.";

        // Act
        NotFoundException thrown = Assertions.assertThrows(NotFoundException.class,
                () -> service.searchVehiclesByRangeOfWeight(min, max));

        // Assert
        Assertions.assertEquals(expected, thrown.getMessage());
    }
}
