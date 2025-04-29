package com.mercadolibre.calculadorametroscuadrados.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import com.mercadolibre.calculadorametroscuadrados.utils.Util;

@SpringBootTest
class CalculateRestControllerTest {
    @Mock
    CalculateService service;

    @InjectMocks
    CalculateRestController controller;

    @Test
    void calculateTest() {
        // Arrange
        HouseDTO house = Util.createHouse();
        HouseResponseDTO expectedResponse = new HouseResponseDTO(41, 32800, house.getRooms().get(0));
        Mockito.when(service.calculate(house)).thenReturn(expectedResponse);

        // Act
        HouseResponseDTO response = controller.calculate(house);

        // Assert
        verify(service, atLeast(1)).calculate(house);
        assertNotNull(response);
        assertEquals(expectedResponse.getSquareFeet(), response.getSquareFeet());
        assertEquals(expectedResponse.getPrice(), response.getPrice());
        assertEquals(expectedResponse.getBiggest().getName(), response.getBiggest().getName());
    }

    @Test
    void calculateTestNullParameter() {
        // Arrange
        HouseDTO house = null;
        Mockito.when(service.calculate(house)).thenThrow(NullPointerException.class);

        // Act & Assert
        assertThrows(NullPointerException.class, () -> controller.calculate(house));
    }

}
