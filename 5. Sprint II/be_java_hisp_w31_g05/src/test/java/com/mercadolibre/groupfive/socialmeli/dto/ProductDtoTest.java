package com.mercadolibre.groupfive.socialmeli.dto;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

class ProductDtoTest {

    
    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void shouldReturnValidationErrors(){
        ProductDto productDto = new ProductDto();
        productDto.setBrand(" ");
        productDto.setColor("*¿? ");
        productDto.setId(0);
        productDto.setName("aaaaaaaaaaaaaaaa");
        productDto.setType(" ?+}{}");
        productDto.setNotes("aadad.{}+'=");

        Set<ConstraintViolation<ProductDto>> violations = validator.validate(productDto);
        assertFalse(violations.isEmpty());
    }
}
