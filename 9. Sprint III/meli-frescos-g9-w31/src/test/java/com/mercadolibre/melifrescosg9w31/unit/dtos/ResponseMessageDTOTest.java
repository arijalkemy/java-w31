package com.mercadolibre.melifrescosg9w31.unit.dtos.response;

import com.mercadolibre.melifrescosg9w31.dtos.response.ResponseMessageDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResponseMessageDTOTest {

    @Test
    void testNoArgsConstructor() {
        ResponseMessageDTO dto = new ResponseMessageDTO();
        assertNull(dto.getMessage());
    }

    @Test
    void testAllArgsConstructor() {
        String expectedMessage = "Test message";
        ResponseMessageDTO dto = new ResponseMessageDTO(expectedMessage);
        assertEquals(expectedMessage, dto.getMessage());
    }

    @Test
    void testSetterAndGetter() {
        ResponseMessageDTO dto = new ResponseMessageDTO();
        String expectedMessage = "Another test message";
        dto.setMessage(expectedMessage);
        assertEquals(expectedMessage, dto.getMessage());
    }

    @Test
    void testEqualsAndHashCode() {
        ResponseMessageDTO dto1 = new ResponseMessageDTO("message1");
        ResponseMessageDTO dto2 = new ResponseMessageDTO("message1");
        ResponseMessageDTO dto3 = new ResponseMessageDTO("message2");
        ResponseMessageDTO dto4 = new ResponseMessageDTO(null);
        ResponseMessageDTO dto5 = new ResponseMessageDTO(null);


        assertEquals(dto1, dto2);
        assertNotEquals(dto1, dto3);
        assertNotEquals(dto1, null);
        assertNotEquals(dto1, new Object());
        assertEquals(dto4, dto5);
        assertNotEquals(dto1.hashCode(), dto3.hashCode());
        assertEquals(dto1.hashCode(), dto2.hashCode());
        assertEquals(dto4.hashCode(), dto5.hashCode());
    }

    @Test
    void testToString() {
        String message = "Hello";
        ResponseMessageDTO dto = new ResponseMessageDTO(message);
        String expectedToString = "ResponseMessageDTO(message=" + message + ")";
        assertEquals(expectedToString, dto.toString());
    }
}