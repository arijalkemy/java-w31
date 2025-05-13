package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static com.mercadolibre.calculadorametroscuadrados.util.CalculatorUtil.getRoom;
import static jakarta.validation.Validation.buildDefaultValidatorFactory;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorUnitTest {
    HouseDTO brokenDto = new HouseDTO("Valido", "Monroe 800", List.of(
            getRoom("Oficina", 10, 20)
    ));

    HouseDTO goodDto = new HouseDTO("Oficina", "Street Name 123, City, Country", List.of(
            getRoom("Oficina", 10, 20)
    ));

    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testGoodDtoValidation() {
        Set<ConstraintViolation<HouseDTO>> violations = validator.validate(goodDto);
        assertEquals(0, violations.size());
        assertEquals(violations, Set.of());
    }

    @Test
    public void testBadDtoValidation() {
        Set<ConstraintViolation<HouseDTO>> violations = validator.validate(brokenDto);
        logViolations(violations);
//        assertEquals(1, violations.size());
        assertEquals("Address must follow the format 'Street Name 123, City, Country'", violations.iterator().next().getMessage());
    }

    private void logViolations(Set<ConstraintViolation<HouseDTO>> violations) {
        violations.forEach(v -> System.out.println(
                "Property: " + v.getPropertyPath() +
                        ", Invalid value: " + v.getInvalidValue() +
                        ", Message: " + v.getMessage()
        ));
    }
}