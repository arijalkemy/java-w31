package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class RomanNumeralsRestControllerTest {

    @InjectMocks
    private RomanNumeralsRestController controller;

    @BeforeEach
    void setUp() {
        controller = new RomanNumeralsRestController();
    }

    @Test
    void toRomanSingleDigitNumbersShouldReturnCorrectRoman() {
        assertEquals("I", controller.toRoman(1));
        assertEquals("V", controller.toRoman(5));
        assertEquals("IX", controller.toRoman(9));
    }

    @Test
    void toRomanTwoDigitNumbersShouldReturnCorrectRoman() {
        assertEquals("X", controller.toRoman(10));
        assertEquals("XV", controller.toRoman(15));
        assertEquals("XXIV", controller.toRoman(24));
        assertEquals("XLII", controller.toRoman(42));
        assertEquals("XCIX", controller.toRoman(99));
    }

    @Test
    void toRomanThreeDigitNumbersShouldReturnCorrectRoman() {
        assertEquals("C", controller.toRoman(100));
        assertEquals("CDLVI", controller.toRoman(456));
        assertEquals("DCLXIV", controller.toRoman(664));
        assertEquals("CMXCIX", controller.toRoman(999));
    }

    @Test
    void toRomanFourDigitNumbersShouldReturnCorrectRoman() {
        assertEquals("M", controller.toRoman(1000));
        assertEquals("MMCDXXI", controller.toRoman(2421));
        assertEquals("MMMCMXCIX", controller.toRoman(3999));
    }

    @Test
    void toRomanSZeroShouldReturnEmptyString() {
        assertEquals("", controller.toRoman(0));
    }

    @Test
    void toRoman_EdgeCases_LargeNumbers() {
        assertEquals("MMMCMXCIX", controller.toRoman(3999));
        assertEquals("MMMM", controller.toRoman(4000));
        assertEquals("MMMMM", controller.toRoman(5000));
    }

}