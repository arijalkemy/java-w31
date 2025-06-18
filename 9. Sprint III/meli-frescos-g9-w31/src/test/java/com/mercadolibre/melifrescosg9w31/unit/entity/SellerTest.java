package com.mercadolibre.melifrescosg9w31.unit.entity;

import com.mercadolibre.melifrescosg9w31.entity.Seller;
import com.mercadolibre.melifrescosg9w31.entity.UserAccount;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SellerTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testValidSeller() {
        Seller seller = new Seller(1L, "Seller Name", new UserAccount());
        Set<ConstraintViolation<Seller>> violations = validator.validate(seller);
        assertTrue(violations.isEmpty(), "Seller should be valid");
    }

    @Test
    void testInvalidSeller_NullName() {
        Seller seller = new Seller(1L, null, new UserAccount());
        Set<ConstraintViolation<Seller>> violations = validator.validate(seller);
        assertFalse(violations.isEmpty(), "Seller with null name should be invalid");
    }

    @Test
    void testGettersAndSetters() {
        Seller seller = new Seller();

        Long id = 1L;
        String name = "Test Seller";
        UserAccount userAccount = new UserAccount(1L, "testUser", "password123");

        seller.setId(id);
        seller.setName(name);
        seller.setUser(userAccount);

        assertEquals(id, seller.getId());
        assertEquals(name, seller.getName());
        assertEquals(userAccount, seller.getUser());
    }
}
