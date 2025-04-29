package com.mercadolibre.calculadorametroscuadrados.utils;

import java.util.ArrayList;
import java.util.List;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

public class Util {
    // Método para crear una casa con algunos cuartos
    public static HouseDTO createHouse() {
        HouseDTO house = new HouseDTO();
        house.setName("Mi casa");
        house.setAddress("Zapiola 123");
        house.setRooms(createSomeRooms());
        return house;
    }

    // Método para crear una lista de cuartos
    public static List<RoomDTO> createSomeRooms() {
        RoomDTO livingRoom = new RoomDTO("Sala", 5, 4);
        RoomDTO kitchen = new RoomDTO("Cocina", 3, 3);
        RoomDTO bedroom = new RoomDTO("Dormitorio", 4, 3);
        return List.of(livingRoom, kitchen, bedroom);
    }

    public static HouseDTO createInvalidHouse() {
        HouseDTO house = new HouseDTO();
        house.setName("");
        house.setAddress(null);
        house.setRooms(new ArrayList<>());
        return house;
    }
}
