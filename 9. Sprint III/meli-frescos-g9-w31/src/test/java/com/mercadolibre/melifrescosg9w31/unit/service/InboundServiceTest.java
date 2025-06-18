package com.mercadolibre.melifrescosg9w31.unit.service;

import com.mercadolibre.melifrescosg9w31.dtos.BatchStockDTO;
import com.mercadolibre.melifrescosg9w31.dtos.request.InboundOrderRequest;
import com.mercadolibre.melifrescosg9w31.dtos.request.SectorRequestDTO;
import com.mercadolibre.melifrescosg9w31.dtos.response.ResponseBatchStockWrapperDTO;
import com.mercadolibre.melifrescosg9w31.entity.*;
import com.mercadolibre.melifrescosg9w31.mapper.BatchMapper;
import com.mercadolibre.melifrescosg9w31.repository.IInboundOrderRepository;
import com.mercadolibre.melifrescosg9w31.service.BatchProcessor;
import com.mercadolibre.melifrescosg9w31.service.InboundService;
import com.mercadolibre.melifrescosg9w31.service.validator.InboundOrderValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class InboundServiceTest {

    @Mock
    private IInboundOrderRepository inboundOrderRepository;

    @Mock
    private InboundOrderValidator validator;

    @Mock
    private BatchProcessor batchProcessor;

    @Mock
    private BatchMapper batchMapper;

    @InjectMocks
    private InboundService inboundService;

    private InboundOrderRequest validRequest;
    private WarehouseRep mockRep;
    private Warehouse mockWarehouse;
    private Sector mockSector;
    private InboundOrder mockInboundOrder;
    private List<Batch> mockBatches;
    private BatchStockDTO mockResponse;

    @BeforeEach
    void setUp() {
        setupValidRequest();
        setupMockEntities();
    }

    @Test
    void newInboundOrder_ValidRequest_ReturnsResponseList() {
        // Arrange
        setupMockBehaviorsForSuccessfulFlow();

        // Act
        ResponseBatchStockWrapperDTO result = inboundService.newInboundOrder(validRequest, 1L);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.getBatchStock().size());
        assertEquals(mockResponse, result.getBatchStock().get(0));

        // Verify all validation calls
        verify(validator).validateBatchStock(eq(validRequest.getBatchStock()));
        verify(validator).validateOrderNumberUniqueness(eq(12345));
        verify(validator).validateAndGetRepresentative(eq(1L));
        verify(validator).validateAndGetWarehouse(eq(100));
        verify(validator).validateRepresentativeWarehouseAccess(eq(mockRep), eq(mockWarehouse));
        verify(validator).validateAndGetSector(eq(mockWarehouse), eq(200));

        // Verify order creation and processing
        verify(inboundOrderRepository).save(any(InboundOrder.class));
        verify(batchProcessor)
                .processBatches(eq(validRequest.getBatchStock()), eq(mockSector), any(InboundOrder.class));
        verify(batchMapper).convertToBatchDTO(any(Batch.class));
    }

    @Test
    void newInboundOrder_ValidationFails_ThrowsException() {
        // Arrange - Only setup the mock that will be called
        doThrow(new IllegalArgumentException("Invalid batch stock"))
                .when(validator)
                .validateBatchStock(any());

        // Act & Assert
        IllegalArgumentException exception =
                assertThrows(
                        IllegalArgumentException.class, () -> inboundService.newInboundOrder(validRequest, 1L));

        // Verify the exception message
        assertEquals("Invalid batch stock", exception.getMessage());

        // Verify only the first validation was called
        verify(validator).validateBatchStock(eq(validRequest.getBatchStock()));

        // Verify no other interactions occurred
        verifyNoMoreInteractions(validator);
        verifyNoInteractions(inboundOrderRepository, batchProcessor, batchMapper);
    }

    @Test
    void newInboundOrder_OrderNumberAlreadyExists_ThrowsException() {
        // Arrange
        doThrow(new IllegalArgumentException("Order number already exists"))
                .when(validator)
                .validateOrderNumberUniqueness(eq(12345));

        // Act & Assert
        IllegalArgumentException exception =
                assertThrows(
                        IllegalArgumentException.class, () -> inboundService.newInboundOrder(validRequest, 1L));

        // Verify
        assertEquals("Order number already exists", exception.getMessage());
        verify(validator).validateBatchStock(eq(validRequest.getBatchStock()));
        verify(validator).validateOrderNumberUniqueness(eq(12345));
        verifyNoMoreInteractions(validator);
        verifyNoInteractions(inboundOrderRepository, batchProcessor, batchMapper);
    }

    @Test
    void newInboundOrder_RepresentativeNotFound_ThrowsException() {
        // Arrange
        doThrow(new IllegalArgumentException("Representative not found"))
                .when(validator)
                .validateAndGetRepresentative(eq(1L));

        // Act & Assert
        IllegalArgumentException exception =
                assertThrows(
                        IllegalArgumentException.class, () -> inboundService.newInboundOrder(validRequest, 1L));

        // Verify
        assertEquals("Representative not found", exception.getMessage());
        verify(validator).validateBatchStock(eq(validRequest.getBatchStock()));
        verify(validator).validateOrderNumberUniqueness(eq(12345));
        verify(validator).validateAndGetRepresentative(eq(1L));
        verifyNoMoreInteractions(validator);
        verifyNoInteractions(inboundOrderRepository, batchProcessor, batchMapper);
    }

    @Test
    void newInboundOrder_WarehouseNotFound_ThrowsException() {
        // Arrange
        when(validator.validateAndGetRepresentative(eq(1L))).thenReturn(mockRep);
        doThrow(new IllegalArgumentException("Warehouse not found"))
                .when(validator)
                .validateAndGetWarehouse(eq(100));

        // Act & Assert
        IllegalArgumentException exception =
                assertThrows(
                        IllegalArgumentException.class, () -> inboundService.newInboundOrder(validRequest, 1L));

        // Verify
        assertEquals("Warehouse not found", exception.getMessage());
        verify(validator).validateBatchStock(eq(validRequest.getBatchStock()));
        verify(validator).validateOrderNumberUniqueness(eq(12345));
        verify(validator).validateAndGetRepresentative(eq(1L));
        verify(validator).validateAndGetWarehouse(eq(100));
        verifyNoMoreInteractions(validator);
        verifyNoInteractions(inboundOrderRepository, batchProcessor, batchMapper);
    }

    @Test
    void newInboundOrder_UnauthorizedAccess_ThrowsException() {
        // Arrange
        when(validator.validateAndGetRepresentative(eq(1L))).thenReturn(mockRep);
        when(validator.validateAndGetWarehouse(eq(100))).thenReturn(mockWarehouse);
        doThrow(new IllegalArgumentException("Unauthorized access"))
                .when(validator)
                .validateRepresentativeWarehouseAccess(eq(mockRep), eq(mockWarehouse));

        // Act & Assert
        IllegalArgumentException exception =
                assertThrows(
                        IllegalArgumentException.class, () -> inboundService.newInboundOrder(validRequest, 1L));

        // Verify
        assertEquals("Unauthorized access", exception.getMessage());
        verify(validator).validateBatchStock(eq(validRequest.getBatchStock()));
        verify(validator).validateOrderNumberUniqueness(eq(12345));
        verify(validator).validateAndGetRepresentative(eq(1L));
        verify(validator).validateAndGetWarehouse(eq(100));
        verify(validator).validateRepresentativeWarehouseAccess(eq(mockRep), eq(mockWarehouse));
        verifyNoMoreInteractions(validator);
        verifyNoInteractions(inboundOrderRepository, batchProcessor, batchMapper);
    }

    @Test
    void newInboundOrder_SectorNotFound_ThrowsException() {
        // Arrange
        when(validator.validateAndGetRepresentative(eq(1L))).thenReturn(mockRep);
        when(validator.validateAndGetWarehouse(eq(100))).thenReturn(mockWarehouse);
        doThrow(new IllegalArgumentException("Sector not found"))
                .when(validator)
                .validateAndGetSector(eq(mockWarehouse), eq(200));

        // Act & Assert
        IllegalArgumentException exception =
                assertThrows(
                        IllegalArgumentException.class, () -> inboundService.newInboundOrder(validRequest, 1L));

        // Verify
        assertEquals("Sector not found", exception.getMessage());
        verify(validator).validateBatchStock(eq(validRequest.getBatchStock()));
        verify(validator).validateOrderNumberUniqueness(eq(12345));
        verify(validator).validateAndGetRepresentative(eq(1L));
        verify(validator).validateAndGetWarehouse(eq(100));
        verify(validator).validateRepresentativeWarehouseAccess(eq(mockRep), eq(mockWarehouse));
        verify(validator).validateAndGetSector(eq(mockWarehouse), eq(200));
        verifyNoMoreInteractions(validator);
        verifyNoInteractions(inboundOrderRepository, batchProcessor, batchMapper);
    }

    @Test
    void newInboundOrder_BatchProcessingFails_ThrowsException() {
        // Arrange
        setupMockBehaviorsForValidationOnly();
        when(inboundOrderRepository.save(any(InboundOrder.class))).thenReturn(mockInboundOrder);
        doThrow(new RuntimeException("Batch processing failed"))
                .when(batchProcessor)
                .processBatches(eq(validRequest.getBatchStock()), eq(mockSector), any(InboundOrder.class));

        // Act & Assert
        RuntimeException exception =
                assertThrows(
                        RuntimeException.class, () -> inboundService.newInboundOrder(validRequest, 1L));

        // Verify
        assertEquals("Batch processing failed", exception.getMessage());
        verify(inboundOrderRepository).save(any(InboundOrder.class));
        verify(batchProcessor)
                .processBatches(eq(validRequest.getBatchStock()), eq(mockSector), any(InboundOrder.class));
        verifyNoInteractions(batchMapper);
    }

    @Test
    void createAndSaveInboundOrder_CreatesCorrectOrder() {
        // Arrange
        setupMockBehaviorsForSuccessfulFlow();

        // Act
        inboundService.newInboundOrder(validRequest, 1L);

        // Assert - Verify InboundOrder creation with specific properties
        verify(inboundOrderRepository)
                .save(
                        argThat(
                                order ->
                                        order.getOrderNumber().equals(12345)
                                                && order.getOrderDate().equals(validRequest.getOrderDate())
                                                && order.getRep().equals(mockRep)
                                                && order.getWarehouse().equals(mockWarehouse)));
    }

    @Test
    void newInboundOrder_EmptyBatchList_ThrowsException() {
        // Arrange
        validRequest.setBatchStock(List.of()); // Empty list
        doThrow(new IllegalArgumentException("Batch stock cannot be empty"))
                .when(validator)
                .validateBatchStock(eq(validRequest.getBatchStock()));

        // Act & Assert
        IllegalArgumentException exception =
                assertThrows(
                        IllegalArgumentException.class, () -> inboundService.newInboundOrder(validRequest, 1L));

        assertEquals("Batch stock cannot be empty", exception.getMessage());
        verify(validator).validateBatchStock(eq(validRequest.getBatchStock()));
        verifyNoMoreInteractions(validator);
    }

    private void setupMockBehaviorsForSuccessfulFlow() {
        when(validator.validateAndGetRepresentative(eq(1L))).thenReturn(mockRep);
        when(validator.validateAndGetWarehouse(eq(100))).thenReturn(mockWarehouse);
        when(validator.validateAndGetSector(eq(mockWarehouse), eq(200))).thenReturn(mockSector);
        when(inboundOrderRepository.save(any(InboundOrder.class))).thenReturn(mockInboundOrder);
        when(batchProcessor.processBatches(
                eq(validRequest.getBatchStock()), eq(mockSector), any(InboundOrder.class)))
                .thenReturn(mockBatches);
        when(batchMapper.convertToBatchDTO(any(Batch.class))).thenReturn(mockResponse);
    }

    private void setupMockBehaviorsForValidationOnly() {
        when(validator.validateAndGetRepresentative(eq(1L))).thenReturn(mockRep);
        when(validator.validateAndGetWarehouse(eq(100))).thenReturn(mockWarehouse);
        when(validator.validateAndGetSector(eq(mockWarehouse), eq(200))).thenReturn(mockSector);
    }

    private void setupValidRequest() {
        // Create section request
        SectorRequestDTO sectionRequest = new SectorRequestDTO();
        sectionRequest.setWarehouseCode(100);
        sectionRequest.setSectorCode(200);

        // Create batch stock DTO
        BatchStockDTO batchDto = new BatchStockDTO();
        batchDto.setBatchNumber(1001);
        batchDto.setProductId(301L);
        batchDto.setCurrentTemperature(5.0);
        batchDto.setMinimumTemperature(2.0);
        batchDto.setInitialQuantity(50);
        batchDto.setCurrentQuantity(50);
        batchDto.setManufacturingTime(LocalDateTime.now().minusDays(1));
        batchDto.setDueDate(LocalDate.now().plusDays(30));

        // Create main request
        validRequest = new InboundOrderRequest();
        validRequest.setOrderNumber(12345);
        validRequest.setOrderDate(LocalDate.now());
        validRequest.setSection(sectionRequest);
        validRequest.setBatchStock(List.of(batchDto));
    }

    private void setupMockEntities() {
        // Create UserAccount for WarehouseRep
        UserAccount userAccount = new UserAccount();
        userAccount.setId(1L);
        userAccount.setUserName("testuser");
        userAccount.setPassword("password");

        // Create Warehouse
        mockWarehouse = new Warehouse();
        mockWarehouse.setId(10L);
        mockWarehouse.setWarehouseCode(100);
        mockWarehouse.setName("Test Warehouse");
        mockWarehouse.setLocation("Test Location");

        // Create WarehouseRep
        mockRep = new WarehouseRep();
        mockRep.setId(1L);
        mockRep.setName("Test Rep");
        mockRep.setRole("Manager");
        mockRep.setWarehouse(mockWarehouse);
        mockRep.setUser(userAccount);

        // Create ProductType
        ProductType productType = new ProductType();
        productType.setId(1L);
        productType.setCategory("FR");
        productType.setName("Fresh");
        productType.setMinRequiredTemp(BigDecimal.valueOf(0.0));
        productType.setMaxRequiredTemp(BigDecimal.valueOf(10.0));

        // Create Sector
        mockSector = new Sector();
        mockSector.setId(20L);
        mockSector.setSectorCode(200);
        mockSector.setName("Fresh Sector");
        mockSector.setCurrentCapacity(50);
        mockSector.setMaxCapacity(200);
        mockSector.setTemp(BigDecimal.valueOf(5.0));
        mockSector.setProductType(productType);
        mockSector.setWarehouse(mockWarehouse);

        // Create InboundOrder
        mockInboundOrder = new InboundOrder();
        mockInboundOrder.setId(1L);
        mockInboundOrder.setOrderNumber(12345);
        mockInboundOrder.setOrderDate(LocalDate.now());
        mockInboundOrder.setRep(mockRep);
        mockInboundOrder.setWarehouse(mockWarehouse);

        // Create Seller
        Seller seller = new Seller();
        seller.setId(1L);

        // Create Product
        Product product = new Product();
        product.setId(301L);
        product.setName("Test Product");
        product.setDescription("Test Description");
        product.setPrice(BigDecimal.valueOf(10.99));
        product.setProductType(productType);
        product.setSeller(seller);

        // Create Batch
        Batch mockBatch = new Batch();
        mockBatch.setId(1L);
        mockBatch.setBatchNumber(1001);
        mockBatch.setInitialQuantity(50);
        mockBatch.setActualQuantity(50);
        mockBatch.setManufacturingDatetime(LocalDateTime.now());
        mockBatch.setExpireDate(LocalDate.now().plusDays(30));
        mockBatch.setRegistrationTemp(BigDecimal.valueOf(5.0));
        mockBatch.setMinimumTemp(BigDecimal.valueOf(2.0));
        mockBatch.setProduct(product);
        mockBatch.setSector(mockSector);
        mockBatch.setInboundOrder(mockInboundOrder);

        mockBatches = List.of(mockBatch);

        // Create response DTO
        mockResponse =
                BatchStockDTO.builder()
                        .batchNumber(1001)
                        .productId(301L)
                        .currentTemperature(5.0)
                        .minimumTemperature(2.0)
                        .initialQuantity(50)
                        .currentQuantity(50)
                        .manufacturingDate(LocalDate.now())
                        .manufacturingTime(LocalDateTime.now())
                        .dueDate(LocalDate.now().plusDays(30))
                        .build();
    }
}
