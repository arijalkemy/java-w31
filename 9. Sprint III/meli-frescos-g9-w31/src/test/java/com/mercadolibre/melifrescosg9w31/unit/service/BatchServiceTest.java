package com.mercadolibre.melifrescosg9w31.unit.service;

import com.mercadolibre.melifrescosg9w31.dtos.response.BatchItemResponseDTO;
import com.mercadolibre.melifrescosg9w31.dtos.response.BatchResponseDTO;
import com.mercadolibre.melifrescosg9w31.exceptions.BadRequestException;
import com.mercadolibre.melifrescosg9w31.exceptions.NotFoundException;
import com.mercadolibre.melifrescosg9w31.mapper.BatchMapper;
import com.mercadolibre.melifrescosg9w31.repository.IBatchRepository;
import com.mercadolibre.melifrescosg9w31.service.BatchService;
import com.mercadolibre.melifrescosg9w31.utils.CustomFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BatchServiceTest {

    @Mock
    private IBatchRepository batchRepository;

    @InjectMocks
    private BatchService batchService;

    @Test
    @DisplayName("Happy Path getExpiringBatches")
    void testGetExpiringBatchesHappyPath() {
        //Arrange
        LocalDate today = LocalDate.now();
        LocalDate futureDate = LocalDate.now().plusDays(21);
        when(batchRepository.findBatchesWithDueDateBetweenOrderedAsc(today, futureDate)).thenReturn(CustomFactory.getBatchesOrderedAsc());
        List<BatchItemResponseDTO> batchDtos = CustomFactory.getBatchesOrderedAsc().stream().map(BatchMapper::toBatchItemResponseDTO).toList();
        BatchResponseDTO expectedResponse = new BatchResponseDTO(batchDtos);

        //Act
        BatchResponseDTO batchesDto = batchService.getExpiringBatches(21, null, null);

        //Assert
        assertEquals(expectedResponse, batchesDto);
    }

    @Test
    @DisplayName("Happy Path with params getExpiringBatches")
    void testGetExpiringBatchesHappyPathWithParamsAsc() {
        //Arrange
        LocalDate today = LocalDate.now();
        LocalDate futureDate = LocalDate.now().plusDays(21);
        when(batchRepository.findBatchesWithDueDateBetweenFromCategoryOrderedAsc(today, futureDate, "FF")).thenReturn(CustomFactory.getBatchesOrderedAsc());
        List<BatchItemResponseDTO> batchDtos = CustomFactory.getBatchesOrderedAsc().stream().map(BatchMapper::toBatchItemResponseDTO).toList();
        BatchResponseDTO expectedResponse = new BatchResponseDTO(batchDtos);

        //Act
        BatchResponseDTO batchesDto = batchService.getExpiringBatches(21, "FF", "date_asc");

        //Assert
        assertEquals(expectedResponse, batchesDto);
    }

    @Test
    @DisplayName("Happy Path with params getExpiringBatches")
    void testGetExpiringBatchesHappyPathWithParamsDesc() {
        //Arrange
        LocalDate today = LocalDate.now();
        LocalDate futureDate = LocalDate.now().plusDays(21);
        when(batchRepository.findBatchesWithDueDateBetweenFromCategoryOrderedDesc(today, futureDate, "FF")).thenReturn(CustomFactory.getBatchesOrderedDesc());
        List<BatchItemResponseDTO> batchDtos = CustomFactory.getBatchesOrderedDesc().stream().map(BatchMapper::toBatchItemResponseDTO).toList();
        BatchResponseDTO expectedResponse = new BatchResponseDTO(batchDtos);

        //Act
        BatchResponseDTO batchesDto = batchService.getExpiringBatches(21, "FF", "date_desc");

        //Assert
        assertEquals(expectedResponse, batchesDto);
    }

    @Test
    @DisplayName("Invalid order getExpiringBatches")
    void testGetExpiringBatchesInvalidOrder() {
        //Arrange

        //Act + Assert
        Exception exception = assertThrows(BadRequestException.class, () -> batchService.getExpiringBatches(100, "FF", "invalid"));
        assertEquals("Order not valid.", exception.getMessage());
    }

    @Test
    @DisplayName("NotFound getExpiringBatches")
    void testGetExpiringBatchesNotFound() {
        //Arrange
        LocalDate today = LocalDate.now();
        LocalDate date = LocalDate.now().minusDays(1);
        when(batchRepository.findBatchesWithDueDateBetweenOrderedAsc(today, date)).thenReturn(new ArrayList<>());

        //Act + Assert
        Exception exception = assertThrows(NotFoundException.class, () -> batchService.getExpiringBatches(-1, null, null));
        assertEquals("There are no batches that expire in that time.", exception.getMessage());
    }

    @Test
    @DisplayName("noOrder getExpiringBatches")
    void testGetExpiringBatchesBadRequestNoOrder() {
        //Arrange

        //Act + Assert
        Exception exception = assertThrows(BadRequestException.class, () -> batchService.getExpiringBatches(-1, "category", null));
        assertEquals("Both filter values must be provided.", exception.getMessage());
    }

    @Test
    @DisplayName("noCategory getExpiringBatches")
    void testGetExpiringBatchesBadRequestNoCategory() {
        //Arrange

        //Act + Assert
        Exception exception = assertThrows(BadRequestException.class, () -> batchService.getExpiringBatches(-1, null, "date_asc"));
        assertEquals("Both filter values must be provided.", exception.getMessage());
    }
}