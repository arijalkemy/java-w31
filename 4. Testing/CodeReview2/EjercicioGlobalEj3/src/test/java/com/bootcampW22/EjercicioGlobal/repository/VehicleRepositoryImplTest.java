package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.utils.VehicleUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VehicleRepositoryImplTest {

    @Autowired
    IVehicleRepository vehicleRepository;

    private String brand;

    @BeforeEach
    void setUp() throws IOException {
        vehicleRepository = new VehicleRepositoryImpl();
        brand = "Subaru";
    }

    @DisplayName("Test list of vehicles by brand")
    @Test
    public void testFindVehicleByBrand(){
        List<Vehicle> vehicleListExpected = VehicleUtil.vehicleListByBrand(brand);
        List<Vehicle> vehicleListResult = vehicleRepository.findVehiclesByBrand(brand);

        assertEquals(vehicleListExpected, vehicleListResult);
    }

    @DisplayName("Test empty list when brand not found")
    @Test
    public void testFindVehicleByBrandNotFound(){
        String invalidBrand = "test";
        List<Vehicle> vehicleListResult = vehicleRepository.findVehiclesByBrand(invalidBrand);

        assertEquals(List.of(), vehicleListResult);
    }
}