package com.mercadolibre.melifrescosg9w31.unit.DTO;

import com.mercadolibre.melifrescosg9w31.dtos.ProductStockError;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductStockErrorTest {
    @Test
    void testAllArgsConstructorAndGetters() {
        ProductStockError error = new ProductStockError(10, "Sin stock");
        assertEquals(10, error.getProductId());
        assertEquals("Sin stock", error.getError());
    }

    @Test
    void testSettersAndNoArgsConstructor() {
        ProductStockError error = new ProductStockError();
        error.setProductId(5);
        error.setError("Error de stock");
        assertEquals(5, error.getProductId());
        assertEquals("Error de stock", error.getError());
    }
}
