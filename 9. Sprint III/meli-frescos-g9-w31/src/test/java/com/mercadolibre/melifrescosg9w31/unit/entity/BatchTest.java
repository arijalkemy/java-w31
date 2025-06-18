package com.mercadolibre.melifrescosg9w31.unit.entity;

import com.mercadolibre.melifrescosg9w31.entity.Batch;
import com.mercadolibre.melifrescosg9w31.entity.InboundOrder;
import com.mercadolibre.melifrescosg9w31.entity.Product;
import com.mercadolibre.melifrescosg9w31.entity.Sector;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BatchTest {

  private Validator validator;

  @BeforeEach
  void setUp() {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    validator = factory.getValidator();
  }

    @Test
    void testValidBatch() {
        Batch batch = new Batch(
            1L,
            1001,
            50,
            30,
            LocalDateTime.now().plusDays(10),
            LocalDate.now().plusDays(10),
            new BigDecimal("5.5"),
            new BigDecimal("2.0"),
            new Product(), // Assuming Product is a valid entity
            new Sector(), // Assuming Sector is a valid entity
            new InboundOrder() // Assuming InboundOrder is a valid entity
            );

    Set<ConstraintViolation<Batch>> violations = validator.validate(batch);
    assertTrue(violations.isEmpty(), "Batch should be valid");
  }

  @Test
  void testInvalidBatch_NullFields() {
    Batch batch = new Batch();
    batch.setBatchNumber(null);
    batch.setInitialQuantity(null);
    batch.setActualQuantity(null);
    batch.setExpireDate(null);
    batch.setProduct(null);
    batch.setSector(null);
    batch.setInboundOrder(null);

        Set<ConstraintViolation<Batch>> violations = validator.validate(batch);
        assertFalse(violations.isEmpty(), "Batch with null fields should be invalid");
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("batchNumber")));
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("initialQuantity")));
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("actualQuantity")));
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("expireDate")));
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("product")));
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("sector")));
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("inboundOrder")));
    }

  @Test
  void testGettersAndSetters() {
    Batch batch = new Batch();

        Long id = 1L;
        Integer batchNumber = 1001;
        Integer initialQuantity = 50;
        Integer actualQuantity = 30;
        LocalDateTime manufacturingDatetime = LocalDateTime.now().plusDays(10);
        LocalDate expireDate = LocalDate.now().plusDays(10);
        BigDecimal registrationTemp = new BigDecimal("5.5");
        BigDecimal minimumTemp = new BigDecimal("2.0");
        Product product = new Product();
        Sector sector = new Sector();
        InboundOrder inboundOrder = new InboundOrder();

    batch.setId(id);
    batch.setBatchNumber(batchNumber);
    batch.setInitialQuantity(initialQuantity);
    batch.setActualQuantity(actualQuantity);
    batch.setManufacturingDatetime(manufacturingDatetime);
    batch.setExpireDate(expireDate);
    batch.setRegistrationTemp(registrationTemp);
    batch.setMinimumTemp(minimumTemp);
    batch.setProduct(product);
    batch.setSector(sector);
    batch.setInboundOrder(inboundOrder);

    assertEquals(id, batch.getId());
    assertEquals(batchNumber, batch.getBatchNumber());
    assertEquals(initialQuantity, batch.getInitialQuantity());
    assertEquals(actualQuantity, batch.getActualQuantity());
    assertEquals(manufacturingDatetime, batch.getManufacturingDatetime());
    assertEquals(expireDate, batch.getExpireDate());
    assertEquals(registrationTemp, batch.getRegistrationTemp());
    assertEquals(minimumTemp, batch.getMinimumTemp());
    assertEquals(product, batch.getProduct());
    assertEquals(sector, batch.getSector());
    assertEquals(inboundOrder, batch.getInboundOrder());
  }
}
