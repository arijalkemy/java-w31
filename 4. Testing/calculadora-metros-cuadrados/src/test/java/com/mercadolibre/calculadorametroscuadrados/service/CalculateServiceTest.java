package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
public class CalculateServiceTest {

    @Autowired
    private CalculateService calculateService;

    @Test
    public void testCalculate(){
        // Arrange
        HouseDTO house = new HouseDTO("House Blue", "CL 200 # 5", List.of( new RoomDTO("Main", 8,8), new RoomDTO("Hall", 5, 5)));
        // Act
        HouseResponseDTO responseDTO = calculateService.calculate(house);
        // Assert
        assertEquals("House Blue", responseDTO.getName());
        assertEquals("CL 200 # 5", responseDTO.getAddress());
        assertEquals(2, responseDTO.getRooms().size());
        assertEquals(89, responseDTO.getSquareFeet());
        assertEquals(71200, responseDTO.getPrice());
        assertEquals("Main", responseDTO.getBiggest().getName());
    }

    @Test
    public void testCalculateWithNoRooms(){
        // Arrange
        HouseDTO house = new HouseDTO("House Blue", "CL 200 # 5", List.of( ));
        // Act
        HouseResponseDTO responseDTO = calculateService.calculate(house);
        // Arrange
        assertEquals("House Blue", responseDTO.getName());
        assertEquals("CL 200 # 5", responseDTO.getAddress());
        assertEquals(0, responseDTO.getRooms().size());
        assertEquals(0, responseDTO.getSquareFeet());
        assertEquals(0, responseDTO.getPrice());
        assertNull(responseDTO.getBiggest());
    }

    @Test
    public void testCalculateWithSameSizeRooms(){
        // Arrange
        RoomDTO room1 = new RoomDTO("Room A", 5, 5); // 25 sqft
        RoomDTO room2 = new RoomDTO("Room B", 5, 5); // 25 sqft
        HouseDTO house = new HouseDTO("Twin House", "CL 111 # 11", List.of(room1, room2));
        // Act
        HouseResponseDTO responseDTO = calculateService.calculate(house);
        // Assert
        assertEquals(50, responseDTO.getSquareFeet());
        assertEquals(40000, responseDTO.getPrice());
        assertEquals("Room A", responseDTO.getBiggest().getName());
    }

    @Test
    public void testPriceCalculation(){
        // Arrange
        HouseDTO house = new HouseDTO("Luxury House", "CL 500 # 50", List.of(
                new RoomDTO("Living Room", 10, 10) // 100 sqft
        ));
        // Act
        HouseResponseDTO responseDTO = calculateService.calculate(house);
        // Assert
        assertEquals(100, responseDTO.getSquareFeet());
        assertEquals(80000, responseDTO.getPrice());
    }

}
