package com.mercadolibre.calculadorametroscuadrados.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;

@ExtendWith(MockitoExtension.class)
public class CalculateRestControllerTest {
    @Mock
    private CalculateService calculateService;

    @InjectMocks
    private CalculateRestController calculateRestController;

    private HouseDTO houseDTO;
    private List<RoomDTO> rooms;
    private RoomDTO room1;
    private RoomDTO room2;
    private HouseResponseDTO houseResponseDTO;

    @BeforeEach
    void setUp() {
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

        houseResponseDTO = new HouseResponseDTO(houseDTO);
        houseResponseDTO.setBiggest(room1);
        houseResponseDTO.setSquareFeet(38);
        houseResponseDTO.setPrice(38 * 800);
    }

    @Test
    void testCalculate() {
        // Arrange
        HouseResponseDTO expectedResponse = new HouseResponseDTO(houseDTO);
        expectedResponse.setBiggest(room1);
        expectedResponse.setSquareFeet(38);
        expectedResponse.setPrice(38 * 800);

        when(calculateService.calculate(houseDTO)).thenReturn(houseResponseDTO);

        // Act
        HouseResponseDTO result = calculateRestController.calculate(houseDTO);

        // Assert
        verify(calculateService, atLeast(1)).calculate(houseDTO);
        assertEquals(expectedResponse.getAddress(), result.getAddress());
        assertEquals(expectedResponse.getBiggest(), result.getBiggest());
        assertEquals(expectedResponse.getName(), result.getName());
        assertEquals(expectedResponse.getRooms(), result.getRooms());
        assertEquals(expectedResponse.getSquareFeet(), result.getSquareFeet());
        assertEquals(expectedResponse.getPrice(), result.getPrice());
    }
}
