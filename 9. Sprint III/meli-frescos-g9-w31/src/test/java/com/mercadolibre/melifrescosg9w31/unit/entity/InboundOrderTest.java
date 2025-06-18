package com.mercadolibre.melifrescosg9w31.unit.entity;

import com.mercadolibre.melifrescosg9w31.entity.InboundOrder;
import com.mercadolibre.melifrescosg9w31.entity.Warehouse;
import com.mercadolibre.melifrescosg9w31.entity.WarehouseRep;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class InboundOrderTest {

  private Validator validator;

  @BeforeEach
  void setUp() {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    validator = factory.getValidator();
  }

  @Test
  void testValidInboundOrder() {
    InboundOrder inboundOrder = new InboundOrder(1L, 12345, LocalDate.now(),  new WarehouseRep(), new Warehouse());
    Set<ConstraintViolation<InboundOrder>> violations = validator.validate(inboundOrder);
    assertTrue(violations.isEmpty(), "InboundOrder should be valid");
  }

  @Test
  void testInvalidInboundOrder_NullOrderNumber() {
    InboundOrder inboundOrder = new InboundOrder(1L, null, LocalDate.now(), new WarehouseRep(), new Warehouse());
    Set<ConstraintViolation<InboundOrder>> violations = validator.validate(inboundOrder);
    assertFalse(violations.isEmpty(), "InboundOrder with null order number should be invalid");
  }

  @Test
  void testGettersAndSetters() {
    InboundOrder inboundOrder = new InboundOrder();

    Long id = 1L;
    Integer orderNumber = 12345;
    LocalDate orderDate = LocalDate.now();
    WarehouseRep rep = new WarehouseRep();
    Warehouse warehouse = new Warehouse();

    inboundOrder.setId(id);
    inboundOrder.setOrderNumber(orderNumber);
    inboundOrder.setOrderDate(orderDate);
        inboundOrder.setRep(rep);
        inboundOrder.setWarehouse(warehouse);

    assertEquals(id, inboundOrder.getId());
    assertEquals(orderNumber, inboundOrder.getOrderNumber());
    assertEquals(orderDate, inboundOrder.getOrderDate());
        assertEquals(rep, inboundOrder.getRep());
        assertEquals(warehouse, inboundOrder.getWarehouse());
    }
}
