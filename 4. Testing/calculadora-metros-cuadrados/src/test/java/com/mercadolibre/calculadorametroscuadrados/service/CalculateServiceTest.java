package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculateServiceTest {
    private final CalculateService calculateService = new CalculateService();

    @Test
    void testCalculateTotalSquareFeet() {
        // Arrange
        RoomDTO room1 = new RoomDTO();
        room1.setName("Living Room");
        room1.setWidth(5);
        room1.setLength(4);

        RoomDTO room2 = new RoomDTO();
        room2.setName("Bedroom");
        room2.setWidth(3);
        room2.setLength(3);

        HouseDTO house = new HouseDTO();
        house.setName("Test House");
        house.setRooms(Arrays.asList(room1, room2));

        // Act
        HouseResponseDTO response = calculateService.calculate(house);

        // Assert
        assertEquals(29, response.getSquareFeet());
        assertEquals(23200, response.getPrice());
        assertEquals("Living Room", response.getBiggest().getName());
    }

    @Test
    void testCalculatePrice() {
        // Arrange
        RoomDTO room = new RoomDTO();
        room.setWidth(5);
        room.setLength(4);

        HouseDTO house = new HouseDTO();
        house.setRooms(Arrays.asList(room));

        // Act
        HouseResponseDTO response = calculateService.calculate(house);

        // Assert
        assertEquals(20, response.getSquareFeet());
        assertEquals(16000, response.getPrice());
    }
}
