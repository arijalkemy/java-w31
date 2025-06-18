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
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class VehicleServiceImplTest {

    @Mock
    IVehicleRepository vehicleRepository;

    @InjectMocks
    private VehicleServiceImpl vehicleService;

    private String brand;
    private int startYear;
    private int endYear;

    @BeforeEach
    void setUp() {
        brand = "Subaru";
        startYear = 1990;
        endYear = 2005;
    }

    @DisplayName("Lista de vehiculos por marca y rango de años")
    @Test
    public void testSearchVehiclesByBrandAndRangeOfYear(){
        List<Vehicle> vehicleListParam = VehicleUtil.vehicleListBranAndRangeOfYear(brand, startYear, endYear);
        List<VehicleDto> vehicleListExpected = VehicleUtil.entitytoDto(vehicleListParam);

        when(vehicleRepository.findVehiclesByBrandAndRangeOfYear(brand, startYear, endYear))
                .thenReturn(vehicleListParam);

        List<VehicleDto> vehicleList = vehicleService.searchVehiclesByBrandAndRangeOfYear(brand, startYear, endYear);
        assertEquals(vehicleListExpected, vehicleList);
        verify(vehicleRepository, times(1))
                .findVehiclesByBrandAndRangeOfYear(brand, startYear, endYear);
    }

    @DisplayName("La marca buscada no existe")
    @Test
    public void testVehicleBrandNotFound(){
        String invalidBrand = "test";
        String expectedMessage = "No se encontraron vehículos con esos criterios.";

        when(vehicleRepository.findVehiclesByBrandAndRangeOfYear(invalidBrand, startYear, endYear))
                .thenReturn(List.of());

        Exception thrown = assertThrows(NotFoundException.class,
                () -> vehicleService.searchVehiclesByBrandAndRangeOfYear(invalidBrand, startYear, endYear));
        assertEquals(expectedMessage, thrown.getMessage());
    }

    @DisplayName("El año buscado no existe")
    @Test
    public void testVehicleNotFound(){
        int invalidYear = 99999;
        String expectedMessage = "No se encontraron vehículos con esos criterios.";

        when(vehicleRepository.findVehiclesByBrandAndRangeOfYear(brand, invalidYear, endYear))
                .thenReturn(List.of());

        Exception thrown = assertThrows(NotFoundException.class,
                () -> vehicleService.searchVehiclesByBrandAndRangeOfYear(brand, invalidYear, endYear));
        assertEquals(expectedMessage, thrown.getMessage());
    }

}