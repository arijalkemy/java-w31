package com.mercadolibre.melifrescosg9w31.unit.dtos;

import com.mercadolibre.melifrescosg9w31.dtos.response.ProductStockItemResponseDTO;
import com.mercadolibre.melifrescosg9w31.dtos.response.ProductStockResponseDTO;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductStockResponseDTOTest {

    @Test
    void testNoArgsConstructor() {
        ProductStockResponseDTO dto = new ProductStockResponseDTO();
        assertNull(dto.getWarehouseCode());
        assertNull(dto.getProductInfo());
    }

    @Test
    void testAllArgsConstructor() {
        Integer warehouseCode = 123;
        List<ProductStockItemResponseDTO> productInfo = Arrays.asList(
                new ProductStockItemResponseDTO(1L, "Product A", 10),
                new ProductStockItemResponseDTO(2L, "Product B", 20)
        );
        ProductStockResponseDTO dto = new ProductStockResponseDTO(warehouseCode, productInfo);
        assertEquals(warehouseCode, dto.getWarehouseCode());
        assertEquals(productInfo, dto.getProductInfo());
    }

    @Test
    void testGettersAndSetters() {
        ProductStockResponseDTO dto = new ProductStockResponseDTO();

        Integer warehouseCode = 456;
        dto.setWarehouseCode(warehouseCode);
        assertEquals(warehouseCode, dto.getWarehouseCode());

        List<ProductStockItemResponseDTO> productInfo = Collections.singletonList(
                new ProductStockItemResponseDTO(3L, "Product C", 5)
        );
        dto.setProductInfo(productInfo);
        assertEquals(productInfo, dto.getProductInfo());
    }

    @Test
    void testEqualsAndHashCode() {
        List<ProductStockItemResponseDTO> productInfo1 = Arrays.asList(
                new ProductStockItemResponseDTO(1L, "Product A", 10),
                new ProductStockItemResponseDTO(2L, "Product B", 20)
        );
        List<ProductStockItemResponseDTO> productInfo2 = Arrays.asList(
                new ProductStockItemResponseDTO(1L, "Product A", 10),
                new ProductStockItemResponseDTO(2L, "Product B", 20)
        );
        List<ProductStockItemResponseDTO> productInfo3 = Collections.singletonList(
                new ProductStockItemResponseDTO(3L, "Product C", 30)
        );

        ProductStockResponseDTO dto1 = new ProductStockResponseDTO(100, productInfo1);
        ProductStockResponseDTO dto2 = new ProductStockResponseDTO(100, productInfo2);
        ProductStockResponseDTO dto3 = new ProductStockResponseDTO(200, productInfo3);
        ProductStockResponseDTO dto4 = new ProductStockResponseDTO(null, null);
        ProductStockResponseDTO dto5 = new ProductStockResponseDTO(null, null);

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
        Integer warehouseCode = 789;
        List<ProductStockItemResponseDTO> productInfo = Arrays.asList(
                new ProductStockItemResponseDTO(4L, "Product D", 40),
                new ProductStockItemResponseDTO(5L, "Product E", 50)
        );
        ProductStockResponseDTO dto = new ProductStockResponseDTO(warehouseCode, productInfo);
        String expectedToString = "ProductStockResponseDTO(warehouseCode=789, productInfo=[ProductStockItemResponseDTO(productId=4, productName=Product D, currentStock=40), ProductStockItemResponseDTO(productId=5, productName=Product E, currentStock=50)])";
        assertEquals(expectedToString, dto.toString());
    }
}