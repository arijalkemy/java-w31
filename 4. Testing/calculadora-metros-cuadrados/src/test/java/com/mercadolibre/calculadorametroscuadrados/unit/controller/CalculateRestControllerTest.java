package com.mercadolibre.calculadorametroscuadrados.unit.controller;

import com.mercadolibre.calculadorametroscuadrados.controller.CalculateRestController;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculateRestControllerTest {

    @Mock
    CalculateService service;

    @InjectMocks
    CalculateRestController controller;


        @Test
        public void calculate_shouldReturnHouseResponseDTO() {
            // Arrange
            HouseDTO house = new HouseDTO("La casa de barbie", "barbieland 123",
                    List.of(new RoomDTO("Baño", 130, 150),
                            new RoomDTO("Habitacion", 400, 400)));

            HouseResponseDTO response = new HouseResponseDTO(house);
            response.setSquareFeet(179500);
            response.setPrice(143600000);
            response.setBiggest(new RoomDTO("Habitacion", 400, 400));

            when(service.calculate(house)).thenReturn(response);

            // Act
            HouseResponseDTO responseObtained = controller.calculate(house);

            // Assert
            assertEquals("La casa de barbie", responseObtained.getName());
            assertEquals("barbieland 123", responseObtained.getAddress());
            assertEquals(179500, responseObtained.getSquareFeet());
            assertEquals("Habitacion", responseObtained.getBiggest().getName());
            assertEquals(143600000, responseObtained.getPrice());
        }

    }

