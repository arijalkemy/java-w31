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
    public void testCalculate() {
        // Arrange
        HouseDTO house = new HouseDTO("House Blue", "CL 200 # 5", List.of(
                new RoomDTO("Main", 8, 8),
                new RoomDTO("Hall", 5, 5)
        ));
        String expectedName = "House Blue";
        String expectedAddress = "CL 200 # 5";
        int expectedRoomCount = 2;
        int expectedSquareFeet = 8 * 8 + 5 * 5; // 64 + 25 = 89
        int expectedPrice = expectedSquareFeet * 800;
        String expectedBiggestRoom = "Main";

        // Act
        HouseResponseDTO responseDTO = calculateService.calculate(house);

        // Assert
        assertEquals(expectedName, responseDTO.getName());
        assertEquals(expectedAddress, responseDTO.getAddress());
        assertEquals(expectedRoomCount, responseDTO.getRooms().size());
        assertEquals(expectedSquareFeet, responseDTO.getSquareFeet());
        assertEquals(expectedPrice, responseDTO.getPrice());
        assertEquals(expectedBiggestRoom, responseDTO.getBiggest().getName());
    }

    @Test
    public void testCalculateWithNoRooms() {
        // Arrange
        HouseDTO house = new HouseDTO("House Blue", "CL 200 # 5", List.of());
        String expectedName = "House Blue";
        String expectedAddress = "CL 200 # 5";
        int expectedRoomCount = 0;
        int expectedSquareFeet = 0;
        int expectedPrice = 0;

        // Act
        HouseResponseDTO responseDTO = calculateService.calculate(house);

        // Assert
        assertEquals(expectedName, responseDTO.getName());
        assertEquals(expectedAddress, responseDTO.getAddress());
        assertEquals(expectedRoomCount, responseDTO.getRooms().size());
        assertEquals(expectedSquareFeet, responseDTO.getSquareFeet());
        assertEquals(expectedPrice, responseDTO.getPrice());
        assertNull(responseDTO.getBiggest());
    }

    @Test
    public void testCalculateWithSameSizeRooms() {
        // Arrange
        RoomDTO room1 = new RoomDTO("Room A", 5, 5); // 25 sqft
        RoomDTO room2 = new RoomDTO("Room B", 5, 5); // 25 sqft
        HouseDTO house = new HouseDTO("Twin House", "CL 111 # 11", List.of(room1, room2));
        int expectedSquareFeet = (5 * 5) + (5 * 5); // 25 + 25 = 50
        int expectedPrice = expectedSquareFeet * 800;
        String expectedBiggestRoom = "Room A"; // el primero en orden

        // Act
        HouseResponseDTO responseDTO = calculateService.calculate(house);

        // Assert
        assertEquals(expectedSquareFeet, responseDTO.getSquareFeet());
        assertEquals(expectedPrice, responseDTO.getPrice());
        assertEquals(expectedBiggestRoom, responseDTO.getBiggest().getName());
    }

    @Test
    public void testPriceCalculation() {
        // Arrange
        RoomDTO room = new RoomDTO("Living Room", 10, 10); // 100 sqft
        HouseDTO house = new HouseDTO("Luxury House", "CL 500 # 50", List.of(room));
        int expectedSquareFeet = 10 * 10; // 100
        int expectedPrice = expectedSquareFeet * 800;

        // Act
        HouseResponseDTO responseDTO = calculateService.calculate(house);

        // Assert
        assertEquals(expectedSquareFeet, responseDTO.getSquareFeet());
        assertEquals(expectedPrice, responseDTO.getPrice());
    }
}
