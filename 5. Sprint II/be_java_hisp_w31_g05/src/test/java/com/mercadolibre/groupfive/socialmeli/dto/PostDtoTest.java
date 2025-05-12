package com.mercadolibre.groupfive.socialmeli.dto;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class PostDtoTest {
    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void shouldReturnValidationErrors(){
        PostDto postDto = new PostDto();
        postDto.setUserId(-1);
        postDto.setPostId(1);
        postDto.setPublishDate(null);
        postDto.setProductDto(null);
        postDto.setCategory(10);
        postDto.setPrice(0D);
        postDto.setHasPromo(false);
        postDto.setDiscount(10D);

        Set<ConstraintViolation<PostDto>> violations = validator.validate(postDto);
        assertFalse(violations.isEmpty());
    }
}
