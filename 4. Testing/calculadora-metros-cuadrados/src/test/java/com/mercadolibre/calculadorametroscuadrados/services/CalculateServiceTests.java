package com.mercadolibre.calculadorametroscuadrados.services;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CalculateServiceTests {
    CalculateService calculateService;
    @BeforeEach
    public void setup() {
        calculateService = new CalculateService();
    }

    @Test
    public void testCalculate() {
        // Arrange
        HouseDTO house = new HouseDTO();
        house.setName("Casa Moderna");
        house.setAddress("Calle Falsa 123");
        List<RoomDTO> rooms = new ArrayList<>();

        RoomDTO room1 = new RoomDTO();
        room1.setName("Sala");
        room1.setWidth(5);
        room1.setLength(4);

        RoomDTO room2 = new RoomDTO();
        room2.setName("Cocina");
        room2.setWidth(3);
        room2.setLength(3);

        rooms.add(room1);
        rooms.add(room2);

        house.setRooms(rooms);
        // Act
        HouseResponseDTO houseResponse = calculateService.calculate(house);
        // Assert
        Assertions.assertEquals(29, houseResponse.getSquareFeet());
        Assertions.assertEquals(room1, houseResponse.getBiggest());
        Assertions.assertEquals(20, room1.getSquareFeet());
        Assertions.assertEquals(9, room2.getSquareFeet());
    }
}
