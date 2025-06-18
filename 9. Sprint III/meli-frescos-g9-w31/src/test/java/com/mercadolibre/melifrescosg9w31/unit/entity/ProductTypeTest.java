package com.mercadolibre.melifrescosg9w31.unit.entity;

import com.mercadolibre.melifrescosg9w31.entity.ProductType;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ProductTypeTest {

  private Validator validator;

  @BeforeEach
  void setUp() {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    validator = factory.getValidator();
  }

    @Test
    void testValidProductType() {
        ProductType productType = new ProductType(1L, "FR", "Frozen", new BigDecimal("-18.0"), new BigDecimal("0.0"));
        Set<ConstraintViolation<ProductType>> violations = validator.validate(productType);
        assertTrue(violations.isEmpty(), "ProductType should be valid");
    }

    @Test
    void testInvalidProductType_NullCategory() {
        ProductType productType = new ProductType(1L, null, "Frozen", new BigDecimal("-18.0"), new BigDecimal("0.0"));
        Set<ConstraintViolation<ProductType>> violations = validator.validate(productType);
        assertFalse(violations.isEmpty(), "ProductType with null category should be invalid");
    }

  @Test
  void testProductTypeGetterSetter() {
    ProductType productType = new ProductType();

    Long id = 1L;
    String category = "FR";
    String name = "Frozen";
    BigDecimal minRequiredTemp = new BigDecimal("-18.0");
    BigDecimal maxRequiredTemp = new BigDecimal("0.0");

    productType.setId(id);
    productType.setCategory(category);
    productType.setName(name);
    productType.setMinRequiredTemp(minRequiredTemp);
    productType.setMaxRequiredTemp(maxRequiredTemp);

    assertEquals(id, productType.getId());
    assertEquals(category, productType.getCategory());
    assertEquals(name, productType.getName());
    assertEquals(minRequiredTemp, productType.getMinRequiredTemp());
    assertEquals(maxRequiredTemp, productType.getMaxRequiredTemp());
  }
    @Test
    void testInvalidProductType_NullName() {
        ProductType productType = new ProductType(1L, "FF", null, new BigDecimal("-18.0"), new BigDecimal("0.0"));
        Set<ConstraintViolation<ProductType>> violations = validator.validate(productType);
        assertFalse(violations.isEmpty(), "ProductType with null name should be invalid");
    }

    @Test
    void testInvalidProductType_NullMinRequiredTemp() {
        ProductType productType = new ProductType(1L, "FF", "Frozen", null, new BigDecimal("0.0"));
        Set<ConstraintViolation<ProductType>> violations = validator.validate(productType);
        assertFalse(violations.isEmpty(), "ProductType with null min_required_temp should be invalid");
    }
}
