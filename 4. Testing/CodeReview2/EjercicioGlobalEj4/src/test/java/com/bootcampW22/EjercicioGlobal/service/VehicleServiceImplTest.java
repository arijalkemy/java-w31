package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgCapacityByBrandDto;
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
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class VehicleServiceImplTest {

    @Mock
    IVehicleRepository vehicleRepository;

    @InjectMocks
    VehicleServiceImpl vehicleService;

    private String brand;

    @BeforeEach
    void setUp() {
        brand = "Subaru";
    }

    @Test
    public void testCalculateAverageCapacityByBrand(){
        List<Vehicle> vehicleListParam = VehicleUtil.vehicleListByBrand(brand);
        Double expectedCapacity = 3.00;
        VehicleAvgCapacityByBrandDto expectedCapacityDto = new VehicleAvgCapacityByBrandDto(expectedCapacity);

        when(vehicleRepository.findVehiclesByBrand(brand)).thenReturn(vehicleListParam);
        VehicleAvgCapacityByBrandDto capacity = vehicleService.calculateAvgCapacityByBrand(brand);

        assertEquals(expectedCapacityDto, capacity);
    }

    @Test
    public void testBrandNotFound(){
        List<Vehicle> emptyList = new ArrayList<>();
        String invalidBrand = "Test";
        String expectedMessage = "No se encontraron vehículos de esa marca.";

        when(vehicleRepository.findVehiclesByBrand(invalidBrand)).thenReturn(emptyList);

        Exception thrown = assertThrows(NotFoundException.class,
                () -> vehicleService.calculateAvgCapacityByBrand(invalidBrand));
        assertEquals(expectedMessage, thrown.getMessage());

    }
}