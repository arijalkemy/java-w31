package com.mercadolibre.melifrescosg9w31.unit.entity;

import com.mercadolibre.melifrescosg9w31.entity.Product;
import com.mercadolibre.melifrescosg9w31.entity.ProductType;
import com.mercadolibre.melifrescosg9w31.entity.Seller;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testValidProduct() {
        Product product = new Product(1L, "Product Name", "Description", new BigDecimal("10.00"), new ProductType(), new Seller());
        Set<ConstraintViolation<Product>> violations = validator.validate(product);
        assertTrue(violations.isEmpty(), "Product should be valid");
    }

    @Test
    void testInvalidProduct_NullName() {
        Product product = new Product(1L, null, "Description", new BigDecimal("10.00"), new ProductType(), new Seller());
        Set<ConstraintViolation<Product>> violations = validator.validate(product);
        assertFalse(violations.isEmpty(), "Product with null name should be invalid");
    }

    @Test
    void testGettersAndSetters() {
        Product product = new Product(1L, "Product Name", "Description", new BigDecimal("10.00"), new ProductType(), new Seller());

        Long id = 1L;
        String name = "Test Product";
        String description = "Test Description";
        BigDecimal price = new BigDecimal("10.99");
        ProductType productType = new ProductType();
        Seller seller = new Seller();

        product.setId(id);
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setProductType(productType);
        product.setSeller(seller);

        assertEquals(id, product.getId());
        assertEquals(name, product.getName());
        assertEquals(description, product.getDescription());
        assertEquals(price, product.getPrice());
        assertEquals(productType, product.getProductType());
        assertEquals(seller, product.getSeller());
    }
}
