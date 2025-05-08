package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CalculateServiceTest {

    private final CalculateService service = new CalculateService();

    @Test
    void testCalculateSquareFeetAndPrice_SingleRoom() {
        RoomDTO room = createRoom("Hab1", 2, 5); // 10m2
        HouseDTO house = createHouse("casa", "address", List.of(room));

        HouseResponseDTO response = service.calculate(house);

        assertThat(response.getSquareFeet()).isEqualTo(10);
        assertThat(response.getPrice()).isEqualTo(8000);
        assertThat(response.getBiggest().getName()).isEqualTo("Hab1");
    }

    @Test
    void testCalculateSquareFeetAndPrice_MultipleRooms() {
        RoomDTO room1 = createRoom("Grande1", 3, 7); // 21
        RoomDTO room2 = createRoom("Pequeña2", 2, 2); // 4
        RoomDTO room3 = createRoom("Mediana", 2, 5); // 10
        HouseDTO house = createHouse("casa", "address", Arrays.asList(room1, room2, room3));

        HouseResponseDTO response = service.calculate(house);

        assertThat(response.getSquareFeet()).isEqualTo(35);
        assertThat(response.getPrice()).isEqualTo(28000);
        assertThat(response.getBiggest().getName()).isEqualTo("Grande1");
    }

    @Test
    void testReturnsEmptyWhenNoRooms() {
        HouseDTO house = createHouse("some", "xyz", List.of());

        HouseResponseDTO response = service.calculate(house);

        assertThat(response.getSquareFeet()).isEqualTo(0);
        assertThat(response.getPrice()).isEqualTo(0);
        assertThat(response.getBiggest()).isNull();
    }

    @Test
    void testNullWidthOrLengthInRoom() {
        RoomDTO room1 = createRoom("Empty", null, 5); // should be 0
        RoomDTO room2 = createRoom("Empty2", 7, null); // should be 0
        HouseDTO house = createHouse("casa", "address", Arrays.asList(room1, room2));

        HouseResponseDTO response = service.calculate(house);

        assertThat(response.getSquareFeet()).isEqualTo(0);
        assertThat(response.getPrice()).isEqualTo(0);
        assertThat(response.getBiggest()).isEqualTo(room1); // Pero ambos quedan en cero.
    }

    private HouseDTO createHouse(String name, String address, List<RoomDTO> rooms) {
        HouseDTO house = new HouseDTO();
        house.setName(name);
        house.setAddress(address);
        house.setRooms(rooms);
        return house;
    }

    private RoomDTO createRoom(String name, Integer width, Integer length) {
        RoomDTO room = new RoomDTO();
        room.setName(name);
        room.setWidth(width);
        room.setLength(length);
        return room;
    }
}