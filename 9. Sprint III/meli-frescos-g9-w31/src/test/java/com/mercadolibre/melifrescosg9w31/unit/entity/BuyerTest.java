package com.mercadolibre.melifrescosg9w31.unit.entity;

import com.mercadolibre.melifrescosg9w31.entity.Buyer;
import com.mercadolibre.melifrescosg9w31.entity.UserAccount;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BuyerTest {

  private Validator validator;

  @BeforeEach
  void setUp() {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    validator = factory.getValidator();
  }

  @Test
  void testValidBuyer() {
    Buyer buyer = new Buyer(1L, "John Doe", new UserAccount());
    Set<ConstraintViolation<Buyer>> violations = validator.validate(buyer);
    assertTrue(violations.isEmpty(), "Buyer should be valid");
  }

  @Test
  void testInvalidBuyer_NullName() {
    Buyer buyer = new Buyer(1L, null, new UserAccount());
    Set<ConstraintViolation<Buyer>> violations = validator.validate(buyer);
    assertFalse(violations.isEmpty(), "Buyer with null name should be invalid");
  }

  @Test
  void testGettersAndSetters() {
    Buyer buyer = new Buyer();

    Long id = 1L;
    String name = "Test Buyer";
    UserAccount userAccount = new UserAccount(1L, "testUser", "password123");

    buyer.setId(id);
    buyer.setName(name);
    buyer.setUser(userAccount);

    assertEquals(id, buyer.getId());
    assertEquals(name, buyer.getName());
    assertEquals(userAccount, buyer.getUser());
  }
}
