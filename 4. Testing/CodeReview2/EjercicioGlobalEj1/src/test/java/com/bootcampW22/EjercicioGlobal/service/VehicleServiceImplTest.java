package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.utils.VehicleUtil;
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
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class VehicleServiceImplTest {
    @Mock
    private IVehicleRepository vehicleRepository;
    @InjectMocks
    private VehicleServiceImpl vehicleService;

    private String color;
    private Integer year;

    @BeforeEach
    void setUp() {
        color = "Green";
        year = 1990;
    }

    @Test
    public void testSearchVehiclesByColorAndYear(){
        List<Vehicle> vehicleListParam = VehicleUtil.vehicleListColorAndYear(color,year);
        List<VehicleDto> vehiclesExpected = vehicleListParam.stream()
                .map(VehicleUtil::entitytoDto)
                .toList();

        when(vehicleRepository.findVehiclesByYearAndColor(color, year)).thenReturn(vehicleListParam);
        List<VehicleDto> vehicles = vehicleService.searchVehiclesByYearAndColor(color,year);

        assertEquals(vehiclesExpected, vehicles);
        verify(vehicleRepository, times(1)).findVehiclesByYearAndColor(color,year);
    }

    @Test
    public void testNotFoundColor(){
        String invalidColor = "test";
        String expectedMessage = "No se encontraron vehículos con esos criterios.";
        List<Vehicle> emptyList = new ArrayList<>();

        when(vehicleRepository.findVehiclesByYearAndColor(invalidColor, year)).thenReturn(emptyList);

        Exception thrown = assertThrows(NotFoundException.class,
                () -> vehicleService.searchVehiclesByYearAndColor(invalidColor, year));
        assertEquals(expectedMessage, thrown.getMessage());
        verify(vehicleRepository, times(1)).findVehiclesByYearAndColor(invalidColor,year);
    }

    @Test
    public void testNotFoundYear(){
        int invalidYear = 99999;
        String expectedMessage = "No se encontraron vehículos con esos criterios.";
        List<Vehicle> emptyList = new ArrayList<>();

        when(vehicleRepository.findVehiclesByYearAndColor(color, invalidYear)).thenReturn(emptyList);

        Exception thrown = assertThrows(NotFoundException.class,
                () -> vehicleService.searchVehiclesByYearAndColor(color, invalidYear));
        assertEquals(expectedMessage, thrown.getMessage());
        verify(vehicleRepository, times(1)).findVehiclesByYearAndColor(color,invalidYear);
    }
}