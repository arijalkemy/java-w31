package com.mercadolibre.groupfive.socialmeli.dto;

import jakarta.validation.Validator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.Test;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;

public class UserDtoTest {

    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    void TestUsertDtoIdNull() {
        // Arrange
        UserDto userDto = UserDto.builder()
                .id(null)
                .name("name")
                .build();

        // Act
        Set<ConstraintViolation<UserDto>> violations = validator.validate(userDto);

        // Assert
        assertFalse(violations.isEmpty());
    }

    @Test
    void TestUsertDtoIdNegative() {
        // Arrange
        UserDto userDto = UserDto.builder()
                .id(-1)
                .name("name")
                .build();

        // Act
        Set<ConstraintViolation<UserDto>> violations = validator.validate(userDto);

        // Assert
        assertFalse(violations.isEmpty());
    }

    @Test
    void TestUsertDtoIdZero() {
        // Arrange
        UserDto userDto = UserDto.builder()
                .id(0)
                .name("name")
                .build();

        // Act
        Set<ConstraintViolation<UserDto>> violations = validator.validate(userDto);

        // Assert
        assertFalse(violations.isEmpty());
    }

    @Test
    void TestUsertDto() {
        // Arrange
        UserDto userDto = UserDto.builder()
                .id(1)
                .name("name")
                .build();

        // Act
        Set<ConstraintViolation<UserDto>> violations = validator.validate(userDto);

        // Assert
        assertTrue(violations.isEmpty());
    }

}
