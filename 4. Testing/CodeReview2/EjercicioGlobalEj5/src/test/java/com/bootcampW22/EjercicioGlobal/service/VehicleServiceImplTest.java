package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.utils.VehicleUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class VehicleServiceImplTest {

    @Mock
    IVehicleRepository vehicleRepository;

    @InjectMocks
    VehicleServiceImpl vehicleService;

    private Double minWeight;
    private Double maxWeight;


    @BeforeEach
    void setUp() {
        minWeight = 100.5;
        maxWeight = 200.8;
    }

    @Test
    public void testVechiclesByRangeOfWeight(){
        List<Vehicle> vehicleListParam = VehicleUtil.vehicleListByRangeOfWeight(minWeight, maxWeight);
        List<VehicleDto> vehicleDtoListExpected = vehicleListParam.stream()
                .map(VehicleUtil::entitytoDto)
                .toList();

        when(vehicleRepository.findVehiclesByRangeOfWeight(minWeight, maxWeight)).thenReturn(vehicleListParam);
        List<VehicleDto> vehicleDtoList = vehicleService.searchVehiclesByRangeOfWeight(minWeight, maxWeight);

        assertEquals(vehicleDtoListExpected, vehicleDtoList);

    }

    @Test
    public void testMinWeightNotFound(){
        double invalidMinWeight = -15.00;
        String expectedMessage = "No se encontraron vehículos en ese rango de peso.";
        when(vehicleRepository.findVehiclesByRangeOfWeight(invalidMinWeight, maxWeight)).thenReturn(List.of());

        Exception thrown = assertThrows(NotFoundException.class,
                () -> vehicleService.searchVehiclesByRangeOfWeight(invalidMinWeight, maxWeight));
        assertEquals(expectedMessage, thrown.getMessage());
    }

    @Test
    public void testMaxWeightNotFound(){
        double invalidMaxWeight = -15.00;
        String expectedMessage = "No se encontraron vehículos en ese rango de peso.";
        when(vehicleRepository.findVehiclesByRangeOfWeight(minWeight, invalidMaxWeight)).thenReturn(List.of());

        Exception thrown = assertThrows(NotFoundException.class,
                () -> vehicleService.searchVehiclesByRangeOfWeight(minWeight, invalidMaxWeight));
        assertEquals(expectedMessage, thrown.getMessage());
    }

}