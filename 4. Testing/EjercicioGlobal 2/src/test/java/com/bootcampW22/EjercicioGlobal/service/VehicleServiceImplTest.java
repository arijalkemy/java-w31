package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgCapacityByBrandDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgSpeedByBrandDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.lang.invoke.VarHandle;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class VehicleServiceImplTest {
    @Mock
    private IVehicleRepository vehicleRepository;

    @InjectMocks
    private VehicleServiceImpl vehicleService;


    @ParameterizedTest
    @CsvSource({
            "red, 2020, 1",
            "blue, 2015, 0"
    })
    void searchVehiclesByYearAndColor(String color, int year, int expectedSize) {
        // Arrange
        Vehicle vehicle = new Vehicle();
        vehicle.setColor(color);
        vehicle.setYear(year);

        if (expectedSize > 0) {
            when(vehicleRepository.findVehiclesByYearAndColor(color, year))
                    .thenReturn(List.of(vehicle));
        } else {
            when(vehicleRepository.findVehiclesByYearAndColor(color, year))
                    .thenReturn(Collections.emptyList());
        }

        // Act & Assert
        if (expectedSize > 0) {
            List<VehicleDto> result = vehicleService.searchVehiclesByYearAndColor(color, year);
            assertNotNull(result);
            assertEquals(expectedSize, result.size());
            assertEquals(color, result.get(0).getColor());
        } else {
            NotFoundException exception = assertThrows(NotFoundException.class, () ->
                    vehicleService.searchVehiclesByYearAndColor(color, year));
            assertEquals("No se encontraron vehículos con esos criterios.", exception.getMessage());
        }

        verify(vehicleRepository, times(1)).findVehiclesByYearAndColor(color, year);
    }

    @ParameterizedTest
    @CsvSource({
            "chevrolet, 2000, 2010, 1",
            "logan, 1890, 1891, 0"
    })
    void testVehiclesByBrandAndRangeOfYear(String brand, int start_year, int end_year, int expectedSize) {
        Vehicle vehicle = new Vehicle();
        vehicle.setBrand("chevrolet");
        vehicle.setYear(2005);

        if (expectedSize > 0) {
            when(vehicleRepository.findVehiclesByBrandAndRangeOfYear(brand, start_year, end_year))
                    .thenReturn(List.of(vehicle));
        } else {
            when(vehicleRepository.findVehiclesByBrandAndRangeOfYear(brand, start_year, end_year))
                    .thenReturn(Collections.emptyList());
        }

        if (expectedSize > 0) {
            List<VehicleDto> result = vehicleService.searchVehiclesByBrandAndRangeOfYear(brand, start_year, end_year);
            assertNotNull(result);
            assertEquals(brand, result.get(0).getBrand());
            assertEquals(2005, result.get(0).getYear());
        } else {
            NotFoundException exception = assertThrows(NotFoundException.class, () ->
                    vehicleService.searchVehiclesByBrandAndRangeOfYear(brand, start_year, end_year));
            assertEquals("No se encontraron vehículos con esos criterios.", exception.getMessage());
        }
        verify(vehicleRepository, times(1)).findVehiclesByBrandAndRangeOfYear(brand, start_year, end_year);
    }

    @ParameterizedTest
    @CsvSource({
        "chevrolet,1",
            "logan,0"
    })

    void averageSpeedForBrandTest(String brand, int expectedSize){
        Vehicle vehicle = new Vehicle();
        vehicle.setBrand(brand);
        vehicle.setMax_speed("300");

        if(expectedSize > 0){
            when(vehicleRepository.findVehiclesByBrand(brand))
                    .thenReturn(List.of(vehicle));
        }else {
            when(vehicleRepository.findVehiclesByBrand(brand))
                    .thenReturn(Collections.emptyList());
        }

        if(expectedSize > 0){
            VehicleAvgSpeedByBrandDto result =  vehicleService.calculateAvgSpeedByBrand(brand);
            assertNotNull(result);
            assertEquals(300, result.getAverage_speed());
        } else {
            NotFoundException exception = assertThrows(NotFoundException.class, () ->
                    vehicleService.calculateAvgSpeedByBrand(brand));
            assertEquals("No se encontraron vehículos de esa marca.", exception.getMessage());
        }
    }

    @ParameterizedTest
    @CsvSource({
            "chevrolet, 1",
            "logan, 0"
    })
    void getAverageCapacityByBrand(String brand, int expectedSize){
        Vehicle vehicle = new Vehicle();
        vehicle.setBrand(brand);
        vehicle.setPassengers(5);

        if(expectedSize > 0){
            when(vehicleRepository.findVehiclesByBrand(brand))
                    .thenReturn(List.of(vehicle));
        } else {
            when(vehicleRepository.findVehiclesByBrand(brand))
                    .thenReturn(Collections.emptyList());
        }

        if (expectedSize > 0){
            VehicleAvgCapacityByBrandDto result = vehicleService.calculateAvgCapacityByBrand(brand);
            assertNotNull(result);
            assertEquals(5, result.getAverage_capacity());
        } else {
            NotFoundException exception = assertThrows(NotFoundException.class, () ->
                    vehicleService.calculateAvgCapacityByBrand(brand));
            assertEquals("No se encontraron vehículos de esa marca.", exception.getMessage());
        }
    }

    @ParameterizedTest
    @CsvSource({
            "200, 210, 1",
            "500, 600, 0"
    })
    void vehiclesByRangeOfWeightTest(double weight_min, double weight_max, int expectedSize ){
        Vehicle vehicle = new Vehicle();
        vehicle.setWeight(210);

        if(expectedSize > 0){
            when(vehicleRepository.findVehiclesByRangeOfWeight(weight_min, weight_max))
                    .thenReturn(List.of(vehicle));
        } else {
            when(vehicleRepository.findVehiclesByRangeOfWeight(weight_min, weight_max))
                    .thenReturn(Collections.emptyList());
        }

        if (expectedSize > 0){
            List<VehicleDto> result = vehicleService.searchVehiclesByRangeOfWeight(weight_min, weight_max);
            assertNotNull(result);
            assertEquals(210.0, result.get(0).getWeight());
        } else {
            NotFoundException exception = assertThrows(NotFoundException.class, ()->
                    vehicleService.searchVehiclesByRangeOfWeight(weight_min, weight_max));
            assertEquals("No se encontraron vehículos en ese rango de peso.", exception.getMessage());
        }
    }



















}
