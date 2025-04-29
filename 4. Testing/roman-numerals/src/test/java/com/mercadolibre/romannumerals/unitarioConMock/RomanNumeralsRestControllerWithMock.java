package com.mercadolibre.romannumerals.unitarioConMock;

import com.mercadolibre.romannumerals.RomanNumeralsRestController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class RomanNumeralsRestControllerWithMock {

    RomanNumeralsRestController controller;

    @BeforeEach
    public void setUp(){
        controller = new RomanNumeralsRestController();
    }

    @ParameterizedTest
    @CsvSource({
            "1,I",
            "3,III",
            "5,V",
            "7,VII",
            "10,X",
            "50,L"
    })

    void performTest(Integer inputNumber, String esperado){
        //Act
        String result = controller.toRoman(inputNumber);

        //Assert
        assertEquals(esperado,result);
        assertNotNull(result);
        assertTrue(result.length() > 0);
    }
}
