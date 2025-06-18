package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.utils.VehicleUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VehicleRepositoryImplTest {

    @Autowired
    VehicleRepositoryImpl vehicleRepository;

    private Double minWeight;
    private Double maxWeight;

    @BeforeEach
    void setUp() {
        minWeight = 150.8;
        maxWeight = 250.5;
    }

    @Test
    public void testFindVehiclesByRangeOfWeight(){
        List<Vehicle> expectedList = VehicleUtil.vehicleListByRangeOfWeight(minWeight, maxWeight);
        List<Vehicle> vehicleList = vehicleRepository.findVehiclesByRangeOfWeight(minWeight,maxWeight);

        assertEquals(expectedList, vehicleList);
    }

    @Test
    public void testEmptyListRangeOfWeightNotFound(){
        Double invalidMaxWeight = -150.5;
        List<Vehicle> expectedList = VehicleUtil.vehicleListByRangeOfWeight(minWeight, invalidMaxWeight);

        assertEquals(expectedList, List.of());
    }






}