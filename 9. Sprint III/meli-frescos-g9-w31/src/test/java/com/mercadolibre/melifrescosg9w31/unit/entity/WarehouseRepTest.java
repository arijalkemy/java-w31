package com.mercadolibre.melifrescosg9w31.unit.entity;

import com.mercadolibre.melifrescosg9w31.entity.UserAccount;
import com.mercadolibre.melifrescosg9w31.entity.Warehouse;
import com.mercadolibre.melifrescosg9w31.entity.WarehouseRep;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class WarehouseRepTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testValidWarehouseRep() {
        WarehouseRep warehouseRep = new WarehouseRep(1L, "John Doe", "Manager", new Warehouse(),new UserAccount());
        Set<ConstraintViolation<WarehouseRep>> violations = validator.validate(warehouseRep);
        assertTrue(violations.isEmpty(), "WarehouseRep should be valid");
    }

    @Test
    void testInvalidWarehouseRep_NullName() {
        WarehouseRep warehouseRep = new WarehouseRep(1L, null, "Manager", new Warehouse(),new UserAccount());
        Set<ConstraintViolation<WarehouseRep>> violations = validator.validate(warehouseRep);
        assertFalse(violations.isEmpty(), "WarehouseRep with null name should be invalid");
    }

    @Test
    void testInvalidWarehouseRep_NullWarehouse() {
        WarehouseRep warehouseRep = new WarehouseRep(1L, "John Doe", "Manager", null,null);
        Set<ConstraintViolation<WarehouseRep>> violations = validator.validate(warehouseRep);
        assertFalse(violations.isEmpty(), "WarehouseRep with null warehouse should be invalid");
    }
    @Test
    void testAllArgsConstructorAndGetters() {
        Warehouse warehouse = mock(Warehouse.class);
        UserAccount user = mock(UserAccount.class);

        WarehouseRep rep = new WarehouseRep(1L, "Juan", "Supervisor", warehouse, user);

        assertEquals(1L, rep.getId());
        assertEquals("Juan", rep.getName());
        assertEquals("Supervisor", rep.getRole());
        assertEquals(warehouse, rep.getWarehouse());
        assertEquals(user, rep.getUser());
    }

    @Test
    void testSettersAndNoArgsConstructor() {
        WarehouseRep rep = new WarehouseRep();
        Warehouse warehouse = mock(Warehouse.class);
        UserAccount user = mock(UserAccount.class);

        rep.setId(2L);
        rep.setName("Ana");
        rep.setRole("Admin");
        rep.setWarehouse(warehouse);
        rep.setUser(user);

        assertEquals(2L, rep.getId());
        assertEquals("Ana", rep.getName());
        assertEquals("Admin", rep.getRole());
        assertEquals(warehouse, rep.getWarehouse());
        assertEquals(user, rep.getUser());
    }

    @Test
    void testToString() {
        Warehouse warehouse = mock(Warehouse.class);
        UserAccount user = mock(UserAccount.class);
        WarehouseRep rep = new WarehouseRep(3L, "Pedro", "Operario", warehouse, user);

        String str = rep.toString();
        assertTrue(str.contains("Pedro"));
        assertTrue(str.contains("Operario"));
    }

    @Test
    void testEqualsAndHashCode() {
        Warehouse warehouse = mock(Warehouse.class);
        UserAccount user = mock(UserAccount.class);

        WarehouseRep rep1 = new WarehouseRep(4L, "Maria", "Jefa", warehouse, user);
        WarehouseRep rep2 = new WarehouseRep(4L, "Maria", "Jefa", warehouse, user);

        assertEquals(rep1, rep2);
        assertEquals(rep1.hashCode(), rep2.hashCode());
    }
}
