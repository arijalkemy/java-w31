package com.mercadolibre.melifrescosg9w31.unit.service.validator;

import com.mercadolibre.melifrescosg9w31.dtos.BatchStockDTO;
import com.mercadolibre.melifrescosg9w31.entity.Product;
import com.mercadolibre.melifrescosg9w31.entity.ProductType;
import com.mercadolibre.melifrescosg9w31.entity.Sector;
import com.mercadolibre.melifrescosg9w31.exceptions.BadRequestException;
import com.mercadolibre.melifrescosg9w31.repository.IBatchRepository;
import com.mercadolibre.melifrescosg9w31.repository.IProductRepository;
import com.mercadolibre.melifrescosg9w31.service.validator.InboundOrderValidator;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class InboundOrderValidatorBatchRequestTest {

    @Mock
    private IProductRepository productRepository;

    @Mock
    private IBatchRepository batchRepository;

    @Spy // Cambiar de @Mock a @Spy
    @InjectMocks
    private InboundOrderValidator validator;

    private Sector sector;
    private Product product;
    private ProductType productType;
    private List<BatchStockDTO> batchStockList;

    @BeforeEach
    void setUp() {
        setupTestData();
    }

    @Test
    @DisplayName("Should validate batch request successfully with valid data")
    void validateBatchRequest_ValidData_ShouldNotThrowException() {
        // Arrange
        setupValidSpyMocks();

        // Act & Assert
        assertDoesNotThrow(() -> validator.validateBatchRequest(batchStockList, sector));

        // Verify all validations were called for each batch
        verify(validator, times(batchStockList.size())).validateBatchStock(batchStockList);
        verify(validator, times(batchStockList.size())).validateBatchQuantity(any(BatchStockDTO.class));
        verify(validator, times(batchStockList.size())).validateAndGetProduct(anyLong(), anyInt());
        verify(validator, times(batchStockList.size())).validateProductType(any(Product.class), eq(sector));
    }

    @Test
    @DisplayName("Should validate multiple batches successfully")
    void validateBatchRequest_MultipleBatches_ShouldValidateAll() {
        // Arrange
        setupMultipleBatchesData();
        setupValidSpyMocks();

        // Act & Assert
        assertDoesNotThrow(() -> validator.validateBatchRequest(batchStockList, sector));

        // Verify validations were called for each batch
        assertEquals(3, batchStockList.size());
        verify(validator, times(3)).validateBatchStock(batchStockList);
        verify(validator, times(3)).validateBatchQuantity(any(BatchStockDTO.class));
        verify(validator, times(3)).validateAndGetProduct(anyLong(), anyInt());
        verify(validator, times(3)).validateProductType(any(Product.class), eq(sector));
    }

    @Test
    @DisplayName("Should throw exception when batch stock validation fails")
    void validateBatchRequest_InvalidBatchStock_ShouldThrowException() {
        // Arrange
        doThrow(new BadRequestException("Invalid batch stock"))
                .when(validator).validateBatchStock(batchStockList);

        // Act & Assert
        BadRequestException exception = assertThrows(BadRequestException.class,
                () -> validator.validateBatchRequest(batchStockList, sector));

        assertEquals("Invalid batch stock", exception.getMessage());

        // Verify only first validation was called before failure
        verify(validator).validateBatchStock(batchStockList);
        verify(validator, never()).validateBatchQuantity(any(BatchStockDTO.class));
        verify(validator, never()).validateAndGetProduct(anyLong(), anyInt());
        verify(validator, never()).validateProductType(any(Product.class), any(Sector.class));
    }

    @Test
    @DisplayName("Should throw exception when batch quantity validation fails")
    void validateBatchRequest_InvalidBatchQuantity_ShouldThrowException() {
        // Arrange
        doNothing().when(validator).validateBatchStock(batchStockList);
        doThrow(new BadRequestException("Invalid batch quantity"))
                .when(validator).validateBatchQuantity(any(BatchStockDTO.class));

        // Act & Assert
        BadRequestException exception = assertThrows(BadRequestException.class,
                () -> validator.validateBatchRequest(batchStockList, sector));

        assertEquals("Invalid batch quantity", exception.getMessage());
    }

    @Test
    @DisplayName("Should throw exception when product validation fails")
    void validateBatchRequest_ProductNotFound_ShouldThrowException() {
        // Arrange
        doNothing().when(validator).validateBatchStock(batchStockList);
        doNothing().when(validator).validateBatchQuantity(any(BatchStockDTO.class));
        doThrow(new EntityNotFoundException("Product not found"))
                .when(validator).validateAndGetProduct(anyLong(), anyInt());

        // Act & Assert
        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class,
                () -> validator.validateBatchRequest(batchStockList, sector));

        assertEquals("Product not found", exception.getMessage());

        // Verify product validation was attempted
        verify(validator).validateAndGetProduct(anyLong(), anyInt());
        verify(validator, never()).validateProductType(any(Product.class), any(Sector.class));
    }

    @Test
    @DisplayName("Should throw exception when product type validation fails")
    void validateBatchRequest_InvalidProductType_ShouldThrowException() {
        // Arrange
        doNothing().when(validator).validateBatchStock(batchStockList);
        doNothing().when(validator).validateBatchQuantity(any(BatchStockDTO.class));
        doReturn(product).when(validator).validateAndGetProduct(anyLong(), anyInt());
        doThrow(new BadRequestException("Product type doesn't match sector"))
                .when(validator).validateProductType(any(Product.class), eq(sector));

        // Act & Assert
        BadRequestException exception = assertThrows(BadRequestException.class,
                () -> validator.validateBatchRequest(batchStockList, sector));

        assertEquals("Product type doesn't match sector", exception.getMessage());

        // Verify all validations up to product type were called
        verify(validator).validateBatchStock(batchStockList);
        verify(validator).validateBatchQuantity(any(BatchStockDTO.class));
        verify(validator).validateAndGetProduct(anyLong(), anyInt());
        verify(validator).validateProductType(product, sector);
    }

    @Test
    @DisplayName("Should handle empty batch stock list")
    void validateBatchRequest_EmptyList_ShouldNotThrowException() {
        // Arrange
        List<BatchStockDTO> emptyList = Collections.emptyList();

        // Act & Assert
        assertDoesNotThrow(() -> validator.validateBatchRequest(emptyList, sector));

        // Verify no validations were called for empty list
        verify(validator, never()).validateBatchStock(any());
        verify(validator, never()).validateBatchQuantity(any(BatchStockDTO.class));
        verify(validator, never()).validateAndGetProduct(anyLong(), anyInt());
        verify(validator, never()).validateProductType(any(Product.class), any(Sector.class));
    }

    @Test
    @DisplayName("Should pass correct parameters to each validation method")
    void validateBatchRequest_CorrectParameters_ShouldPassCorrectValues() {
        // Arrange
        BatchStockDTO batchDTO = batchStockList.get(0);
        setupValidSpyMocks();

        // Act
        validator.validateBatchRequest(batchStockList, sector);

        // Assert - Verify correct parameters were passed
        verify(validator).validateBatchStock(batchStockList);
        verify(validator).validateBatchQuantity(batchDTO);
        verify(validator).validateAndGetProduct(batchDTO.getProductId(), batchDTO.getBatchNumber());
        verify(validator).validateProductType(product, sector);
    }

    // Helper methods for setting up test data
    private void setupTestData() {
        // Setup Sector
        sector = createTestSector();

        // Setup Product and ProductType
        productType = createTestProductType();
        product = createTestProduct();

        // Setup BatchStockDTO list
        batchStockList = List.of(createBatchStockDTO());
    }

    private void setupValidSpyMocks() {
        doNothing().when(validator).validateBatchStock(batchStockList);
        doNothing().when(validator).validateBatchQuantity(any(BatchStockDTO.class));
        doReturn(product).when(validator).validateAndGetProduct(anyLong(), anyInt()); // Usar doReturn en lugar de when
        doNothing().when(validator).validateProductType(any(Product.class), eq(sector));
    }

    private void setupMultipleBatchesData() {
        BatchStockDTO batch1 = createBatchStockDTO();
        batch1.setBatchNumber(101);
        batch1.setProductId(1L);

        BatchStockDTO batch2 = createBatchStockDTO();
        batch2.setBatchNumber(102);
        batch2.setProductId(2L);

        BatchStockDTO batch3 = createBatchStockDTO();
        batch3.setBatchNumber(103);
        batch3.setProductId(3L);

        batchStockList = List.of(batch1, batch2, batch3);
    }

    // Factory methods for test objects
    private BatchStockDTO createBatchStockDTO() {
        BatchStockDTO dto = new BatchStockDTO();
        dto.setBatchNumber(101);
        dto.setProductId(1L);
        dto.setCurrentTemperature(2.5);
        dto.setMinimumTemperature(1.0);
        dto.setInitialQuantity(100);
        dto.setCurrentQuantity(95);
        dto.setManufacturingTime(LocalDateTime.now());
        dto.setDueDate(LocalDate.now().plusMonths(2));
        return dto;
    }

    private Sector createTestSector() {
        Sector sector = new Sector();
        sector.setId(1L);
        sector.setSectorCode(1001);
        sector.setName("Test Sector");
        sector.setProductType(createTestProductType());
        return sector;
    }

    private ProductType createTestProductType() {
        ProductType type = new ProductType();
        type.setId(1L);
        type.setCategory("FS");
        type.setName("Fresh");
        type.setMinRequiredTemp(BigDecimal.valueOf(1.0));
        type.setMaxRequiredTemp(BigDecimal.valueOf(7.0));
        return type;
    }

    private Product createTestProduct() {
        Product product = new Product();
        product.setId(1L);
        product.setName("Test Product");
        product.setDescription("Test Description");
        product.setPrice(BigDecimal.valueOf(100.00));
        product.setProductType(productType);
        return product;
    }
}
