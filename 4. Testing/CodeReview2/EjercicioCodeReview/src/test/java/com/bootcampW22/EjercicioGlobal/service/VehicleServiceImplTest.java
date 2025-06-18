package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.utils.VehicleUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VehicleServiceImplTest {
    @Mock
    IVehicleRepository vehicleRepository;
    @InjectMocks
    VehicleServiceImpl vehicleService;

    private Double minWeight;
    private Double maxWeight;


    @BeforeEach
    void setUp() {
        minWeight = 150.5;
        maxWeight = 250.8;
    }

    @Test
    @DisplayName("Test listado de vehiculos por rango de pesos")
    public void testSearchVehiclesByRangeOfWeight(){
        List<Vehicle> vehicleListParam = VehicleUtil.vehicleListByRangeOfWeight(minWeight,maxWeight);
        List<VehicleDto> vehicleDtoListExpected = VehicleUtil.entitytoDto(vehicleListParam);

        when(vehicleRepository.findVehiclesByRangeOfWeight(minWeight,maxWeight)).thenReturn(vehicleListParam);

        List<VehicleDto> vehicleDtoListResult = vehicleService.searchVehiclesByRangeOfWeight(minWeight,maxWeight);
        assertEquals(vehicleDtoListExpected, vehicleDtoListResult);
    }

    @Test
    @DisplayName("Test listado de vehiculos por peso no encontrado")
    public void testSearchVehiclesByRangeOfWeightNotFound(){
        double invalidMinWeight = 9999999.0;
        String expectedMessage = "No se encontraron vehículos en ese rango de peso.";
        when(vehicleRepository.findVehiclesByRangeOfWeight(invalidMinWeight, maxWeight)).thenReturn(List.of());

        Exception thrown = assertThrows(NotFoundException.class,
                () -> vehicleService.searchVehiclesByRangeOfWeight(invalidMinWeight, maxWeight));
        assertEquals(expectedMessage, thrown.getMessage());
    }
}