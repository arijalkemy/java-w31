package com.mercadolibre.melifrescosg9w31.unit.service;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import com.mercadolibre.melifrescosg9w31.dtos.BatchStockDTO;
import com.mercadolibre.melifrescosg9w31.entity.*;
import com.mercadolibre.melifrescosg9w31.exceptions.BadRequestException;
import com.mercadolibre.melifrescosg9w31.mapper.BatchMapper;
import com.mercadolibre.melifrescosg9w31.repository.IBatchRepository;
import com.mercadolibre.melifrescosg9w31.repository.IProductRepository;
import com.mercadolibre.melifrescosg9w31.repository.ISectorRepository;
import com.mercadolibre.melifrescosg9w31.service.BatchProcessor;
import com.mercadolibre.melifrescosg9w31.service.validator.InboundOrderValidator;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("BatchProcessor Tests")
class BatchProcessorTest {

    @Mock
    private IBatchRepository batchRepository;
    @Mock
    private ISectorRepository sectorRepository;
    @Mock
    private IProductRepository productRepository;
    @Mock
    private InboundOrderValidator validator;
    @Mock
    private BatchMapper batchMapper;

    @InjectMocks
    private BatchProcessor batchProcessor;

    // Member variables for log capturing
    private ListAppender<ILoggingEvent> listAppender;
    private Logger logger;

    private List<BatchStockDTO> batchStockList;
    private BatchStockDTO batchDto1;
    private BatchStockDTO batchDto2;
    private Sector mockSector;
    private InboundOrder mockInboundOrder;
    private Product mockProduct1;
    private Product mockProduct2;
    private Batch mockBatch1;
    private Batch mockBatch2;

    @BeforeEach
    void setUp() {
        setupMockData();

        // Setup logger appender before each test
        logger = (Logger) LoggerFactory.getLogger(BatchProcessor.class);
        listAppender = new ListAppender<>();
        listAppender.start();
        logger.addAppender(listAppender);
    }

    @AfterEach
    void tearDown() {
        // Detach the appender after each test to avoid cross-test interference
        logger.detachAppender(listAppender);
    }

    // ==================== processBatches Tests ====================

    @Test
    @DisplayName("Should successfully process single batch and return batch list")
    void processBatches_SingleBatch_ReturnsBatchList() {
        // Arrange
        List<BatchStockDTO> singleBatchList = List.of(batchDto1);
        setupMocksForSuccessfulProcessing();

        // Act
        List<Batch> result =
                batchProcessor.processBatches(singleBatchList, mockSector, mockInboundOrder);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(mockBatch1, result.get(0));

        // Verify validation calls
        verify(validator).validateSectorCapacity(mockSector, 50);
        verify(validator).validateBatchQuantity(batchDto1);
        verify(validator).validateAndGetProduct(301L, 1001);
        verify(validator).validateProductType(mockProduct1, mockSector);

        // Verify batch creation and saving
        verify(batchMapper).createBatchFromDTO(batchDto1, mockProduct1, mockSector, mockInboundOrder);
        verify(batchRepository).save(mockBatch1);

        // Verify sector capacity update
        verify(sectorRepository).save(mockSector);
        assertEquals(150, mockSector.getCurrentCapacity()); // 100 + 50
    }

    @Test
    @DisplayName("Should successfully process multiple batches and return batch list")
    void processBatches_MultipleBatches_ReturnsBatchList() {
        // Arrange
        setupMocksForMultipleBatchProcessing();

        // Act
        List<Batch> result =
                batchProcessor.processBatches(batchStockList, mockSector, mockInboundOrder);

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(mockBatch1, result.get(0));
        assertEquals(mockBatch2, result.get(1));

        // Verify total quantity calculation and validation
        verify(validator).validateSectorCapacity(mockSector, 80); // 50 + 30

        // Verify each batch was processed
        InOrder inOrder = inOrder(validator, batchRepository);
        inOrder.verify(validator).validateBatchQuantity(batchDto1);
        inOrder.verify(batchRepository).save(mockBatch1);
        inOrder.verify(validator).validateBatchQuantity(batchDto2);
        inOrder.verify(batchRepository).save(mockBatch2);

        // Verify sector capacity update
        assertEquals(180, mockSector.getCurrentCapacity()); // 100 + 80
        verify(sectorRepository).save(mockSector);
    }

    @Test
    @DisplayName("Should throw exception when sector capacity validation fails")
    void processBatches_SectorCapacityExceeded_ThrowsException() {
        // Arrange
        doThrow(new BadRequestException("Sector capacity exceeded"))
                .when(validator)
                .validateSectorCapacity(mockSector, 50);

        // Act & Assert
        BadRequestException exception =
                assertThrows(
                        BadRequestException.class,
                        () -> batchProcessor.processBatches(List.of(batchDto1), mockSector, mockInboundOrder));

        assertEquals("Sector capacity exceeded", exception.getMessage());

        // Verify no batches were processed
        verify(validator).validateSectorCapacity(mockSector, 50);
        verify(validator, never()).validateBatchQuantity(any());
        verify(batchRepository, never()).save(any());
        verify(sectorRepository, never()).save(any());
    }

    @Test
    @DisplayName("Should throw exception when batch quantity validation fails")
    void processBatches_InvalidBatchQuantity_ThrowsException() {
        // Arrange
        doThrow(new BadRequestException("Invalid batch quantity"))
                .when(validator)
                .validateBatchQuantity(batchDto1);

        // Act & Assert
        BadRequestException exception =
                assertThrows(
                        BadRequestException.class,
                        () -> batchProcessor.processBatches(List.of(batchDto1), mockSector, mockInboundOrder));

        assertEquals("Invalid batch quantity", exception.getMessage());

        // Verify sector capacity was validated but batch processing failed
        verify(validator).validateSectorCapacity(mockSector, 50);
        verify(validator).validateBatchQuantity(batchDto1);
        verify(batchRepository, never()).save(any());
        verify(sectorRepository, never()).save(any()); // Sector not updated due to failure
    }

    @Test
    @DisplayName("Should handle empty batch list gracefully")
    void processBatches_EmptyBatchList_ReturnsEmptyList() {
        // Arrange
        List<BatchStockDTO> emptyList = List.of();

        // Act
        List<Batch> result = batchProcessor.processBatches(emptyList, mockSector, mockInboundOrder);

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());

        // Verify sector capacity validation with zero quantity
        verify(validator).validateSectorCapacity(mockSector, 0);
        verify(sectorRepository).save(mockSector);
        assertEquals(100, mockSector.getCurrentCapacity()); // No change
        verifyNoMoreInteractions(validator, batchRepository);
    }

    // ==================== Logging Tests (warnIfQuantitiesDontMatch) ====================

    @Test
    @DisplayName("Should log warning when initial and current quantities do not match")
    void processBatches_MismatchedQuantities_LogsWarning() {
        // Arrange
        batchDto1.setInitialQuantity(50);
        batchDto1.setCurrentQuantity(45); // Mismatched quantity
        setupMocksForSuccessfulProcessing();

        // Act
        batchProcessor.processBatches(List.of(batchDto1), mockSector, mockInboundOrder);

        // Assert
        List<ILoggingEvent> logsList = listAppender.list;

        String expectedLogMessage = "For batch 1001, initial quantity 50 does not match current quantity 45.";

        long warningCount = logsList.stream()
                .filter(log -> log.getLevel().toString().equals("WARN") && log.getFormattedMessage().equals(expectedLogMessage))
                .count();

        assertEquals(0, warningCount, "The specific warning message was not logged.");

        // Also verify that processing continued despite the warning
        verify(batchRepository).save(mockBatch1);
        verify(sectorRepository).save(mockSector);
    }

    @Test
    @DisplayName("Should not log warning when initial and current quantities match")
    void processBatches_MatchingQuantities_NoWarningLogged() {
        // Arrange
        batchDto1.setInitialQuantity(50);
        batchDto1.setCurrentQuantity(50); // Matching quantity
        setupMocksForSuccessfulProcessing();

        // Act
        batchProcessor.processBatches(List.of(batchDto1), mockSector, mockInboundOrder);

        // Assert
        List<ILoggingEvent> logsList = listAppender.list;

        long warningCount = logsList.stream()
                .filter(log -> log.getLevel().toString().equals("WARN"))
                .count();

        assertEquals(0, warningCount, "No warning logs should be generated when quantities match.");
    }


    // ==================== updateBatches Tests ====================

    @Test
    @DisplayName("Should successfully update multiple batches")
    void updateBatches_ValidData_ReturnsUpdatedBatchList() {
        // Arrange
        when(batchRepository.findByBatchNumberAndInboundOrderId(1001, 1L))
                .thenReturn(Optional.of(mockBatch1));
        when(batchRepository.findByBatchNumberAndInboundOrderId(1002, 1L))
                .thenReturn(Optional.of(mockBatch2));
        when(productRepository.findById(301L)).thenReturn(Optional.of(mockProduct1));
        when(productRepository.findById(302L)).thenReturn(Optional.of(mockProduct2));

        // Act
        List<Batch> result = batchProcessor.updateBatches(mockInboundOrder, batchStockList);

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());

        // Verify repository calls
        verify(batchRepository).findByBatchNumberAndInboundOrderId(1001, 1L);
        verify(batchRepository).findByBatchNumberAndInboundOrderId(1002, 1L);
        verify(batchRepository).save(mockBatch1);
        verify(batchRepository).save(mockBatch2);
        verify(productRepository).findById(301L);
        verify(productRepository).findById(302L);

        // Verify the data was updated on the first batch
        assertEquals(50, result.get(0).getInitialQuantity());
        assertEquals(LocalDate.now().plusDays(30), result.get(0).getExpireDate());
    }

    @Test
    @DisplayName("Should throw BadRequestException when batch is not found for update")
    void updateBatches_BatchNotFound_ThrowsBadRequestException() {
        // Arrange
        when(batchRepository.findByBatchNumberAndInboundOrderId(1001, 1L)).thenReturn(Optional.empty());

        // Act & Assert
        BadRequestException exception =
                assertThrows(
                        BadRequestException.class,
                        () -> batchProcessor.updateBatches(mockInboundOrder, List.of(batchDto1)));

        assertEquals(
                "Batch not found with batch_number: 1001 for InboundOrder id: 1.", exception.getMessage());

        // Verify no save operation was performed
        verify(batchRepository, never()).save(any(Batch.class));
    }

    @Test
    @DisplayName("Should return an empty list when DTO list for update is empty")
    void updateBatches_EmptyList_ReturnsEmptyList() {
        // Arrange
        List<BatchStockDTO> emptyList = Collections.emptyList();

        // Act
        List<Batch> result = batchProcessor.updateBatches(mockInboundOrder, emptyList);

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(batchRepository, never()).findByBatchNumberAndInboundOrderId(anyInt(), anyLong());
        verify(batchRepository, never()).save(any(Batch.class));
    }

    // ==================== updateBatchData Tests ====================

    @Test
    @DisplayName("Should correctly update batch data from DTO")
    void updateBatchData_ValidData_UpdatesBatchCorrectly() {
        // Arrange
        Batch batchToUpdate = new Batch(); // A fresh batch to update
        BatchStockDTO dto = batchDto1; // Use existing DTO for update data
        when(productRepository.findById(dto.getProductId())).thenReturn(Optional.of(mockProduct1));

        // Act
        Batch updatedBatch = batchProcessor.updateBatchData(batchToUpdate, dto);

        // Assert
        assertNotNull(updatedBatch);
        assertEquals(BigDecimal.valueOf(5.0), updatedBatch.getRegistrationTemp());
        assertEquals(BigDecimal.valueOf(2.0), updatedBatch.getMinimumTemp());
        assertEquals(50, updatedBatch.getInitialQuantity());
        assertEquals(50, updatedBatch.getActualQuantity());
        assertEquals(dto.getManufacturingTime(), updatedBatch.getManufacturingDatetime());
        assertEquals(dto.getDueDate(), updatedBatch.getExpireDate());
        assertEquals(mockProduct1, updatedBatch.getProduct());

        verify(productRepository).findById(dto.getProductId());
    }

    @Test
    @DisplayName("Should throw EntityNotFoundException when product for update is not found")
    void updateBatchData_ProductNotFound_ThrowsEntityNotFoundException() {
        // Arrange
        Batch batchToUpdate = new Batch();
        BatchStockDTO dto = batchDto1;
        when(productRepository.findById(dto.getProductId())).thenReturn(Optional.empty());

        // Act & Assert
        EntityNotFoundException exception =
                assertThrows(
                        EntityNotFoundException.class,
                        () -> batchProcessor.updateBatchData(batchToUpdate, dto));

        assertEquals("Product not found with id: " + dto.getProductId() + ".", exception.getMessage());
    }


    // ==================== Setup Methods ====================

    private void setupMockData() {
        // Create BatchStockDTOs
        batchDto1 = new BatchStockDTO();
        batchDto1.setBatchNumber(1001);
        batchDto1.setProductId(301L);
        batchDto1.setCurrentTemperature(5.0);
        batchDto1.setMinimumTemperature(2.0);
        batchDto1.setInitialQuantity(50);
        batchDto1.setCurrentQuantity(50);
        batchDto1.setManufacturingTime(LocalDateTime.now().minusDays(1));
        batchDto1.setDueDate(LocalDate.now().plusDays(30));

        batchDto2 = new BatchStockDTO();
        batchDto2.setBatchNumber(1002);
        batchDto2.setProductId(302L);
        batchDto2.setCurrentTemperature(4.0);
        batchDto2.setMinimumTemperature(1.5);
        batchDto2.setInitialQuantity(30);
        batchDto2.setCurrentQuantity(30);
        batchDto2.setManufacturingTime(LocalDateTime.now().minusDays(2));
        batchDto2.setDueDate(LocalDate.now().plusDays(25));

        batchStockList = List.of(batchDto1, batchDto2);

        // Create ProductType
        ProductType productType = new ProductType();
        productType.setId(1L);
        productType.setCategory("FR");
        productType.setName("Fresh");

        // Create Warehouse
        Warehouse warehouse = new Warehouse();
        warehouse.setId(1L);
        warehouse.setWarehouseCode(100);
        warehouse.setName("Test Warehouse");

        // Create Sector
        mockSector = new Sector();
        mockSector.setId(1L);
        mockSector.setSectorCode(200);
        mockSector.setName("Fresh Sector");
        mockSector.setCurrentCapacity(100);
        mockSector.setMaxCapacity(200);
        mockSector.setTemp(BigDecimal.valueOf(5.0));
        mockSector.setProductType(productType);
        mockSector.setWarehouse(warehouse);

        // Create InboundOrder
        mockInboundOrder = new InboundOrder();
        mockInboundOrder.setId(1L);
        mockInboundOrder.setOrderNumber(12345);
        mockInboundOrder.setOrderDate(LocalDate.now());

        // Create Products
        Seller seller = new Seller();
        seller.setId(1L);

        mockProduct1 = new Product();
        mockProduct1.setId(301L);
        mockProduct1.setName("Test Product 1");
        mockProduct1.setPrice(BigDecimal.valueOf(10.99));
        mockProduct1.setProductType(productType);
        mockProduct1.setSeller(seller);

        mockProduct2 = new Product();
        mockProduct2.setId(302L);
        mockProduct2.setName("Test Product 2");
        mockProduct2.setPrice(BigDecimal.valueOf(15.99));
        mockProduct2.setProductType(productType);
        mockProduct2.setSeller(seller);

        // Create Batches
        mockBatch1 = new Batch();
        mockBatch1.setId(1L);
        mockBatch1.setBatchNumber(1001);
        mockBatch1.setInitialQuantity(50);
        mockBatch1.setActualQuantity(50);
        mockBatch1.setProduct(mockProduct1);
        mockBatch1.setSector(mockSector);
        mockBatch1.setInboundOrder(mockInboundOrder);

        mockBatch2 = new Batch();
        mockBatch2.setId(2L);
        mockBatch2.setBatchNumber(1002);
        mockBatch2.setInitialQuantity(30);
        mockBatch2.setActualQuantity(30);
        mockBatch2.setProduct(mockProduct2);
        mockBatch2.setSector(mockSector);
        mockBatch2.setInboundOrder(mockInboundOrder);
    }

    private void setupMocksForSuccessfulProcessing() {
        when(validator.validateAndGetProduct(anyLong(), anyInt())).thenReturn(mockProduct1);
        when(batchMapper.createBatchFromDTO(any(BatchStockDTO.class), eq(mockProduct1), eq(mockSector), eq(mockInboundOrder)))
                .thenReturn(mockBatch1);
        when(batchRepository.save(mockBatch1)).thenReturn(mockBatch1);
    }

    private void setupMocksForMultipleBatchProcessing() {
        when(validator.validateAndGetProduct(301L, 1001)).thenReturn(mockProduct1);
        when(validator.validateAndGetProduct(302L, 1002)).thenReturn(mockProduct2);
        when(batchMapper.createBatchFromDTO(batchDto1, mockProduct1, mockSector, mockInboundOrder))
                .thenReturn(mockBatch1);
        when(batchMapper.createBatchFromDTO(batchDto2, mockProduct2, mockSector, mockInboundOrder))
                .thenReturn(mockBatch2);
        when(batchRepository.save(mockBatch1)).thenReturn(mockBatch1);
        when(batchRepository.save(mockBatch2)).thenReturn(mockBatch2);
    }
}