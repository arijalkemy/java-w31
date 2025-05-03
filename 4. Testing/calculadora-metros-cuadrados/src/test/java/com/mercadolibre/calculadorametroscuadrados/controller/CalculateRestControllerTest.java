package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CalculateRestControllerTest {

    @Test
    public void testCalculate(){
        // Arrange
        CalculateService mockService = Mockito.mock(CalculateService.class);
        HouseDTO input = new HouseDTO();
        HouseResponseDTO output = new HouseResponseDTO();
        when(mockService.calculate(input)).thenReturn(output);
        CalculateRestController controller = new CalculateRestController(mockService);

        // Act
        HouseResponseDTO result = controller.calculate(input);

        // Assert
        Assertions.assertEquals(output, result);
        verify(mockService).calculate(input);
    }
}
