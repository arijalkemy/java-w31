package com.mercadolibre.calculadorametroscuadrados.unitario;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CalculateServiceTest {

    CalculateService service;

    @BeforeEach
    void setUp(){
        service = new CalculateService();
    }

    @Test
    void testHouse(){
        //Arrange
        Integer expectedPrice = 32800;
        String expectedBiggestRoom = "Room 2";
        Integer expectedRoom1Area = 16;
        Integer expectedRoom2Area = 25;

        HouseDTO request = new HouseDTO();
        List<RoomDTO> rooms = List.of(
                new RoomDTO("Room 1",4,4),
                new RoomDTO("Room 2",5,5)
        );
        request.setRooms(rooms);

        //Act
        HouseResponseDTO result = service.calculate(request);

        //Assert
        assertAll(
                ()-> assertEquals(expectedPrice,result.getPrice()),
                () -> assertEquals(expectedBiggestRoom,result.getBiggest().getName()),
                () -> assertEquals(expectedRoom1Area,result.getRooms().get(0).getSquareFeet()),
                ()-> assertEquals(expectedRoom2Area,result.getRooms().get(1).getSquareFeet())
        );
    }
}
