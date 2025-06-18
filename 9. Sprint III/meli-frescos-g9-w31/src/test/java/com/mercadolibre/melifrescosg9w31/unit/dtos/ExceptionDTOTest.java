package com.mercadolibre.melifrescosg9w31.unit.dtos;

import com.mercadolibre.melifrescosg9w31.dtos.ExceptionDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionDTOTest {

    @Test
    void testNoArgsConstructor() {
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        assertNull(exceptionDTO.getMessage(), "El mensaje debe ser nulo al usar el constructor sin argumentos");
    }

    @Test
    void testAllArgsConstructor() {
        String expectedMessage = "Este es un mensaje de prueba";
        ExceptionDTO exceptionDTO = new ExceptionDTO(expectedMessage);
        assertEquals(expectedMessage, exceptionDTO.getMessage(), "El mensaje debe coincidir con el valor pasado al constructor");
    }

    @Test
    void testGettersAndSetters() {
        ExceptionDTO exceptionDTO = new ExceptionDTO();

        String newMessage = "Nuevo mensaje de error";
        exceptionDTO.setMessage(newMessage);
        assertEquals(newMessage, exceptionDTO.getMessage(), "El getter debe devolver el mensaje establecido por el setter");

        String anotherMessage = "Otro mensaje diferente";
        exceptionDTO.setMessage(anotherMessage);
        assertEquals(anotherMessage, exceptionDTO.getMessage(), "El getter debe devolver el mensaje actualizado");
    }
    @Test
    void testEqualsAndHashCode() {
        ExceptionDTO dto1 = new ExceptionDTO("message1");
        ExceptionDTO dto2 = new ExceptionDTO("message1");
        ExceptionDTO dto3 = new ExceptionDTO("message2");
        ExceptionDTO dto4 = new ExceptionDTO(null);
        ExceptionDTO dto5 = new ExceptionDTO(null);

        // Test equality
        assertEquals(dto1, dto2, "Dos objetos con el mismo mensaje deben ser iguales");
        assertNotEquals(dto1, dto3, "Dos objetos con diferente mensaje no deben ser iguales");
        assertNotEquals(dto1, null, "Un objeto no debe ser igual a null");
        assertNotEquals(dto1, new Object(), "Un objeto no debe ser igual a un objeto de diferente clase");
        assertEquals(dto4, dto5, "Dos objetos con mensaje nulo deben ser iguales");

        // Test hash code
        assertEquals(dto1.hashCode(), dto2.hashCode(), "Dos objetos iguales deben tener el mismo hash code");
        assertNotEquals(dto1.hashCode(), dto3.hashCode(), "Dos objetos diferentes deben tener diferente hash code");
        assertEquals(dto4.hashCode(), dto5.hashCode(), "Dos objetos con mensaje nulo deben tener el mismo hash code");
    }

    @Test
    void testToString() {
        String message = "Test Message for toString";
        ExceptionDTO exceptionDTO = new ExceptionDTO(message);
        String expectedToString = "ExceptionDTO(message=" + message + ")";
        assertEquals(expectedToString, exceptionDTO.toString(), "El método toString debe generar la cadena esperada");

        ExceptionDTO nullMessageDTO = new ExceptionDTO(null);
        String expectedNullToString = "ExceptionDTO(message=null)";
        assertEquals(expectedNullToString, nullMessageDTO.toString(), "El método toString debe manejar mensajes nulos correctamente");
    }
}
