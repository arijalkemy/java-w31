package com.mercadolibre.melifrescosg9w31.unit.entity;

import com.mercadolibre.melifrescosg9w31.entity.UserAccount;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UserAccountTest {


    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testValidUserAccount() {
        UserAccount userAccount = UserAccount.builder()
                .id(1L)
                .userName("username")
                .password("password123")
                .role(null) // O asigna un Role válido si es requerido
                .build();
        Set<ConstraintViolation<UserAccount>> violations = validator.validate(userAccount);
        assertTrue(violations.isEmpty(), "UserAccount should be valid");
    }

    @Test
    void testInvalidUserAccount_NullUserName() {
        UserAccount userAccount = UserAccount.builder()
                .id(1L)
                .userName(null)
                .password("password123")
                .role(null)
                .build();
        Set<ConstraintViolation<UserAccount>> violations = validator.validate(userAccount);
        assertFalse(violations.isEmpty(), "UserAccount with null userName should be invalid");
    }

    @Test
    void testInvalidUserAccount_NullPassword() {
        UserAccount userAccount = UserAccount.builder()
                .id(1L)
                .userName("username")
                .password(null)
                .role(null)
                .build();
        Set<ConstraintViolation<UserAccount>> violations = validator.validate(userAccount);
        assertFalse(violations.isEmpty(), "UserAccount with null password should be invalid");
    }

    @Test
    void testGettersAndSetters() {
        UserAccount userAccount = new UserAccount();

        Long id = 1L;
        String userName = "testUser";
        String password = "password123";

        userAccount.setId(id);
        userAccount.setUserName(userName);
        userAccount.setPassword(password);

        assertEquals(id, userAccount.getId());
        assertEquals(userName, userAccount.getUsername());
        assertEquals(password, userAccount.getPassword());
    }
}
