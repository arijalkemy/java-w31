package com.meli.obtenerdiploma.integration;

import com.meli.obtenerdiploma.model.ErrorDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ErrorDTOTests {

    @Test
    public void testSettersAndGetters(){
        ErrorDTO errorDTO = new ErrorDTO();

        errorDTO.setName("Error name");
        errorDTO.setDescription("Error description");

        Assertions.assertEquals("Error name", errorDTO.getName());
        Assertions.assertEquals("Error description", errorDTO.getDescription());
    }

    @Test
    public void testAllArgsConstructor() {
        ErrorDTO errorDTO = new ErrorDTO("Error name", "Error description");

        Assertions.assertEquals("Error name", errorDTO.getName());
        Assertions.assertEquals("Error description", errorDTO.getDescription());
    }

    @Test
    public void testNonArgsConstructor() {
        ErrorDTO errorDTO = new ErrorDTO();

        Assertions.assertNull(errorDTO.getName());
        Assertions.assertNull(errorDTO.getDescription());
    }

}
