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
    private IVehicleRepository vehicleRepository;

    private String brand;
    private Integer startYear;
    private Integer endYear;


    @BeforeEach
    public void setUp() throws IOException {
        vehicleRepository = new VehicleRepositoryImpl();
        brand = "Subaru";
        startYear = 1990;
        endYear = 2005;
    }

    @DisplayName("Lista de vehiculos desde el repositorio")
    @Test
    public void testFindVehiclesByBrandAndRangeOfYear(){
        List<Vehicle> vehicleListExpected = VehicleUtil.vehicleListBranAndRangeOfYear(brand, startYear, endYear);
        List<Vehicle> vehicleList = vehicleRepository.findVehiclesByBrandAndRangeOfYear(brand, startYear, endYear);

        assertEquals(vehicleListExpected, vehicleList);
    }

    @DisplayName("Si la marca no existe la lista es vacia")
    @Test
    public void testBrandNotFound(){
        String invalidBrand = "test";
        List<Vehicle> vehicleListExpected = VehicleUtil.vehicleListBranAndRangeOfYear(invalidBrand, startYear, endYear);

        assertEquals(vehicleListExpected, List.of());
    }

    @DisplayName("Si el año existe la lista es vacia")
    @Test
    public void testYearNotFound(){
        int invalidYear = 999999;
        List<Vehicle> vehicleListExpected = VehicleUtil.vehicleListBranAndRangeOfYear(brand, invalidYear, endYear);

        assertEquals(vehicleListExpected, List.of());
    }
}