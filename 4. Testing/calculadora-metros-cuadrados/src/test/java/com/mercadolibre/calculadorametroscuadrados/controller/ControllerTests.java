package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ControllerTests {

    @Mock
    private CalculateService calculateService;

    @InjectMocks
    private CalculateRestController controller;

    @Test
    public void testCalculate() {
        // Arrange
        List<RoomDTO> roomDTOList = new ArrayList<>();
        RoomDTO room1 = new RoomDTO("Hab 1", 5, 10);
        RoomDTO room2 = new RoomDTO("Hab 2", 9, 20);
        roomDTOList.add(room1);
        roomDTOList.add(room2);

        HouseDTO house = new HouseDTO("Casa 1", "Address", roomDTOList);

        HouseResponseDTO response = new HouseResponseDTO(house);
        response.setSquareFeet(230);
        response.setBiggest(room2);

        // Act
        Mockito.when(calculateService.calculate(house)).thenReturn(response);
        HouseResponseDTO houseResponse = controller.calculate(house);

        // Assert
        Mockito.verify(calculateService, Mockito.atLeast(1)).calculate(house);
        Assertions.assertEquals(response, houseResponse);
    }
}
