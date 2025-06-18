package com.mercadolibre.melifrescosg9w31.dtos;

import com.mercadolibre.melifrescosg9w31.dtos.response.BatchItemResponseDTO;
import com.mercadolibre.melifrescosg9w31.dtos.response.BatchResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BatchResponseDTOTest {

    private BatchResponseDTO batchResponseDTO;

    @BeforeEach
    void setUp() {
        // Initialize for each test to ensure a clean state
        batchResponseDTO = new BatchResponseDTO();
    }

    @Test
    void testNoArgsConstructor() {
        // Verify that the no-args constructor creates a non-null object
        assertNotNull(batchResponseDTO);
        // Verify that batchStock is null or empty by default (depends on Lombok's default for List)
        assertNull(batchResponseDTO.getBatchStock());
    }

    @Test
    void testAllArgsConstructor() {
        // Create some dummy BatchItemResponseDTO objects
        BatchItemResponseDTO item1 = new BatchItemResponseDTO(); // Assuming BatchItemResponseDTO has a no-args constructor
        item1.setBatchNumber(1);
        BatchItemResponseDTO item2 = new BatchItemResponseDTO();
        item2.setBatchNumber(2);

        List<BatchItemResponseDTO> batchStockList = Arrays.asList(item1, item2);

        // Use the all-args constructor
        batchResponseDTO = new BatchResponseDTO(batchStockList);

        // Verify that the list is set correctly
        assertNotNull(batchResponseDTO.getBatchStock());
        assertEquals(2, batchResponseDTO.getBatchStock().size());
        assertTrue(batchResponseDTO.getBatchStock().contains(item1));
        assertTrue(batchResponseDTO.getBatchStock().contains(item2));
    }

    @Test
    void testGetAndSetBatchStock() {
        List<BatchItemResponseDTO> initialList = Collections.singletonList(new BatchItemResponseDTO());
        batchResponseDTO.setBatchStock(initialList);

        // Verify getter returns the same list
        assertEquals(initialList, batchResponseDTO.getBatchStock());

        // Test with a different list
        List<BatchItemResponseDTO> newList = Arrays.asList(new BatchItemResponseDTO(), new BatchItemResponseDTO());
        batchResponseDTO.setBatchStock(newList);
        assertEquals(newList, batchResponseDTO.getBatchStock());
    }

    @Test
    void testEqualsAndHashCode() {
        // Create two DTOs with the same content
        BatchItemResponseDTO itemA = new BatchItemResponseDTO();
        itemA.setBatchNumber(10);
        List<BatchItemResponseDTO> list1 = Collections.singletonList(itemA);
        BatchResponseDTO dto1 = new BatchResponseDTO(list1);

        BatchItemResponseDTO itemB = new BatchItemResponseDTO();
        itemB.setBatchNumber(10);
        List<BatchItemResponseDTO> list2 = Collections.singletonList(itemB);
        BatchResponseDTO dto2 = new BatchResponseDTO(list2);

        // Test equality
        assertEquals(dto1, dto2);
        // Test hash code
        assertEquals(dto1.hashCode(), dto2.hashCode());

        // Create a DTO with different content
        BatchItemResponseDTO itemC = new BatchItemResponseDTO();
        itemC.setBatchNumber(20);
        List<BatchItemResponseDTO> list3 = Collections.singletonList(itemC);
        BatchResponseDTO dto3 = new BatchResponseDTO(list3);

        // Test inequality
        assertNotEquals(dto1, dto3);
        // Test hash code inequality (though not strictly required to be different)
        assertNotEquals(dto1.hashCode(), dto3.hashCode()); // This usually holds true if equals is different
    }

    @Test
    void testToString() {
        // Just verify that toString does not throw an error and contains expected parts
        BatchItemResponseDTO item = new BatchItemResponseDTO();
        item.setBatchNumber(100);
        List<BatchItemResponseDTO> list = Collections.singletonList(item);
        batchResponseDTO.setBatchStock(list);

        String toStringResult = batchResponseDTO.toString();
        assertNotNull(toStringResult);
        assertTrue(toStringResult.contains("BatchResponseDTO"));
        assertTrue(toStringResult.contains("batchStock"));
        assertTrue(toStringResult.contains("batchNumber=100")); // Verify content from inner DTO
    }
}