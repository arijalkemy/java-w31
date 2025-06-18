package com.mercadolibre.melifrescosg9w31.unit.entity;

import com.mercadolibre.melifrescosg9w31.entity.Warehouse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testValidWarehouse() {
        Warehouse warehouse = new Warehouse(1L, 1, "Main Warehouse", "Location details");
        Set<ConstraintViolation<Warehouse>> violations = validator.validate(warehouse);
        assertTrue(violations.isEmpty(), "Warehouse should be valid");
    }

    @Test
    void testInvalidWarehouse_NullWarehouseCode() {
        Warehouse warehouse = new Warehouse(1L, null, "Main Warehouse", "Location details");
        Set<ConstraintViolation<Warehouse>> violations = validator.validate(warehouse);
        assertFalse(violations.isEmpty(), "Warehouse with null warehouseCode should be invalid");
    }

    @Test
    void testInvalidWarehouse_NullName() {
        Warehouse warehouse = new Warehouse(1L, 1, null, "Location details");
        Set<ConstraintViolation<Warehouse>> violations = validator.validate(warehouse);
        assertFalse(violations.isEmpty(), "Warehouse with null name should be invalid");
    }

    @Test
    void testGettersAndSetters() {
        Warehouse warehouse = new Warehouse();

        Long id = 1L;
        Integer code = 1;
        String name = "Test Warehouse";
        String location = "Test Location";

        warehouse.setId(id);
        warehouse.setName(name);
        warehouse.setLocation(location);
        warehouse.setWarehouseCode(code);

        assertEquals(id, warehouse.getId());
        assertEquals(name, warehouse.getName());
        assertEquals(location, warehouse.getLocation());
        assertEquals(code, warehouse.getWarehouseCode());
    }
}