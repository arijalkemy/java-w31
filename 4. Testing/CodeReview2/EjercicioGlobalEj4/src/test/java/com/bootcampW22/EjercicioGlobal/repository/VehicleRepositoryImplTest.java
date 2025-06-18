package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.utils.VehicleUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VehicleRepositoryImplTest {

    VehicleRepositoryImpl vehicleRepository;

    @BeforeEach
    void setUp() throws IOException {
        vehicleRepository = new VehicleRepositoryImpl();
    }

    @Test
    public void testFindAllVehiclesByBrand(){
        String brand = "Subaru";
        List<Vehicle> expectedList = VehicleUtil.vehicleListByBrand(brand);
        List<Vehicle> vehicleList = vehicleRepository.findVehiclesByBrand(brand);

        assertEquals(expectedList, vehicleList);
    }

    @Test
    public void testNotFoundBrand(){
        String brand = "test";
        List<Vehicle> expectedList = new ArrayList<>();
        List<Vehicle> vehicleList = vehicleRepository.findVehiclesByBrand(brand);

        assertEquals(expectedList, vehicleList);
    }
}