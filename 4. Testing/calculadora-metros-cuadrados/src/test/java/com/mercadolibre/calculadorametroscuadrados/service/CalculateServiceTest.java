package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CalculateServiceTest {

    private CalculateService calculateService;

    @BeforeEach
    public void setup() {
        calculateService = new CalculateService();
    }

    @Test
    public void verifyCalculateValue() {
        // Arrange
        RoomDTO room1 = makeRoom("Cocina", 3, 3);
        RoomDTO room2 = makeRoom("Sala", 5, 4);
        RoomDTO room3 = makeRoom("Baño", 2, 2);
        HouseDTO house = new HouseDTO();
        house.setName("Casa");
        house.setRooms(Arrays.asList(room1, room2, room3));


        // Act
        HouseResponseDTO response = calculateService.calculate(house);

        // Assert
        Assertions.assertEquals(26400, response.getPrice());
        Assertions.assertEquals("Sala", response.getBiggest().getName());
        Assertions.assertEquals(33, response.getSquareFeet());
    }

    private RoomDTO makeRoom(String name, int width, int length){
        RoomDTO room = new RoomDTO();
        room.setName(name);
        room.setWidth(width);
        room.setLength(length);
        return room;
    }
}
