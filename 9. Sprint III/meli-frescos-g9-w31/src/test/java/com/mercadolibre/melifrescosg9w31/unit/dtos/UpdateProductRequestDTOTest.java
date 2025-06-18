package com.mercadolibre.melifrescosg9w31.unit.dtos.request;

import com.mercadolibre.melifrescosg9w31.dtos.request.UpdateProductRequestDTO;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class UpdateProductRequestDTOTest {

    @Test
    void testNoArgsConstructor() {
        UpdateProductRequestDTO dto = new UpdateProductRequestDTO();
        assertNull(dto.getProductName());
        assertNull(dto.getProductDescription());
        assertNull(dto.getProductPrice());
    }

    @Test
    void testAllArgsConstructor() {
        String productName = "Test Product";
        String productDescription = "This is a test product description.";
        BigDecimal productPrice = new BigDecimal("10.99");
        UpdateProductRequestDTO dto = new UpdateProductRequestDTO(productName, productDescription, productPrice);
        assertEquals(productName, dto.getProductName());
        assertEquals(productDescription, dto.getProductDescription());
        assertEquals(productPrice, dto.getProductPrice());
    }

    @Test
    void testBuilder() {
        String productName = "Built Product";
        String productDescription = "This is a product built with the builder.";
        BigDecimal productPrice = new BigDecimal("25.50");
        UpdateProductRequestDTO dto = UpdateProductRequestDTO.builder()
                .productName(productName)
                .productDescription(productDescription)
                .productPrice(productPrice)
                .build();
        assertEquals(productName, dto.getProductName());
        assertEquals(productDescription, dto.getProductDescription());
        assertEquals(productPrice, dto.getProductPrice());
    }

    @Test
    void testGettersAndSetters() {
        UpdateProductRequestDTO dto = new UpdateProductRequestDTO();

        String productName = "Set Product";
        dto.setProductName(productName);
        assertEquals(productName, dto.getProductName());

        String productDescription = "Set product description.";
        dto.setProductDescription(productDescription);
        assertEquals(productDescription, dto.getProductDescription());

        BigDecimal productPrice = new BigDecimal("5.00");
        dto.setProductPrice(productPrice);
        assertEquals(productPrice, dto.getProductPrice());
    }

    @Test
    void testEqualsAndHashCode() {
        UpdateProductRequestDTO dto1 = new UpdateProductRequestDTO("ProductA", "DescriptionA", new BigDecimal("10.00"));
        UpdateProductRequestDTO dto2 = new UpdateProductRequestDTO("ProductA", "DescriptionA", new BigDecimal("10.00"));
        UpdateProductRequestDTO dto3 = new UpdateProductRequestDTO("ProductB", "DescriptionB", new BigDecimal("20.00"));
        UpdateProductRequestDTO dto4 = new UpdateProductRequestDTO(null, null, null);
        UpdateProductRequestDTO dto5 = new UpdateProductRequestDTO(null, null, null);


        assertEquals(dto1, dto2);
        assertNotEquals(dto1, dto3);
        assertNotEquals(dto1, null);
        assertNotEquals(dto1, new Object());
        assertEquals(dto4, dto5);
        assertNotEquals(dto1.hashCode(), dto3.hashCode());
        assertEquals(dto1.hashCode(), dto2.hashCode());
        assertEquals(dto4.hashCode(), dto5.hashCode());
    }

    @Test
    void testToString() {
        String productName = "ToString Product";
        String productDescription = "Description for toString test.";
        BigDecimal productPrice = new BigDecimal("123.45");
        UpdateProductRequestDTO dto = new UpdateProductRequestDTO(productName, productDescription, productPrice);
        String expectedToString = "UpdateProductRequestDTO(productName=ToString Product, productDescription=Description for toString test., productPrice=123.45)";
        assertEquals(expectedToString, dto.toString());
    }
}