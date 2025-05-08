package com.mercadolibre.calculadorametroscuadrados.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class RoomDTOTest {
    @Test
    void testGetSquareFeetNormal() {
        RoomDTO room = new RoomDTO();
        room.setWidth(5);
        room.setLength(4);
        assertThat(room.getSquareFeet()).isEqualTo(20);
    }

    @Test
    void testGetSquareFeetNullValues() {
        RoomDTO room = new RoomDTO();
        room.setWidth(null);
        room.setLength(5);
        assertThat(room.getSquareFeet()).isEqualTo(0);

        room.setWidth(6);
        room.setLength(null);
        assertThat(room.getSquareFeet()).isEqualTo(0);

        room.setWidth(null);
        room.setLength(null);
        assertThat(room.getSquareFeet()).isEqualTo(0);
    }
}