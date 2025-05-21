package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgCapacityByBrandDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgSpeedByBrandDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.bootcampW22.EjercicioGlobal.utils.CustomFactory.getListVehicle;
import static com.bootcampW22.EjercicioGlobal.utils.CustomFactory.getListVehicleEqualYear;
import static com.bootcampW22.EjercicioGlobal.utils.Mapper.listToListDto;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestVehicleService {

    @Mock
    IVehicleRepository repository;

    @InjectMocks
    VehicleServiceImpl service;

    @Test
    @DisplayName("Search All Vehicles Happy Path")
    void testsearchAllVehiclesHappyPath(){
        //Arrange
        when(repository.findAll()).thenReturn(getListVehicle());
        List<VehicleDto> expectedList = listToListDto(getListVehicle());
        //Act
        List<VehicleDto> result = service.searchAllVehicles();

        //Assert
        assertEquals(expectedList,result);
        assertEquals(expectedList.size(),result.size());
        assertFalse(result.isEmpty());
        assertTrue(expectedList.get(0).getModel().equals(result.get(0).getModel()));
    }

    @Test
    @DisplayName("Search All Vehicles Sad Path")
    void testsearchAllVehiclesSadPath(){
        //Arrange
        when(repository.findAll()).thenReturn(Collections.emptyList());

        //Act & Assert
        assertThrows(NotFoundException.class,() -> service.searchAllVehicles(),"No se encontró ningun auto en el sistema.");
    }

    @Test
    void testsearchVehiclesByYearAndColorHappyPath(){
        //Arrange
        String color = "Azul";
        int year = 2018;
        when(repository.findVehiclesByYearAndColor(color,year)).thenReturn(getListVehicleEqualYear());
        List<VehicleDto> expectedList = listToListDto(getListVehicleEqualYear());

        //Act
        List<VehicleDto> result = service.searchVehiclesByYearAndColor(color,year);

        System.out.println(result);

        //Assert
        assertEquals(expectedList.size(),result.size());
        assertFalse(result.isEmpty());
        assertTrue(expectedList.get(0).getId().equals(result.get(0).getId()));
        assertTrue(result.stream().allMatch(a-> a.getColor().equalsIgnoreCase(color) &&
                a.getYear() == year));
    }
    @Test
    void testsearchVehiclesByYearAndColorSadPath(){
        //Arrange
        String color = "Azul";
        int year = 1994;
        when(repository.findVehiclesByYearAndColor(color,year)).thenReturn(Collections.emptyList());

        //Act & Assert
        assertThrows(NotFoundException.class,()->service.searchVehiclesByYearAndColor(color,year),
                "No se encontraron vehículos con esos criterios.");
    }

    @Test
    void testsearchVehiclesByBrandAndRangeOfYearHappyPath(){
        //Arrange
        String brand = "Ford";
        int start_year = 2015, end_year = 2025;

        when(repository.findVehiclesByBrandAndRangeOfYear(brand,start_year,end_year)).thenReturn(getListVehicle());
        List<VehicleDto> expectedList = listToListDto(getListVehicle());

        //Act
        List<VehicleDto> result = service.searchVehiclesByBrandAndRangeOfYear(brand,start_year,end_year);

        //Assert
        assertFalse(result.isEmpty());
        assertEquals(expectedList.size(),result.size());
        assertTrue(expectedList.get(0).getBrand().equals(result.get(0).getBrand()));
        assertTrue(result.stream().allMatch(a-> a.getBrand().equalsIgnoreCase(brand) &&
                a.getYear()> start_year && a.getYear()< end_year));
    }

    @Test
    void testsearchVehiclesByBrandAndRangeOfYearSadPath(){
        //Arrange
        String brand = "Ford";
        int start_year = 2015, end_year = 2025;

        when(repository.findVehiclesByBrandAndRangeOfYear(brand,start_year,end_year)).thenReturn(Collections.emptyList());
        List<VehicleDto> expectedList = listToListDto(getListVehicle());
        //Act & Assert
        assertThrows(NotFoundException.class,()-> service.searchVehiclesByBrandAndRangeOfYear(brand,start_year,end_year),"No se encontraron vehículos con esos criterios.");
    }
    @Test
    void testCalculateAvgSpeedByBrandHappyPath(){
        //Arrange
        String brand = "Ford";
        when(repository.findVehiclesByBrand(brand)).thenReturn(getListVehicle());
        VehicleAvgSpeedByBrandDto expected = new VehicleAvgSpeedByBrandDto(85D);
        //Act
        VehicleAvgSpeedByBrandDto result = service.calculateAvgSpeedByBrand(brand);

        //Assert
        assertEquals(expected.getAverage_speed(),result.getAverage_speed());
    }
    @Test
    void testCalculateAvgSpeedByBrandSadPath(){
        //Arrange
        String brand = "Ford";
        when(repository.findVehiclesByBrand(brand)).thenReturn(Collections.emptyList());

        //Act & Assert
        assertThrows(NotFoundException.class,()-> service.calculateAvgSpeedByBrand(brand),"No se encontraron vehículos de esa marca.");
    }
    @Test
    void testCalculateAvgCapacityByBrandHappyPath(){
        //Arrange
        String brand = "Ford";
        when(repository.findVehiclesByBrand(brand)).thenReturn(getListVehicle());
        VehicleAvgCapacityByBrandDto expected = new VehicleAvgCapacityByBrandDto(2D);
        //Act
        VehicleAvgCapacityByBrandDto result = service.calculateAvgCapacityByBrand(brand);

        //Assert
        assertEquals(expected.getAverage_capacity(),result.getAverage_capacity());
    }
    @Test
    void testCalculateAvgCapacityByBrandSadPath(){
        //Arrange
        String brand = "Ford";
        when(repository.findVehiclesByBrand(brand)).thenReturn(Collections.emptyList());

        //Act & Assert
        assertThrows(NotFoundException.class,()-> service.calculateAvgCapacityByBrand(brand),"No se encontraron vehículos de esa marca.");
    }

    @Test
    void testSearchVehiclesByRangeOfWeightHappyPath(){
        //Arrange
        double weight_min = 1000, weight_max = 2000;
        when(repository.findVehiclesByRangeOfWeight(weight_min,weight_max)).thenReturn(getListVehicle());
        List<VehicleDto> expectedList = listToListDto(getListVehicle());
        //Act
        List<VehicleDto> result = service.searchVehiclesByRangeOfWeight(weight_min,weight_max);

        //Assert
        assertEquals(expectedList,result);
        assertFalse(result.isEmpty());
        assertEquals(expectedList.size(),result.size());
        assertTrue(result.stream()
                .allMatch(a-> a.getWeight()>weight_min && a.getWeight()<weight_max));
    }

    @Test
    void testSearchVehiclesByRangeOfWeightSadPath(){
        //Arrange
        double weight_min = 1000, weight_max = 2000;
        when(repository.findVehiclesByRangeOfWeight(weight_min,weight_max)).thenReturn(Collections.emptyList());
        //Act & Assert
        assertThrows(NotFoundException.class,()-> service.searchVehiclesByRangeOfWeight(weight_min,weight_max),"No se encontraron vehículos en ese rango de peso.");
    }
}
