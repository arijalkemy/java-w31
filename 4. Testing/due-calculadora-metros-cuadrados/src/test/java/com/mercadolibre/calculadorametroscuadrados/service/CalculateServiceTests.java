package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CalculateServiceTests {
    @InjectMocks
    CalculateService calculateService;

    @Test
    public void givenHouse_whenCalculate_thenMakesCalculations(){
        // Arrange - Given
        RoomDTO room1 = new RoomDTO("Room1", 10, 10);
        RoomDTO room2 = new RoomDTO("Room2", 15, 10);
        HouseDTO house = new HouseDTO("House1", "St. Patrick St. 18",
                List.of(room1, room2));
        HouseResponseDTO expectedHouseResponse = new HouseResponseDTO(house);
        int squareFeet = (room1.getLength() * room1.getWidth()) + (room2.getLength() * room2.getWidth());
        expectedHouseResponse.setSquareFeet(squareFeet);
        expectedHouseResponse.setBiggest(room2);
        expectedHouseResponse.setPrice(squareFeet * 800);

        // Act - When
        HouseResponseDTO response = calculateService.calculate(house);

        // Assert - Then
        assertEquals(expectedHouseResponse, response);
    }
}
