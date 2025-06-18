package com.mercadolibre.melifrescosg9w31.unit.DTO;

import com.mercadolibre.melifrescosg9w31.dtos.ExceptionDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ExceptionDTOTest {

    @Test
    void testAllArgsConstructorAndGetters() {
        ExceptionDTO dto = new ExceptionDTO("mensaje de error");
        assertEquals("mensaje de error", dto.getMessage());
    }

    @Test
    void testNoArgsConstructorAndSetters() {
        ExceptionDTO dto = new ExceptionDTO();
        dto.setMessage("otro error");
        assertEquals("otro error", dto.getMessage());
    }

    @Test
    void testToString() {
        ExceptionDTO dto = new ExceptionDTO("error");
        assertTrue(dto.toString().contains("error"));
    }

    @Test
    void testEqualsAndHashCode() {
        ExceptionDTO dto1 = new ExceptionDTO("error");
        ExceptionDTO dto2 = new ExceptionDTO("error");
        assertEquals(dto1, dto2);
        assertEquals(dto1.hashCode(), dto2.hashCode());
    }
}