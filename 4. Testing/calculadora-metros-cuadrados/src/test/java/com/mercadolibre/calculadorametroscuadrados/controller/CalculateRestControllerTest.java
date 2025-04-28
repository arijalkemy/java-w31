package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CalculateRestControllerTest {
    @Mock
    private CalculateService service;

    @InjectMocks
    private CalculateRestController controller;

    HouseDTO house = new HouseDTO();

    @BeforeEach
    void setUp() {
        RoomDTO room1 = new RoomDTO();
        room1.setName("Cocina");
        room1.setLength(7);
        room1.setWidth(5);

        RoomDTO room2 = new RoomDTO();
        room2.setName("Habitacion");
        room2.setLength(3);
        room2.setWidth(4);

        house.setName("Casa");
        house.setAddress("Libertador 123");
        house.setRooms(List.of(room1, room2));
    }

    @Test
    void testServiceIsCalledCorrectly() {
        HouseResponseDTO houseResponse = new HouseResponseDTO(house);
        when(service.calculate(house)).thenReturn(houseResponse);
        controller.calculate(house);
        verify(service, atLeastOnce()).calculate(house);
    }

}