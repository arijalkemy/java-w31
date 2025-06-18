package com.mercadolibre.melifrescosg9w31.unit.dtos;

import com.mercadolibre.melifrescosg9w31.dtos.response.ProductStockItemResponseDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductStockItemResponseDTOTest {

    @Test
    void testNoArgsConstructor() {
        ProductStockItemResponseDTO dto = new ProductStockItemResponseDTO();
        assertNull(dto.getProductId());
        assertNull(dto.getProductName());
        assertNull(dto.getCurrentStock());
    }

    @Test
    void testAllArgsConstructor() {
        Long productId = 1L;
        String productName = "Test Product";
        Integer currentStock = 100;
        ProductStockItemResponseDTO dto = new ProductStockItemResponseDTO(productId, productName, currentStock);
        assertEquals(productId, dto.getProductId());
        assertEquals(productName, dto.getProductName());
        assertEquals(currentStock, dto.getCurrentStock());
    }

    @Test
    void testGettersAndSetters() {
        ProductStockItemResponseDTO dto = new ProductStockItemResponseDTO();

        Long productId = 2L;
        dto.setProductId(productId);
        assertEquals(productId, dto.getProductId());

        String productName = "Another Product";
        dto.setProductName(productName);
        assertEquals(productName, dto.getProductName());

        Integer currentStock = 50;
        dto.setCurrentStock(currentStock);
        assertEquals(currentStock, dto.getCurrentStock());
    }

    @Test
    void testEqualsAndHashCode() {
        ProductStockItemResponseDTO dto1 = new ProductStockItemResponseDTO(1L, "Product A", 10);
        ProductStockItemResponseDTO dto2 = new ProductStockItemResponseDTO(1L, "Product A", 10);
        ProductStockItemResponseDTO dto3 = new ProductStockItemResponseDTO(2L, "Product B", 20);
        ProductStockItemResponseDTO dto4 = new ProductStockItemResponseDTO(null, null, null);
        ProductStockItemResponseDTO dto5 = new ProductStockItemResponseDTO(null, null, null);


        assertEquals(dto1, dto2);
        assertNotEquals(dto1, dto3);
        assertNotEquals(dto1, null);
        assertNotEquals(dto1, new Object());
        assertEquals(dto4, dto5);

        assertEquals(dto1.hashCode(), dto2.hashCode());
        assertNotEquals(dto1.hashCode(), dto3.hashCode());
        assertEquals(dto4.hashCode(), dto5.hashCode());
    }

    @Test
    void testToString() {
        Long productId = 3L;
        String productName = "Product C";
        Integer currentStock = 75;
        ProductStockItemResponseDTO dto = new ProductStockItemResponseDTO(productId, productName, currentStock);
        String expectedToString = "ProductStockItemResponseDTO(productId=3, productName=Product C, currentStock=75)";
        assertEquals(expectedToString, dto.toString());
    }
}