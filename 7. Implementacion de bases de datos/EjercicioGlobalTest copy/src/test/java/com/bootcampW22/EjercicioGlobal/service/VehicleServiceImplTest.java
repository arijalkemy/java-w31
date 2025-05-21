package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static com.bootcampW22.EjercicioGlobal.utils.CustomFactory.getListVehicle;
import static com.bootcampW22.EjercicioGlobal.utils.Mapper.listToListDto;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VehicleServiceImplTest {

    @Mock
    IVehicleRepository repository;

    @InjectMocks
    VehicleServiceImpl service;

    @Test
    void testSearchVehiclesByBrandAndRangeOfYearHappyPath(){
        //Arrange
        String brand = "Ford";
        int start_year = 1900, end_year = 2025;
        List<Vehicle> vehicleList = getListVehicle();

        when(repository.findVehiclesByBrandAndRangeOfYear(brand,start_year,end_year)).thenReturn(vehicleList);
        List<VehicleDto> expected = listToListDto(vehicleList);

        //Act
        List<VehicleDto> result = service.searchVehiclesByBrandAndRangeOfYear(brand,start_year,end_year);

        //Assert
        assertFalse(result.isEmpty());
        assertNotNull(result);
        assertEquals(expected,result);
        assertEquals(expected.get(0).getBrand(),result.get(0).getBrand());

    }

    @Test
    void testSearchVehiclesByBrandAndRangeOfYearSadPath(){
        //Arrange
        String brand = "Sin marca";
        int start_year = 1900, end_year = 2025;

        when(repository.findVehiclesByBrandAndRangeOfYear(brand,start_year,end_year)).thenReturn(Collections.emptyList());

        //Act & Assert
        assertThrows(NotFoundException.class,()-> service.searchVehiclesByBrandAndRangeOfYear(brand,start_year,end_year),"No se encontraron vehículos con esos criterios.");

    }
}