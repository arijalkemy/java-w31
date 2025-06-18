package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgSpeedByBrandDto;
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
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VehicleServiceImplTest {
    @Mock
    IVehicleRepository vehicleRepository;

    @InjectMocks
    VehicleServiceImpl vehicleService;

    private String brand;
    private Double avgSpeed;

    @BeforeEach
    void setUp() {
        brand = "Subaru";
        avgSpeed = 150.38;
    }

    @DisplayName("Test calcular velocidad promedio por marca")
    @Test
    public void testCalculateAvgSpeedByBrand() {
        List<Vehicle> vehicleListParam = VehicleUtil.vehicleListByBrand(brand);
        VehicleAvgSpeedByBrandDto avgSpeedExpected = new VehicleAvgSpeedByBrandDto(avgSpeed);

        when(vehicleRepository.findVehiclesByBrand(brand)).thenReturn(vehicleListParam);
        VehicleAvgSpeedByBrandDto avgSpeedResult = vehicleService.calculateAvgSpeedByBrand(brand);

        assertEquals(avgSpeedExpected, avgSpeedResult);
        verify(vehicleRepository, times(1)).findVehiclesByBrand(brand);
    }

    @DisplayName("Test calculo de velocidad promedio de una marca no existente")
    @Test
    public void testCalculateAvgSpeedByBrandNotFound(){
        String expectedMessage = "No se encontraron vehículos de esa marca.";

        when(vehicleRepository.findVehiclesByBrand(brand)).thenReturn(List.of());

        Exception thrown = assertThrows(NotFoundException.class,
                () -> vehicleService.calculateAvgSpeedByBrand(brand));
        assertEquals(expectedMessage, thrown.getMessage());

    }
}