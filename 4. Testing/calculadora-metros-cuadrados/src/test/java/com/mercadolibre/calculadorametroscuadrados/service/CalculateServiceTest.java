package com.mercadolibre.calculadorametroscuadrados.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

public class CalculateServiceTest {

    private CalculateService calculateService;

    private HouseDTO houseDTO;
    private List<RoomDTO> rooms;
    private RoomDTO room1;
    private RoomDTO room2;

    @BeforeEach
    void setUp() {
        calculateService = new CalculateService();

        room1 = new RoomDTO();
        room1.setName("room1");
        room1.setLength(4);
        room1.setWidth(5);
        room2 = new RoomDTO();
        room2.setName("room2");
        room2.setLength(3);
        room2.setWidth(6);
        rooms = List.of(room1, room2);

        houseDTO = new HouseDTO();
        houseDTO.setName("MyHouse");
        houseDTO.setAddress("St1");
        houseDTO.setRooms(rooms);
    }

    @Test
    void testCalculate() {
        // Arrange
        HouseResponseDTO expectedResponse = new HouseResponseDTO(houseDTO);
        expectedResponse.setBiggest(room1);
        expectedResponse.setSquareFeet(38);
        expectedResponse.setPrice(38 * 800);

        // Act
        HouseResponseDTO result = calculateService.calculate(houseDTO);

        // Assert
        assertEquals(expectedResponse.getAddress(), result.getAddress());
        assertEquals(expectedResponse.getBiggest(), result.getBiggest());
        assertEquals(expectedResponse.getName(), result.getName());
        assertEquals(expectedResponse.getRooms(), result.getRooms());
        assertEquals(expectedResponse.getSquareFeet(), result.getSquareFeet());
        assertEquals(expectedResponse.getPrice(), result.getPrice());
    }

    @Test
    void testCalculateAddRoom() {
        // Arrange
        RoomDTO room3 = new RoomDTO();
        room3.setLength(10);
        room3.setName("room3");
        room3.setWidth(5);
        rooms = List.of(room1, room2, room3);
        houseDTO.setRooms(rooms);

        HouseResponseDTO expectedResponse = new HouseResponseDTO(houseDTO);
        expectedResponse.setBiggest(room3);
        expectedResponse.setSquareFeet(88);
        expectedResponse.setPrice(88 * 800);

        // Act
        HouseResponseDTO result = calculateService.calculate(houseDTO);

        // Assert
        assertEquals(expectedResponse.getAddress(), result.getAddress());
        assertEquals(expectedResponse.getBiggest(), result.getBiggest());
        assertEquals(expectedResponse.getName(), result.getName());
        assertEquals(expectedResponse.getRooms(), result.getRooms());
        assertEquals(expectedResponse.getSquareFeet(), result.getSquareFeet());
        assertEquals(expectedResponse.getPrice(), result.getPrice());
    }
}
