package com.mercadolibre.calculadorametroscuadrados.controllers;

import com.mercadolibre.calculadorametroscuadrados.controller.CalculateRestController;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CalculateRestControllerTests {
    @Mock
    CalculateService calculateService;
    @InjectMocks
    CalculateRestController calculateRestController;

    @Test
    void calculateController() {
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
        Mockito.when(calculateService.calculate(house)).thenReturn(new HouseResponseDTO(house));
        // Act
        HouseResponseDTO houseResponse = calculateRestController.calculate(house);
        // Assert
        Mockito.verify(calculateService, Mockito.atLeastOnce()).calculate(house);
    }
}
