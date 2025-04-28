package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

public class CalculateServiceTest {
    private CalculateService calculateService;
    private HouseDTO house;

    //Arrange para todos los test
    @BeforeEach
    void setUp() {
        calculateService = new CalculateService(); //inicializar servicio
        //crear dos habitaciones para probar los calculos
        RoomDTO room1 = new RoomDTO();
        room1.setName("Living");
        room1.setWidth(5);
        room1.setLength(4);   // 5x4 = 20

        RoomDTO room2 = new RoomDTO();
        room2.setName("Dormitorio");
        room2.setWidth(3);
        room2.setLength(4);   // 3x4 = 12 m²

        // crear casa con habitaciones creadas
        house = new HouseDTO();
        house.setName("Casa de Manu");
        house.setAddress("La Plata");
        house.setRooms(List.of(room1, room2));  // agrego habitaciones
    }

    //Verificar el cálculo del valor de la propiedad
    @Test
    void testCalculateCorrectPropertyValue(){
        //act
        HouseResponseDTO response = calculateService.calculate(house);
        //assert
        assertThat(response.getSquareFeet()).isEqualTo(32); //20+12
        assertThat(response.getPrice()).isEqualTo(25600); //metros2 * 800 = 25600
    }

    //Verificar que la habitación con las mayores dimensiones sea considerada la más grande
    @Test
    void testIdentifyBiggestRoom(){
        //act
        HouseResponseDTO response = calculateService.calculate(house);
        //assert
        assertThat(response.getBiggest().getName()).isEqualTo("Living");
        assertThat(response.getBiggest().getSquareFeet()).isEqualTo(20);
    }

    //Verificar la cantidad de metros cuadrados por habitación
    @Test
    void testCalculateSquareFeetPerRoom() {
        // recorro cada habitación y verifico que su cálculo sea correcto
        for (RoomDTO room : house.getRooms()) {
            Integer expectedArea = room.getWidth() * room.getLength();
            assertThat(room.getSquareFeet()).isEqualTo(expectedArea);
        }
    }

    // cuando la casa no tiene habitaciones
    @Test
    void shouldHandleEmptyRoomList() {
        HouseDTO emptyHouse = new HouseDTO();
        emptyHouse.setName("Casa vacia");
        emptyHouse.setAddress("sin direccion");
        emptyHouse.setRooms(List.of());  // lista vacia de habitaciones
        // act
        HouseResponseDTO response = calculateService.calculate(emptyHouse);
        // assert
        // verifica que los metros cuadrados totales sean 0
        assertThat(response.getSquareFeet()).isEqualTo(0);
        // verifica que el precio sea 0
        assertThat(response.getPrice()).isEqualTo(0);
        // verifica que no haya habitacion más grande
        assertThat(response.getBiggest()).isNull();
    }
}
