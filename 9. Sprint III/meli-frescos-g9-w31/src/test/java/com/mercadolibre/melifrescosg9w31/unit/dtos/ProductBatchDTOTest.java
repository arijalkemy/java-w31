package com.mercadolibre.melifrescosg9w31.unit.dtos;

import com.mercadolibre.melifrescosg9w31.dtos.BatchStockDTO;
import com.mercadolibre.melifrescosg9w31.dtos.ProductBatchDTO;
import com.mercadolibre.melifrescosg9w31.dtos.SectionDTO;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductBatchDTOTest {

    @Test
    void testNoArgsConstructor() {
        ProductBatchDTO productBatchDTO = new ProductBatchDTO();
        assertNotNull(productBatchDTO);
        assertNull(productBatchDTO.getId()); // Default value for Long is 0
        assertNull(productBatchDTO.getSection());
        assertNull(productBatchDTO.getBatchStock());
    }


    @Test
    void testGettersAndSetters() {
        ProductBatchDTO productBatchDTO = new ProductBatchDTO();

        SectionDTO sectionDTO = new SectionDTO(2, 202);
        List<BatchStockDTO> batchStockList = new ArrayList<>();
        batchStockList.add(new BatchStockDTO(3, 20, LocalDate.of(2026, 1, 1)));
        Long productId = 456L;

        productBatchDTO.setSection(sectionDTO);
        productBatchDTO.setId(productId);
        productBatchDTO.setBatchStock(batchStockList);

        assertEquals(sectionDTO, productBatchDTO.getSection());
        assertEquals(productId, productBatchDTO.getId());
        assertEquals(batchStockList, productBatchDTO.getBatchStock());

        // Test with different values
        SectionDTO updatedSectionDTO = new SectionDTO(3, 303);
        List<BatchStockDTO> updatedBatchStockList = new ArrayList<>();
        updatedBatchStockList.add(new BatchStockDTO(4, 70, LocalDate.of(2026, 1, 1)));
        Long updatedProductId = 789L;

        productBatchDTO.setSection(updatedSectionDTO);
        productBatchDTO.setId(updatedProductId);
        productBatchDTO.setBatchStock(updatedBatchStockList);

        assertEquals(updatedSectionDTO, productBatchDTO.getSection());
        assertEquals(updatedProductId, productBatchDTO.getId());
        assertEquals(updatedBatchStockList, productBatchDTO.getBatchStock());
    }

    @Test
    void testEmptyBatchStockList() {
        SectionDTO sectionDTO = new SectionDTO(4,404);
        List<BatchStockDTO> emptyBatchStockList = new ArrayList<>();
        Long productId = 999L;

        ProductBatchDTO productBatchDTO = new ProductBatchDTO(sectionDTO, productId, emptyBatchStockList);

        assertEquals(sectionDTO, productBatchDTO.getSection());
        assertEquals(productId, productBatchDTO.getId());
        assertNotNull(productBatchDTO.getBatchStock());
        assertTrue(productBatchDTO.getBatchStock().isEmpty());
    }
}
