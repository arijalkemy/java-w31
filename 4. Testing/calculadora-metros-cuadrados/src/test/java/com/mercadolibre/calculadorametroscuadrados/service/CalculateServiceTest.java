package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.mercadolibre.calculadorametroscuadrados.util.CalculatorUtil.getHouse;
import static com.mercadolibre.calculadorametroscuadrados.util.CalculatorUtil.getRoom;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CalculateServiceTest {
    List<RoomDTO> rooms = List.of(
            getRoom("Espacio abierto", 5, 5),
            getRoom("Cocina", 3, 3),
            getRoom("Baño", 2, 1)
    );

    @InjectMocks
    private CalculateService calculateService;

    @Test
    void testCalculateRoomSquareFeet() {
        HouseDTO house = getHouse(rooms);
        int expectedArea = 36;
        HouseResponseDTO response = calculateService.calculate(house);
        assertEquals(expectedArea, response.getSquareFeet());
    }

    @Test
    void testCalculatePrice() {
        HouseDTO house = getHouse(rooms);
        int expectedPrice = 28800; // 36 * 800
        HouseResponseDTO response = calculateService.calculate(house);
        assertEquals(expectedPrice, response.getPrice());
    }
}
