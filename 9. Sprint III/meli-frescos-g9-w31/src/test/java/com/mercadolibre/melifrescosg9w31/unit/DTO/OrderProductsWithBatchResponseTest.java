package com.mercadolibre.melifrescosg9w31.unit.DTO;

import com.mercadolibre.melifrescosg9w31.dtos.ProductInOrderWithBatchDTO;
import com.mercadolibre.melifrescosg9w31.dtos.response.OrderProductsWithBatchResponse;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OrderProductsWithBatchResponseTest {

    @Test
    void testAllArgsConstructorAndGetters() {
        Long orderId = 10L;
        List<ProductInOrderWithBatchDTO> products = Arrays.asList(new ProductInOrderWithBatchDTO(), new ProductInOrderWithBatchDTO());
        OrderProductsWithBatchResponse dto = new OrderProductsWithBatchResponse(orderId, products);

        assertEquals(orderId, dto.getOrderId());
        assertEquals(products, dto.getProducts());
    }

    @Test
    void testSettersAndNoArgsConstructor() {
        OrderProductsWithBatchResponse dto = new OrderProductsWithBatchResponse();
        Long orderId = 20L;
        List<ProductInOrderWithBatchDTO> products = Collections.singletonList(new ProductInOrderWithBatchDTO());

        dto.setOrderId(orderId);
        dto.setProducts(products);

        assertEquals(orderId, dto.getOrderId());
        assertEquals(products, dto.getProducts());
    }

    @Test
    void testToString() {
        OrderProductsWithBatchResponse dto = new OrderProductsWithBatchResponse(1L, Collections.emptyList());
        assertTrue(dto.toString().contains("1"));
    }

    @Test
    void testEqualsAndHashCode() {
        List<ProductInOrderWithBatchDTO> products = Collections.singletonList(new ProductInOrderWithBatchDTO());
        OrderProductsWithBatchResponse dto1 = new OrderProductsWithBatchResponse(1L, products);
        OrderProductsWithBatchResponse dto2 = new OrderProductsWithBatchResponse(1L, products);

        assertEquals(dto1, dto2);
        assertEquals(dto1.hashCode(), dto2.hashCode());
    }
}