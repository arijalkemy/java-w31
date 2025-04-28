package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.apache.coyote.http11.Constants.a;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CalculateRestControllerTest {

    @Mock
    private CalculateService calculateService;

    @InjectMocks
    private CalculateRestController calculateRestController;

    @Test
    public void testCalculate() {
        // Arrange
        HouseDTO house = new HouseDTO("Luxury House", "CL 500 # 50", List.of(
                new RoomDTO("Living Room", 10, 10) // 100 sqft
        ));
        HouseResponseDTO expectedResponse = new HouseResponseDTO(house);

        when(calculateService.calculate(house)).thenReturn(expectedResponse);

        // Act
        HouseResponseDTO actualResponse = calculateRestController.calculate(house);
        // Act
        verify(calculateService).calculate(house);
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void testCalculateWithMinimalHouse() {
        // Arrange
        HouseDTO minimalHouse = new HouseDTO("Tiny House", "", List.of());
        HouseResponseDTO expectedResponse = new HouseResponseDTO(minimalHouse);

        when(calculateService.calculate(minimalHouse)).thenReturn(expectedResponse);

        // Act
        HouseResponseDTO actualResponse = calculateRestController.calculate(minimalHouse);

        // Assert
        verify(calculateService).calculate(minimalHouse);
        assertEquals(expectedResponse, actualResponse);
    }



}
