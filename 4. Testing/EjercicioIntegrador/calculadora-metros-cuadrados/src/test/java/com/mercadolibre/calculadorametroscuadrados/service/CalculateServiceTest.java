package com.mercadolibre.calculadorametroscuadrados.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.utils.Util;

@SpringBootTest
class CalculateServiceTest {
    @Autowired
    CalculateService service;

    @Test
    void calculateTest() {
        // Arrange
        HouseDTO house = Util.createHouse();
        HouseResponseDTO expectedResponse = new HouseResponseDTO(41, 32800, house.getRooms().get(0));

        // Act
        HouseResponseDTO response = service.calculate(house);

        // Assert
        assertNotNull(response);
        assertEquals(expectedResponse.getSquareFeet(), response.getSquareFeet());
        assertEquals(expectedResponse.getPrice(), response.getPrice());
        assertEquals(expectedResponse.getBiggest().getName(), response.getBiggest().getName());
    }

    @Test
    void calculateSadPath() {
        // Arrange
        HouseDTO house = null;

        // Act & Assert
        assertThrows(NullPointerException.class, () -> service.calculate(house));
    }

}
