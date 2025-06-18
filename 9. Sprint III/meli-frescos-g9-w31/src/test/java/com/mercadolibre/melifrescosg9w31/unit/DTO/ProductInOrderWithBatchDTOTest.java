package com.mercadolibre.melifrescosg9w31.unit.DTO;

import com.mercadolibre.melifrescosg9w31.dtos.ProductInOrderWithBatchDTO;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductInOrderWithBatchDTOTest {
    @Test
    void testAllArgsConstructorAndGetters() {
        Long productId = 1L;
        String productName = "Producto";
        Integer amount = 10;
        BigDecimal unitPrice = new BigDecimal("99.99");
        Long batchId = 2L;
        LocalDate batchExpireDate = LocalDate.now().plusDays(10);

        ProductInOrderWithBatchDTO dto = new ProductInOrderWithBatchDTO(
                productId, productName, amount, unitPrice, batchId, batchExpireDate
        );

        assertEquals(productId, dto.getProductId());
        assertEquals(productName, dto.getProductName());
        assertEquals(amount, dto.getAmount());
        assertEquals(unitPrice, dto.getUnitPrice());
        assertEquals(batchId, dto.getBatchId());
        assertEquals(batchExpireDate, dto.getBatchExpireDate());
    }

    @Test
    void testSettersAndNoArgsConstructor() {
        ProductInOrderWithBatchDTO dto = new ProductInOrderWithBatchDTO();

        Long productId = 5L;
        String productName = "Test";
        Integer amount = 3;
        BigDecimal unitPrice = new BigDecimal("12.50");
        Long batchId = 7L;
        LocalDate batchExpireDate = LocalDate.now();

        dto.setProductId(productId);
        dto.setProductName(productName);
        dto.setAmount(amount);
        dto.setUnitPrice(unitPrice);
        dto.setBatchId(batchId);
        dto.setBatchExpireDate(batchExpireDate);

        assertEquals(productId, dto.getProductId());
        assertEquals(productName, dto.getProductName());
        assertEquals(amount, dto.getAmount());
        assertEquals(unitPrice, dto.getUnitPrice());
        assertEquals(batchId, dto.getBatchId());
        assertEquals(batchExpireDate, dto.getBatchExpireDate());
    }
}
