package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgCapacityByBrandDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgSpeedByBrandDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.util.VehicleFactory;
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
public class VehicleServiceTest {
    @Mock
    private IVehicleRepository vehicleRepository;

    @InjectMocks
    private VehicleServiceImpl vehicleService;

    private Vehicle vehicleYellow09;
    private Vehicle vehicleBlack05;
    private Vehicle vehicleOrange03;
    private Vehicle vehicleGreen05;

    @BeforeEach
    void setUp(){
        vehicleYellow09 = VehicleFactory.createVehicleLexusYellow2009();
        vehicleBlack05 = VehicleFactory.createVehicleToyotaBlack2005();
        vehicleOrange03 = VehicleFactory.createVehicleLexusOrange2003();
        vehicleGreen05 = VehicleFactory.createVehicleBuickGreen2005();
    };

    //Punto 1
    @Test
    @DisplayName("[SUCCESS] Find by color and year")
    void testFindByColorAndYearSuccess(){
        //Arrange
        List<Vehicle> vehicleList = List.of(vehicleGreen05);
        List<VehicleDto> expected = List.of(VehicleFactory.convertToVehicleDto(vehicleGreen05));
        when(vehicleRepository.findVehiclesByYearAndColor("green", 2005)).thenReturn(vehicleList);

        //Act
        List<VehicleDto> result = vehicleService.searchVehiclesByYearAndColor("green", 2005);

        //Assert
        assertAll(
                () -> assertEquals(1, result.size()),
                () -> assertEquals(expected.get(0), result.get(0))
        );
        verify(vehicleRepository).findVehiclesByYearAndColor("green", 2005);
        verifyNoMoreInteractions(vehicleRepository);
    }

    @Test
    @DisplayName("[ERROR] Find by color and year - No se encontraron vehiculos con esos datos")
    void testFindByColorAndYearNotFound(){
        //Arrange
        when(vehicleRepository.findVehiclesByYearAndColor("red", 2004)).thenReturn(Collections.emptyList());

        //Act & Assert
        NotFoundException notFoundException = assertThrows(NotFoundException.class, () ->
                vehicleService.searchVehiclesByYearAndColor("red", 2004)
        );

        assertAll(
                ()-> assertEquals("No se encontraron vehículos con esos criterios."
                        ,notFoundException.getMessage()),
                ()-> assertNotNull(notFoundException)
        );
        verify(vehicleRepository).findVehiclesByYearAndColor("red", 2004);
        verifyNoMoreInteractions(vehicleRepository);
    }

    //Punto 2
    @Test
    @DisplayName("[SUCCESS] Find by brand and range of year")
    void testSearchVehiclesByBrandAndRangeOfYearSuccess(){
        //Arrange
        List<Vehicle> vehicleList = List.of(vehicleGreen05);
        List<VehicleDto> expected = VehicleFactory.convertListVehicleDto(vehicleList);

        when(vehicleRepository.findVehiclesByBrandAndRangeOfYear("Lexus", 2002, 2005))
                .thenReturn(vehicleList);

        //Act
        List<VehicleDto> result = vehicleService.searchVehiclesByBrandAndRangeOfYear(
                "Lexus", 2002, 2005);

        //Assert
        assertAll(
                () -> assertEquals(expected.size(), result.size()),
                () -> assertEquals(expected.get(0), result.get(0))
        );
        verify(vehicleRepository).findVehiclesByBrandAndRangeOfYear("Lexus", 2002, 2005);
        verifyNoMoreInteractions(vehicleRepository);
    }

    @Test
    @DisplayName("[ERROR] Find by brand and range of year - No hay vehiculos con esos datos")
    void testSearchVehiclesByBrandAndRangeOfYearNotFound(){
        //Arrange
        when(vehicleRepository.findVehiclesByBrandAndRangeOfYear("Ford", 2002, 2005))
                .thenReturn(Collections.emptyList());

        //Act && Assert
        NotFoundException exception = assertThrows( NotFoundException.class, ()->
                vehicleService.searchVehiclesByBrandAndRangeOfYear("Ford", 2002, 2005)
        );

        assertAll(
                () -> assertNotNull(exception),
                () -> assertEquals("No se encontraron vehículos con esos criterios.",exception.getMessage())
        );

        verify(vehicleRepository).findVehiclesByBrandAndRangeOfYear("Ford", 2002, 2005);
        verifyNoMoreInteractions(vehicleRepository);
    }

    //Punto 3
    @Test
    @DisplayName("[SUCCESS] Calculate Avgerage Speed By Brand")
    void testCalculateAvgSpeedByBrandSuccess(){
        //Arrange
        List<Vehicle> vehicleList = List.of(vehicleOrange03, vehicleYellow09);
        when(vehicleRepository.findVehiclesByBrand("Lexus")).thenReturn(vehicleList);

        Double maxSpeed1 = Double.valueOf(vehicleOrange03.getMax_speed());
        Double maxSpeed2 = Double.valueOf(vehicleYellow09.getMax_speed());
        Double average = (maxSpeed1 + maxSpeed2) / 2;

        VehicleAvgSpeedByBrandDto expected = new VehicleAvgSpeedByBrandDto(average);

        //Act
        VehicleAvgSpeedByBrandDto result = vehicleService.calculateAvgSpeedByBrand("Lexus");

        //Assert
        assertAll(
                () -> assertNotNull(result),
                () -> assertEquals(expected.getAverage(), result.getAverage())
        );
        verify(vehicleRepository).findVehiclesByBrand("Lexus");
        verifyNoMoreInteractions(vehicleRepository);
    }

    @Test
    @DisplayName("[ERROR] Calculate Avgerage Speed By Brand - No se encontraron vehiculos")
    void testCalculateAvgSpeedByBrandNotFound(){
        //Arrange
        when(vehicleRepository.findVehiclesByBrand("Ford")).thenReturn(Collections.emptyList());

        //Act & Assert
        NotFoundException exception = assertThrows(NotFoundException.class, ()->
                vehicleService.calculateAvgSpeedByBrand("Ford")
        );

        assertAll(
                ()-> assertNotNull(exception),
                ()-> assertEquals("No se encontraron vehículos de esa marca.", exception.getMessage())
        );

        verify(vehicleRepository).findVehiclesByBrand("Ford");
        verifyNoMoreInteractions(vehicleRepository);
    }

    //Punto 4
    @Test
    @DisplayName("[SUCCESS] Find capacity by brand")
    void testCalculateAvgCapacityByBrandSuccess(){
        //Arrange
        List<Vehicle> vehicleList = List.of(vehicleOrange03, vehicleYellow09);
        when(vehicleRepository.findVehiclesByBrand("Lexus")).thenReturn(vehicleList);

        double capacity1 = vehicleOrange03.getPassengers();
        double capacity2 = vehicleYellow09.getPassengers();
        double average = (capacity1 + capacity2) /2;

        VehicleAvgCapacityByBrandDto expected = new VehicleAvgCapacityByBrandDto(average);

        //Act
        VehicleAvgCapacityByBrandDto result = vehicleService.calculateAvgCapacityByBrand("Lexus");

        //Assert
        assertAll(
                () -> assertNotNull(result),
                () -> assertEquals(expected.getAverage(), result.getAverage())
        );

        verify(vehicleRepository).findVehiclesByBrand("Lexus");
        verifyNoMoreInteractions(vehicleRepository);
    }

    @Test
    @DisplayName("[ERROR] Find capacity by brand - No Vehicles found")
    void testCalculateAvgCapacityByBrandNotFound(){
        //Arrange
        when(vehicleRepository.findVehiclesByBrand("Ford")).thenReturn(Collections.emptyList());

        //Act & Assert
        NotFoundException exception = assertThrows(NotFoundException.class, ()->
                    vehicleService.calculateAvgCapacityByBrand("Ford")
                );

        assertAll(
                () -> assertNotNull(exception),
                () -> assertEquals("No se encontraron vehículos de esa marca.", exception.getMessage())
        );
        verify(vehicleRepository).findVehiclesByBrand("Ford");
        verifyNoMoreInteractions(vehicleRepository);
    }

    //Punto 5
    @Test
    @DisplayName("[SUCCESS] Find by weight range")
    void testSearchVehiclesByRangeOfWeightSuccess(){
        //Arrange
        List<Vehicle> vehicleList = List.of(vehicleOrange03);
        when(vehicleRepository.findVehiclesByRangeOfWeight(160, 170)).thenReturn(vehicleList);

        List<VehicleDto> expected = VehicleFactory.convertListVehicleDto(vehicleList);

        //Act
        List<VehicleDto> result = vehicleService.searchVehiclesByRangeOfWeight(160, 170);

        //Assert
        assertAll(
                () -> assertEquals(expected.get(0), result.get(0)),
                () -> assertEquals(expected.size(), result.size())
        );

        verify(vehicleRepository).findVehiclesByRangeOfWeight(160, 170);
        verifyNoMoreInteractions(vehicleRepository);
    }

    @Test
    @DisplayName("[ERROR] Find by weight range - No vehicles found")
    void testSearchVehiclesByRangeOfWeightNotFound(){
        //Arrange
        when(vehicleRepository.findVehiclesByRangeOfWeight(160, 162))
                .thenReturn(Collections.emptyList());

        //Act & Assert
        NotFoundException exception = assertThrows(NotFoundException.class, ()->
                    vehicleService.searchVehiclesByRangeOfWeight(160, 162)
                );

        assertAll(
                ()-> assertNotNull(exception),
                ()-> assertEquals("No se encontraron vehículos en ese rango de peso.", exception.getMessage())
        );

        verify(vehicleRepository).findVehiclesByRangeOfWeight(160, 162);
        verifyNoMoreInteractions(vehicleRepository);
    }

}
