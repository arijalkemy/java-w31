package com.mercadolibre.melifrescosg9w31.unit.DTO;

import com.mercadolibre.melifrescosg9w31.dtos.ProductInOrderDTO;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductInOrderDTOTest {
    @Test
    void testAllArgsConstructorAndGetters() {
        Long id = 1L;
        String name = "Producto";
        Integer quantity = 10;
        BigDecimal price = new BigDecimal("99.99");

        ProductInOrderDTO dto = new ProductInOrderDTO(id, name, quantity, price);

        assertEquals(id, dto.getId());
        assertEquals(name, dto.getName());
        assertEquals(quantity, dto.getQuantity());
        assertEquals(price, dto.getPrice());
    }

    @Test
    void testSettersAndNoArgsConstructor() {
        ProductInOrderDTO dto = new ProductInOrderDTO();

        Long id = 2L;
        String name = "Test";
        Integer quantity = 5;
        BigDecimal price = new BigDecimal("12.50");

        dto.setId(id);
        dto.setName(name);
        dto.setQuantity(quantity);
        dto.setPrice(price);

        assertEquals(id, dto.getId());
        assertEquals(name, dto.getName());
        assertEquals(quantity, dto.getQuantity());
        assertEquals(price, dto.getPrice());
    }
}
