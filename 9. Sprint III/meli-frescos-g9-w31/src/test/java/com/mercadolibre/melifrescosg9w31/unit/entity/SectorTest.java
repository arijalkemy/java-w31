package com.mercadolibre.melifrescosg9w31.unit.entity;

import com.mercadolibre.melifrescosg9w31.entity.ProductType;
import com.mercadolibre.melifrescosg9w31.entity.Sector;
import com.mercadolibre.melifrescosg9w31.entity.Warehouse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SectorTest {

  private Validator validator;

  @BeforeEach
  void setUp() {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    validator = factory.getValidator();
  }

    @Test
    void testValidSector() {
        Sector sector = new Sector(1L, new ProductType(), 1, "Sector Name", 0, 100, null, new Warehouse());
        Set<ConstraintViolation<Sector>> violations = validator.validate(sector);
        assertTrue(violations.isEmpty(), "Sector should be valid");
    }

    @Test
    void testInvalidSector_NullSectionCode() {
        Sector sector = new Sector(1L, new ProductType(), null, "Sector Name", 0, 100, null, new Warehouse());
        Set<ConstraintViolation<Sector>> violations = validator.validate(sector);
        assertFalse(violations.isEmpty(), "Sector with null section code should be invalid");
    }

  @Test
  void testGettersAndSetters() {
    Sector sector = new Sector();

        Long id = 1L;
        ProductType productType = new ProductType();
        Integer sectionCode = 1;
        String name = "Test Sector";
        Integer currentCapacity = 50;
        Integer maxCapacity = 100;
        BigDecimal temp = new BigDecimal("5.5");
        Warehouse warehouse = new Warehouse();

    sector.setId(id);
    sector.setProductType(productType);
    sector.setSectorCode(sectionCode);
    sector.setName(name);
    sector.setCurrentCapacity(currentCapacity);
    sector.setMaxCapacity(maxCapacity);
    sector.setTemp(temp);
    sector.setWarehouse(warehouse);

    assertEquals(id, sector.getId());
    assertEquals(productType, sector.getProductType());
    assertEquals(sectionCode, sector.getSectorCode());
    assertEquals(name, sector.getName());
    assertEquals(currentCapacity, sector.getCurrentCapacity());
    assertEquals(maxCapacity, sector.getMaxCapacity());
    assertEquals(temp, sector.getTemp());
    assertEquals(warehouse, sector.getWarehouse());
  }
}
