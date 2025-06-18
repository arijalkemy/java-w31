package com.mercadolibre.melifrescosg9w31.unit.entity;

import com.mercadolibre.melifrescosg9w31.entity.Carrier;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CarrierTest {

  private Validator validator;

  @BeforeEach
  void setUp() {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    validator = factory.getValidator();
  }

  @Test
  void testValidCarrier() {
    Carrier carrier = new Carrier(1L, "Carrier Name", "Contact Info");
    Set<ConstraintViolation<Carrier>> violations = validator.validate(carrier);
    assertTrue(violations.isEmpty(), "Carrier should be valid");
  }

  @Test
  void testInvalidCarrier_NullName() {
    Carrier carrier = new Carrier(1L, null, "Contact Info");
    Set<ConstraintViolation<Carrier>> violations = validator.validate(carrier);
    assertFalse(violations.isEmpty(), "Carrier with null name should be invalid");
  assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("name")));
    }

    @Test
    void testGettersAndSetters() {
        Carrier carrier = new Carrier();

        Long id = 1L;
        String name = "Test Carrier Name";
        String contact = "test@example.com";

        carrier.setId(id);
        carrier.setName(name);
        carrier.setContact(contact);

        assertEquals(id, carrier.getId());
        assertEquals(name, carrier.getName());
        assertEquals(contact, carrier.getContact());

        // Test with different values
        Long updatedId = 2L;
        String updatedName = "Updated Carrier Name";
        String updatedContact = "updated@example.com";

        carrier.setId(updatedId);
        carrier.setName(updatedName);
        carrier.setContact(updatedContact);

        assertEquals(updatedId, carrier.getId());
        assertEquals(updatedName, carrier.getName());
        assertEquals(updatedContact, carrier.getContact());
    }


    @Test
    void testNoArgsConstructor() {
        Carrier carrier = new Carrier();
        assertNotNull(carrier);
        assertNull(carrier.getId());
        assertNull(carrier.getName());
        assertNull(carrier.getContact());
    }

    @Test
    void testInvalidCarrier_NameTooLong() {
        String longName = "a".repeat(256); // Name longer than 255 characters
        Carrier carrier = new Carrier(1L, longName, "Contact Info");
        Set<ConstraintViolation<Carrier>> violations = validator.validate(carrier);
        assertFalse(violations.isEmpty(), "Carrier with name too long should be invalid");
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("name")));
    }

    @Test
    void testValidCarrier_NullContact() {
        Carrier carrier = new Carrier(1L, "Carrier Name", null);
        Set<ConstraintViolation<Carrier>> violations = validator.validate(carrier);
        assertTrue(violations.isEmpty(), "Carrier with null contact should be valid");
    }
}