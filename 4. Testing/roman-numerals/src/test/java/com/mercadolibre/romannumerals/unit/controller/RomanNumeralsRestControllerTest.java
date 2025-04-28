package com.mercadolibre.romannumerals.unit.controller;

import com.mercadolibre.romannumerals.RomanNumeralsRestController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RomanNumeralsRestControllerTest {
    @Autowired
    private RomanNumeralsRestController controller;

    @Test
    public void toRoman_withOne_shouldReturnI(){
        // Arrange
        String romanNumberExpected = "I";
        Integer number = 1;

        // Act
        String romanNumberObtained = controller.toRoman(number);

        // Assert
        assertEquals(romanNumberObtained, romanNumberExpected);
    }
    @Test
    public void toRoman_withThree_shouldReturnIII(){
        // Arrange
        String romanNumberExpected = "III";
        Integer number = 3;

        // Act
        String romanNumberObtained = controller.toRoman(number);

        // Assert
        assertEquals(romanNumberObtained, romanNumberExpected);
    }
    @Test
    public void toRoman_withFive_shouldReturnV(){
        // Arrange
        String romanNumberExpected = "V";
        Integer number = 5;

        // Act
        String romanNumberObtained = controller.toRoman(number);

        // Assert
        assertEquals(romanNumberObtained, romanNumberExpected);
    }
    @Test
    public void toRoman_withSeven_shouldReturnVI(){
        // Arrange
        String romanNumberExpected = "VII";
        Integer number = 7;

        // Act
        String romanNumberObtained = controller.toRoman(number);

        // Assert
        assertEquals(romanNumberObtained, romanNumberExpected);
    }
    @Test
    public void toRoman_withTen_shouldReturnX(){
        // Arrange
        String romanNumberExpected = "X";
        Integer number = 10;

        // Act
        String romanNumberObtained = controller.toRoman(number);

        // Assert
        assertEquals(romanNumberObtained, romanNumberExpected);
    } @Test
    public void toRoman_withFifty_shouldReturnL(){
        // Arrange
        String romanNumberExpected = "L";
        Integer number = 50;

        // Act
        String romanNumberObtained = controller.toRoman(number);

        // Assert
        assertEquals(romanNumberObtained, romanNumberExpected);
    }


}
