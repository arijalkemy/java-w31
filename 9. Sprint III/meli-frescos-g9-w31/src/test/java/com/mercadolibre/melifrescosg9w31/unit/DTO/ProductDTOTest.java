package com.mercadolibre.melifrescosg9w31.unit.DTO;

import com.mercadolibre.melifrescosg9w31.dtos.ProductDTO;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProductDTOTest {

    @Test
    void testAllArgsConstructorAndGetters() {
        Long id = 1L;
        String name = "Producto";
        String description = "Desc";
        BigDecimal price = new BigDecimal("99.99");
        String productType = "TIPO";
        String sellerName = "Vendedor";

        ProductDTO dto = new ProductDTO(id, name, description, price, productType, sellerName);

        assertEquals(id, dto.getId());
        assertEquals(name, dto.getName());
        assertEquals(description, dto.getDescription());
        assertEquals(price, dto.getPrice());
        assertEquals(productType, dto.getProductType());
        assertEquals(sellerName, dto.getSellerName());
    }

    @Test
    void testSettersAndNoArgsConstructor() {
        ProductDTO dto = new ProductDTO();

        Long id = 2L;
        String name = "Test";
        String description = "TestDesc";
        BigDecimal price = new BigDecimal("12.50");
        String productType = "TYPE";
        String sellerName = "Seller";

        dto.setId(id);
        dto.setName(name);
        dto.setDescription(description);
        dto.setPrice(price);
        dto.setProductType(productType);
        dto.setSellerName(sellerName);

        assertEquals(id, dto.getId());
        assertEquals(name, dto.getName());
        assertEquals(description, dto.getDescription());
        assertEquals(price, dto.getPrice());
        assertEquals(productType, dto.getProductType());
        assertEquals(sellerName, dto.getSellerName());
    }

    @Test
    void testToString() {
        ProductDTO dto = new ProductDTO(1L, "A", "B", BigDecimal.ONE, "C", "D");
        assertTrue(dto.toString().contains("A"));
        assertTrue(dto.toString().contains("B"));
    }

    @Test
    void testEqualsAndHashCode() {
        ProductDTO dto1 = new ProductDTO(1L, "A", "B", BigDecimal.ONE, "C", "D");
        ProductDTO dto2 = new ProductDTO(1L, "A", "B", BigDecimal.ONE, "C", "D");
        assertEquals(dto1, dto2);
        assertEquals(dto1.hashCode(), dto2.hashCode());
    }
}