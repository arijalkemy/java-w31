package com.mercadolibre.melifrescosg9w31.exceptions;

import com.mercadolibre.melifrescosg9w31.dtos.ProductStockError;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class StockExceptionTest {

    @Test
    void testConstructorWithErrors() {
        ProductStockError error1 = new ProductStockError(1, "Sin stock");
        ProductStockError error2 = new ProductStockError(2, "Producto inexistente");
        List<ProductStockError> errors = Arrays.asList(error1, error2);

        StockException ex = new StockException(errors);

        assertEquals("1: Sin stock, 2: Producto inexistente", ex.getMessage());
        assertEquals(errors, ex.getErrors());
    }

    @Test
    void testConstructorWithEmptyList() {
        List<ProductStockError> errors = Collections.emptyList();
        StockException ex = new StockException(errors);

        assertEquals("Sin detalles", ex.getMessage());
        assertEquals(errors, ex.getErrors());
    }

    @Test
    void testConstructorWithNullList() {
        StockException ex = new StockException(null);

        assertEquals("Sin detalles", ex.getMessage());
        assertNull(ex.getErrors());
    }
}