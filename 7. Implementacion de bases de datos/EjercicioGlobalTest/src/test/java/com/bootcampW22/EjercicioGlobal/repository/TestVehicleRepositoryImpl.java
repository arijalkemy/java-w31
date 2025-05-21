package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestVehicleRepositoryImpl {
    VehicleRepositoryImpl repository;

    @BeforeEach
    void sepUp() throws Exception{
        repository = new VehicleRepositoryImpl();
    }

    @Test
    void testFindAll(){
        //Arrange

        //Act
        List<Vehicle> result = repository.findAll();

        //Assert
        assertFalse(result.isEmpty());
    }

    @Test
    void testFindVehiclesByYearAndColor(){
        //Arrange
        String color = "Mauv";
        int year = 1986;

        //Act
        List<Vehicle> result = repository.findVehiclesByYearAndColor(color,year);

        //Assert
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertTrue(result.stream().allMatch(v ->
                v.getColor().equalsIgnoreCase("Mauv") && v.getYear() == 1986));
    }

    @Test
    void testFindVehiclesByBrandAndRangeOfYear(){
        //Arrange
        String brand = "Pontiac";
        int start_year = 1900, end_year = 2025;

        //Act
        List<Vehicle> result = repository.findVehiclesByBrandAndRangeOfYear(brand,start_year,end_year);

        //Assert
        assertFalse(result.isEmpty());
        assertNotNull(result);
        assertTrue(result.stream()
                .allMatch(a-> a.getBrand().equalsIgnoreCase(brand) &&
                        a.getYear()> start_year &&
                        a.getYear()< end_year));
    }

    //    public List<Vehicle> findVehiclesByBrand(String brand) {
    @Test
    void testFindVehiclesByBrand(){
        //Arrange
        String brand = "Pontiac";

        //Act
        List<Vehicle> result = repository.findVehiclesByBrand(brand);

        //Asseert
        assertFalse(result.isEmpty());
        assertNotNull(result);
        assertTrue(result.stream().allMatch(a-> a.getBrand().equalsIgnoreCase(brand)));
    }

    //public List<Vehicle> findVehiclesByRangeOfWeight(double weight_min, double weight_max) {
    @Test
    void testFindVehiclesByRangeOfWeight(){
        //Arrange
        double weight_min = 100, weight_max = 500;

        //Act
        List<Vehicle> result = repository.findVehiclesByRangeOfWeight(weight_min,weight_max);

        //Assert
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertTrue(result.stream().allMatch(a->a.getWeight()>weight_min &&
                a.getWeight()< weight_max));
    }

}
