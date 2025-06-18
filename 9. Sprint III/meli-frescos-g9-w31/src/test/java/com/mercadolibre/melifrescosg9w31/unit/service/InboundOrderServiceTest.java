package com.mercadolibre.melifrescosg9w31.unit.service;

import com.mercadolibre.melifrescosg9w31.dtos.BatchStockDTO;
import com.mercadolibre.melifrescosg9w31.dtos.request.InboundOrderRequest;
import com.mercadolibre.melifrescosg9w31.dtos.request.SectorRequestDTO;
import com.mercadolibre.melifrescosg9w31.dtos.response.ResponseBatchStockWrapperDTO;
import com.mercadolibre.melifrescosg9w31.entity.*;
import com.mercadolibre.melifrescosg9w31.exceptions.BadRequestException;
import com.mercadolibre.melifrescosg9w31.repository.IInboundOrderRepository;
import com.mercadolibre.melifrescosg9w31.service.BatchProcessor;
import com.mercadolibre.melifrescosg9w31.service.InboundService;
import com.mercadolibre.melifrescosg9w31.service.validator.InboundOrderValidator;
import com.mercadolibre.melifrescosg9w31.utils.CustomFactory;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class InboundOrderServiceTest {

    @Mock
    private IInboundOrderRepository inboundOrderRepository;

    @Mock
    private InboundOrderValidator validator;

    @Mock
    private BatchProcessor batchProcessor; // Mock del BatchProcessor

    @InjectMocks
    private InboundService inboundOrderService;

    private InboundOrderRequest inboundOrderRequest;
    private InboundOrder inboundOrder;
    private WarehouseRep representative;
    private Warehouse warehouse;
    private Sector sector;
    private List<Batch> batches;
    private List<BatchStockDTO> batchStockDTOs;
    private Product product;

    @BeforeEach
    void setUp() {
        setupTestData();
    }

    @Test
    @DisplayName("Should successfully update inbound order with valid data")
    void updateInboundOrder_ValidData_ShouldReturnUpdatedBatches() {
        // Arrange
        Long authenticatedRepId = 1L;
        setupMocks();

        // Act
        ResponseBatchStockWrapperDTO result =
                inboundOrderService.updateInboundOrder(inboundOrderRequest, authenticatedRepId);

        // Assert
        assertNotNull(result);
        assertNotNull(result.getBatchStock());
        assertEquals(1, result.getBatchStock().size());

        // Verify all validations were called
        verify(validator).validateInboundOrderExist(inboundOrderRequest.getOrderNumber());
        verify(validator).validateAndGetRepresentative(authenticatedRepId);
        verify(validator).validateAndGetWarehouse(inboundOrderRequest.getSection().getWarehouseCode());
        verify(validator).validateRepresentativeWarehouseAccess(representative, warehouse);
        verify(validator)
                .validateAndGetSector(warehouse, inboundOrderRequest.getSection().getSectorCode());
        verify(validator).validateBatchRequest(inboundOrderRequest.getBatchStock(), sector);

        // Verify BatchProcessor was called
        verify(batchProcessor).updateBatches(inboundOrder, inboundOrderRequest.getBatchStock());

        // Verify inbound order was saved
        verify(inboundOrderRepository).save(inboundOrder);
    }

    @Test
    @DisplayName("Should throw BadRequestException when BatchProcessor throws exception")
    void updateInboundOrder_BatchProcessorFails_ShouldThrowBadRequestException() {
        // Arrange
        Long authenticatedRepId = 1L;
        setupMocksForBatchProcessorFailure();

        // Act & Assert
        BadRequestException exception =
                assertThrows(
                        BadRequestException.class,
                        () -> inboundOrderService.updateInboundOrder(inboundOrderRequest, authenticatedRepId));

        assertTrue(exception.getMessage().contains("Batch not found with batch_number"));

        // Verify validations were called up to the point of failure
        verify(validator).validateInboundOrderExist(inboundOrderRequest.getOrderNumber());
        verify(validator).validateAndGetRepresentative(authenticatedRepId);
        verify(validator).validateAndGetWarehouse(inboundOrderRequest.getSection().getWarehouseCode());
        verify(validator).validateRepresentativeWarehouseAccess(representative, warehouse);
        verify(validator)
                .validateAndGetSector(warehouse, inboundOrderRequest.getSection().getSectorCode());
        verify(validator).validateBatchRequest(inboundOrderRequest.getBatchStock(), sector);

        // Verify BatchProcessor was called but failed
        verify(batchProcessor).updateBatches(inboundOrder, inboundOrderRequest.getBatchStock());

        // Verify inbound order save was not called due to failure
        verify(inboundOrderRepository, never()).save(any(InboundOrder.class));
    }

    @Test
    @DisplayName("Should throw EntityNotFoundException when BatchProcessor throws EntityNotFoundException")
    void updateInboundOrder_ProductNotFound_ShouldThrowEntityNotFoundException() {
        // Arrange
        Long authenticatedRepId = 1L;
        setupMocksForProductNotFound();

        // Act & Assert
        EntityNotFoundException exception =
                assertThrows(
                        EntityNotFoundException.class,
                        () -> inboundOrderService.updateInboundOrder(inboundOrderRequest, authenticatedRepId));

        assertTrue(exception.getMessage().contains("Product not found with id"));

        // Verify BatchProcessor was called
        verify(batchProcessor).updateBatches(inboundOrder, inboundOrderRequest.getBatchStock());

        // Verify inbound order save was not called due to failure
        verify(inboundOrderRepository, never()).save(any(InboundOrder.class));
    }

    @Test
    @DisplayName("Should update multiple batches successfully")
    void updateInboundOrder_MultipleBatches_ShouldUpdateAll() {
        // Arrange
        Long authenticatedRepId = 1L;
        setupMultipleBatchesData();
        setupMocksForMultipleBatches();

        // Act
        ResponseBatchStockWrapperDTO result =
                inboundOrderService.updateInboundOrder(inboundOrderRequest, authenticatedRepId);

        // Assert
        assertNotNull(result);
        assertEquals(2, result.getBatchStock().size());

        // Verify BatchProcessor was called with multiple batches
        verify(batchProcessor).updateBatches(eq(inboundOrder), argThat(batchList -> batchList.size() == 2));
    }

    @Test
    @DisplayName("Should update inbound order data correctly")
    void updateInboundOrder_ValidData_ShouldUpdateOrderFields() {
        // Arrange
        Long authenticatedRepId = 1L;
        LocalDate newOrderDate = LocalDate.of(2024, 6, 15);
        inboundOrderRequest.setOrderDate(newOrderDate);
        setupMocks();

        // Act
        inboundOrderService.updateInboundOrder(inboundOrderRequest, authenticatedRepId);

        // Assert
        assertEquals(newOrderDate, inboundOrder.getOrderDate());
        verify(inboundOrderRepository).save(inboundOrder);
    }

    @Test
    @DisplayName("Should handle empty batch stock list")
    void updateInboundOrder_EmptyBatchStock_ShouldStillUpdateOrder() {
        // Arrange
        Long authenticatedRepId = 1L;
        inboundOrderRequest.setBatchStock(Collections.emptyList());
        setupMocksForEmptyBatchList();

        // Act
        ResponseBatchStockWrapperDTO result =
                inboundOrderService.updateInboundOrder(inboundOrderRequest, authenticatedRepId);

        // Assert
        assertNotNull(result);
        assertTrue(result.getBatchStock().isEmpty());

        // Verify BatchProcessor was called with empty list
        verify(batchProcessor).updateBatches(inboundOrder, Collections.emptyList());
        verify(inboundOrderRepository).save(inboundOrder);
    }

    @Test
    @DisplayName("Should validate all dependencies before processing batches")
    void updateInboundOrder_ValidationOrder_ShouldFollowCorrectSequence() {
        // Arrange
        Long authenticatedRepId = 1L;
        setupMocks();

        InOrder inOrder = inOrder(validator, batchProcessor, inboundOrderRepository);

        // Act
        inboundOrderService.updateInboundOrder(inboundOrderRequest, authenticatedRepId);

        // Assert - Verify execution order
        inOrder.verify(validator).validateInboundOrderExist(inboundOrderRequest.getOrderNumber());
        inOrder.verify(validator).validateAndGetRepresentative(authenticatedRepId);
        inOrder.verify(validator).validateAndGetWarehouse(inboundOrderRequest.getSection().getWarehouseCode());
        inOrder.verify(validator).validateRepresentativeWarehouseAccess(representative, warehouse);
        inOrder.verify(validator).validateAndGetSector(warehouse, inboundOrderRequest.getSection().getSectorCode());
        inOrder.verify(validator).validateBatchRequest(inboundOrderRequest.getBatchStock(), sector);
        inOrder.verify(batchProcessor).updateBatches(inboundOrder, inboundOrderRequest.getBatchStock());
        inOrder.verify(inboundOrderRepository).save(inboundOrder);
    }

    @Test
    @DisplayName("Should pass correct parameters to BatchProcessor")
    void updateInboundOrder_ParameterPassing_ShouldPassCorrectValues() {
        // Arrange
        Long authenticatedRepId = 1L;
        setupMocks();

        // Act
        inboundOrderService.updateInboundOrder(inboundOrderRequest, authenticatedRepId);

        // Assert - Verify correct parameters were passed to BatchProcessor
        verify(batchProcessor).updateBatches(eq(inboundOrder), eq(inboundOrderRequest.getBatchStock()));
    }

    // Helper methods for setting up test data
    private void setupTestData() {
        // Setup InboundOrderRequest
        SectorRequestDTO section = new SectorRequestDTO(101, 1001);

        batchStockDTOs = List.of(CustomFactory.createBatchStockDTO());

        inboundOrderRequest = new InboundOrderRequest(1001, LocalDate.now(), section, batchStockDTOs);
        // Setup entities
        inboundOrder = CustomFactory.createTestInboundOrder();
        representative = CustomFactory.createTestRepresentative();
        warehouse = CustomFactory.createTestWarehouse();
        sector = CustomFactory.createTestSector();
        batches = List.of(CustomFactory.createTestBatch());
        product = CustomFactory.createTestProduct();
    }

    private void setupMocks() {
        when(validator.validateInboundOrderExist(anyInt())).thenReturn(inboundOrder);
        when(validator.validateAndGetRepresentative(anyLong())).thenReturn(representative);
        when(validator.validateAndGetWarehouse(anyInt())).thenReturn(warehouse);
        when(validator.validateAndGetSector(any(Warehouse.class), anyInt())).thenReturn(sector);

        // Mock BatchProcessor to return updated batches
        when(batchProcessor.updateBatches(any(InboundOrder.class), anyList())).thenReturn(batches);

        when(inboundOrderRepository.save(any(InboundOrder.class))).thenReturn(inboundOrder);
    }

    private void setupMocksForBatchProcessorFailure() {
        when(validator.validateInboundOrderExist(anyInt())).thenReturn(inboundOrder);
        when(validator.validateAndGetRepresentative(anyLong())).thenReturn(representative);
        when(validator.validateAndGetWarehouse(anyInt())).thenReturn(warehouse);
        when(validator.validateAndGetSector(any(Warehouse.class), anyInt())).thenReturn(sector);

        // Mock BatchProcessor to throw BadRequestException
        when(batchProcessor.updateBatches(any(InboundOrder.class), anyList()))
                .thenThrow(new BadRequestException("Batch not found with batch_number: 101 for InboundOrder id: 1"));
    }

    private void setupMocksForProductNotFound() {
        when(validator.validateInboundOrderExist(anyInt())).thenReturn(inboundOrder);
        when(validator.validateAndGetRepresentative(anyLong())).thenReturn(representative);
        when(validator.validateAndGetWarehouse(anyInt())).thenReturn(warehouse);
        when(validator.validateAndGetSector(any(Warehouse.class), anyInt())).thenReturn(sector);

        // Mock BatchProcessor to throw EntityNotFoundException
        when(batchProcessor.updateBatches(any(InboundOrder.class), anyList()))
                .thenThrow(new EntityNotFoundException("Product not found with id: 1"));
    }

    private void setupMocksForEmptyBatchList() {
        when(validator.validateInboundOrderExist(anyInt())).thenReturn(inboundOrder);
        when(validator.validateAndGetRepresentative(anyLong())).thenReturn(representative);
        when(validator.validateAndGetWarehouse(anyInt())).thenReturn(warehouse);
        when(validator.validateAndGetSector(any(Warehouse.class), anyInt())).thenReturn(sector);

        // Mock BatchProcessor with empty list
        when(batchProcessor.updateBatches(any(InboundOrder.class), eq(Collections.emptyList())))
                .thenReturn(Collections.emptyList());

        when(inboundOrderRepository.save(any(InboundOrder.class))).thenReturn(inboundOrder);
    }

    private void setupMultipleBatchesData() {
        BatchStockDTO batch1 = CustomFactory.createBatchStockDTO();
        batch1.setBatchNumber(101);

        BatchStockDTO batch2 = CustomFactory.createBatchStockDTO();
        batch2.setBatchNumber(102);

        inboundOrderRequest.setBatchStock(List.of(batch1, batch2));
    }

    private void setupMocksForMultipleBatches() {
        when(validator.validateInboundOrderExist(anyInt())).thenReturn(inboundOrder);
        when(validator.validateAndGetRepresentative(anyLong())).thenReturn(representative);
        when(validator.validateAndGetWarehouse(anyInt())).thenReturn(warehouse);
        when(validator.validateAndGetSector(any(Warehouse.class), anyInt())).thenReturn(sector);

        // Create two batches for the response
        Batch batch1 = CustomFactory.createTestBatch();
        batch1.setBatchNumber(101);
        Batch batch2 = CustomFactory.createTestBatch();
        batch2.setBatchNumber(102);
        List<Batch> multipleBatches = List.of(batch1, batch2);

        // Mock BatchProcessor to return multiple batches
        when(batchProcessor.updateBatches(any(InboundOrder.class), anyList()))
                .thenReturn(multipleBatches);

        when(inboundOrderRepository.save(any(InboundOrder.class))).thenReturn(inboundOrder);
    }
}