package com.mercadolibre.melifrescosg9w31.unit.service.validator;

import com.mercadolibre.melifrescosg9w31.dtos.BatchStockDTO;
import com.mercadolibre.melifrescosg9w31.entity.*;
import com.mercadolibre.melifrescosg9w31.exceptions.AlreadyExistsException;
import com.mercadolibre.melifrescosg9w31.exceptions.BadRequestException;
import com.mercadolibre.melifrescosg9w31.exceptions.NotFoundException;
import com.mercadolibre.melifrescosg9w31.exceptions.UnauthorizedException;
import com.mercadolibre.melifrescosg9w31.repository.*;
import com.mercadolibre.melifrescosg9w31.service.validator.InboundOrderValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("InboundOrderValidator Tests")
class InboundOrderValidatorTest {

    @Mock
    private IWarehouseRepRepository warehouseRepRepository;
    @Mock
    private IWarehouseRepository warehouseRepository;
    @Mock
    private ISectorRepository sectorRepository;
    @Mock
    private IProductRepository productRepository;
    @Mock
    private IInboundOrderRepository inboundOrderRepository;
    @Mock
    private IBatchRepository batchRepository;

    @InjectMocks
    private InboundOrderValidator validator;

    private WarehouseRep mockRep;
    private Warehouse mockWarehouse;
    private Sector mockSector;
    private Product mockProduct;
    private ProductType mockProductType;
    private InboundOrder mockInboundOrder;
    private BatchStockDTO mockBatchDto;

    @BeforeEach
    void setUp() {
        setupMockEntities();
    }

    // ==================== validateAndGetRepresentative Tests ====================

    @Test
    @DisplayName("Should return representative when valid ID is provided")
    void validateAndGetRepresentative_ValidId_ReturnsRepresentative() {
        // Arrange
        when(warehouseRepRepository.findByUser_Id(1L)).thenReturn(Optional.of(mockRep));

        // Act
        WarehouseRep result = validator.validateAndGetRepresentative(1L);

        // Assert
        assertNotNull(result);
        assertEquals(mockRep, result);
        assertEquals("Test Rep", result.getName());
        verify(warehouseRepRepository).findByUser_Id(1L);
    }

    @Test
    @DisplayName("Should throw NotFoundException when representative ID does not exist")
    void validateAndGetRepresentative_InvalidId_ThrowsNotFoundException() {
        // Arrange
        when(warehouseRepRepository.findByUser_Id(999L)).thenReturn(Optional.empty());

        // Act & Assert
        NotFoundException exception =
                assertThrows(NotFoundException.class, () -> validator.validateAndGetRepresentative(999L));

        assertEquals("Representative with ID 999 not found.", exception.getMessage());
        verify(warehouseRepRepository).findByUser_Id(999L);
    }

    @Test
    @DisplayName("Should throw NotFoundException when representative ID is null")
    void validateAndGetRepresentative_NullId_ThrowsNotFoundException() {
        // Arrange
        when(warehouseRepRepository.findByUser_Id(null)).thenReturn(Optional.empty());

        // Act & Assert
        NotFoundException exception =
                assertThrows(NotFoundException.class, () -> validator.validateAndGetRepresentative(null));

        assertTrue(exception.getMessage().contains("Representative with ID null not found"));
        verify(warehouseRepRepository).findByUser_Id(null);
    }

    // ==================== validateAndGetWarehouse Tests ====================

    @Test
    @DisplayName("Should return warehouse when valid code is provided")
    void validateAndGetWarehouse_ValidCode_ReturnsWarehouse() {
        // Arrange
        when(warehouseRepository.findByWarehouseCode(100)).thenReturn(Optional.of(mockWarehouse));

        // Act
        Warehouse result = validator.validateAndGetWarehouse(100);

        // Assert
        assertNotNull(result);
        assertEquals(mockWarehouse, result);
        assertEquals(100, result.getWarehouseCode());
        verify(warehouseRepository).findByWarehouseCode(100);
    }

    @Test
    @DisplayName("Should throw NotFoundException when warehouse code does not exist")
    void validateAndGetWarehouse_InvalidCode_ThrowsNotFoundException() {
        // Arrange
        when(warehouseRepository.findByWarehouseCode(999)).thenReturn(Optional.empty());

        // Act & Assert
        NotFoundException exception =
                assertThrows(NotFoundException.class, () -> validator.validateAndGetWarehouse(999));

        assertEquals("Warehouse with code 999 not found.", exception.getMessage());
        verify(warehouseRepository).findByWarehouseCode(999);
    }

    @Test
    @DisplayName("Should throw NotFoundException when warehouse code is null")
    void validateAndGetWarehouse_NullCode_ThrowsNotFoundException() {
        // Arrange
        when(warehouseRepository.findByWarehouseCode(null)).thenReturn(Optional.empty());

        // Act & Assert
        NotFoundException exception =
                assertThrows(NotFoundException.class, () -> validator.validateAndGetWarehouse(null));

        assertTrue(exception.getMessage().contains("Warehouse with code null not found"));
        verify(warehouseRepository).findByWarehouseCode(null);
    }

    // ==================== validateRepresentativeWarehouseAccess Tests ====================

    @Test
    @DisplayName("Should pass validation when representative belongs to warehouse")
    void validateRepresentativeWarehouseAccess_ValidAccess_DoesNotThrow() {
        // Act & Assert
        assertDoesNotThrow(
                () -> validator.validateRepresentativeWarehouseAccess(mockRep, mockWarehouse));
    }

    @Test
    @DisplayName(
            "Should throw UnauthorizedException when representative belongs to different warehouse")
    void validateRepresentativeWarehouseAccess_DifferentWarehouse_ThrowsUnauthorizedException() {
        // Arrange
        Warehouse differentWarehouse = new Warehouse();
        differentWarehouse.setId(999L);
        differentWarehouse.setWarehouseCode(999);
        differentWarehouse.setName("Different Warehouse");

        // Act & Assert
        UnauthorizedException exception =
                assertThrows(
                        UnauthorizedException.class,
                        () -> validator.validateRepresentativeWarehouseAccess(mockRep, differentWarehouse));

        assertTrue(exception.getMessage().contains("Test Rep does not belong to warehouse 999"));
        verify(warehouseRepRepository, never()).save(any());
    }

    @Test
    @DisplayName("Should throw UnauthorizedException when representative has null warehouse")
    void validateRepresentativeWarehouseAccess_NullRepWarehouse_ThrowsUnauthorizedException() {
        // Arrange
        WarehouseRep repWithNullWarehouse = new WarehouseRep();
        repWithNullWarehouse.setId(1L);
        repWithNullWarehouse.setName("Rep Without Warehouse");
        repWithNullWarehouse.setWarehouse(null);

        // Act & Assert
        UnauthorizedException exception =
                assertThrows(
                        UnauthorizedException.class,
                        () ->
                                validator.validateRepresentativeWarehouseAccess(
                                        repWithNullWarehouse, mockWarehouse));

        assertTrue(
                exception.getMessage().contains("Rep Without Warehouse does not belong to warehouse 100"));
    }

    // ==================== validateAndGetSector Tests ====================

    @Test
    @DisplayName("Should return sector when valid warehouse and sector code are provided")
    void validateAndGetSector_ValidSector_ReturnsSector() {
        // Arrange
        when(sectorRepository.findByWarehouseIdAndSectorCode(1L, 200))
                .thenReturn(Optional.of(mockSector));

        // Act
        Sector result = validator.validateAndGetSector(mockWarehouse, 200);

        // Assert
        assertNotNull(result);
        assertEquals(mockSector, result);
        assertEquals(200, result.getSectorCode());
        verify(sectorRepository).findByWarehouseIdAndSectorCode(1L, 200);
    }

    @Test
    @DisplayName("Should throw NotFoundException when sector does not exist in warehouse")
    void validateAndGetSector_InvalidSector_ThrowsNotFoundException() {
        // Arrange
        when(sectorRepository.findByWarehouseIdAndSectorCode(1L, 999)).thenReturn(Optional.empty());

        // Act & Assert
        NotFoundException exception =
                assertThrows(
                        NotFoundException.class, () -> validator.validateAndGetSector(mockWarehouse, 999));

        assertTrue(exception.getMessage().contains("Sector with code 999"));
        assertTrue(exception.getMessage().contains("in warehouse 100 not found"));
        verify(sectorRepository).findByWarehouseIdAndSectorCode(1L, 999);
    }

    // ==================== validateOrderNumberUniqueness Tests ====================

    @Test
    @DisplayName("Should pass validation when order number is unique")
    void validateOrderNumberUniqueness_UniqueNumber_DoesNotThrow() {
        // Arrange
        when(inboundOrderRepository.findInboundOrderByOrderNumber(12345)).thenReturn(Optional.empty());

        // Act & Assert
        assertDoesNotThrow(() -> validator.validateOrderNumberUniqueness(12345));
        verify(inboundOrderRepository).findInboundOrderByOrderNumber(12345);
    }

    @Test
    @DisplayName("Should throw AlreadyExistsException when order number already exists")
    void validateOrderNumberUniqueness_DuplicateNumber_ThrowsAlreadyExistsException() {
        // Arrange
        when(inboundOrderRepository.findInboundOrderByOrderNumber(12345))
                .thenReturn(Optional.of(mockInboundOrder));

        // Act & Assert
        AlreadyExistsException exception =
                assertThrows(
                        AlreadyExistsException.class, () -> validator.validateOrderNumberUniqueness(12345));

        assertEquals("InboundOrder with order number 12345 already exists.", exception.getMessage());
        verify(inboundOrderRepository).findInboundOrderByOrderNumber(12345);
    }

    // ==================== validateBatchStock Tests ====================

    @Test
    @DisplayName("Should pass validation when batch stock list is valid")
    void validateBatchStock_ValidList_DoesNotThrow() {
        // Arrange
        List<BatchStockDTO> batchStock = List.of(mockBatchDto);

        // Act & Assert
        assertDoesNotThrow(() -> validator.validateBatchStock(batchStock));
    }

    @Test
    @DisplayName("Should throw BadRequestException when batch stock list is null")
    void validateBatchStock_NullList_ThrowsBadRequestException() {
        // Act & Assert
        BadRequestException exception =
                assertThrows(BadRequestException.class, () -> validator.validateBatchStock(null));

        assertEquals(
                "Batch stock list cannot be null or empty for an inbound order.", exception.getMessage());
    }

    @Test
    @DisplayName("Should throw BadRequestException when batch stock list is empty")
    void validateBatchStock_EmptyList_ThrowsBadRequestException() {
        // Arrange
        List<BatchStockDTO> emptyList = new ArrayList<>();

        // Act & Assert
        BadRequestException exception =
                assertThrows(BadRequestException.class, () -> validator.validateBatchStock(emptyList));

        assertEquals(
                "Batch stock list cannot be null or empty for an inbound order.", exception.getMessage());
    }

    // ==================== validateAndGetProduct Tests ====================

    @Test
    @DisplayName("Should return product when valid product ID is provided")
    void validateAndGetProduct_ValidProduct_ReturnsProduct() {
        // Arrange
        when(productRepository.findById(301L)).thenReturn(Optional.of(mockProduct));

        // Act
        Product result = validator.validateAndGetProduct(301L, 1001);

        // Assert
        assertNotNull(result);
        assertEquals(mockProduct, result);
        assertEquals("Test Product", result.getName());
        verify(productRepository).findById(301L);
    }

    @Test
    @DisplayName("Should throw NotFoundException when product ID does not exist")
    void validateAndGetProduct_InvalidProduct_ThrowsNotFoundException() {
        // Arrange
        when(productRepository.findById(999L)).thenReturn(Optional.empty());

        // Act & Assert
        NotFoundException exception =
                assertThrows(NotFoundException.class, () -> validator.validateAndGetProduct(999L, 1001));

        assertTrue(exception.getMessage().contains("Product with ID 999"));
        assertTrue(exception.getMessage().contains("not found in batch 1001"));
        verify(productRepository).findById(999L);
    }

    // ==================== validateProductType Tests ====================

    @Test
    @DisplayName(
            "Should pass validation when product type matches sector type and product is unique")
        // More
        // descriptive name
    void validateProductType_CompatibleTypesAndUniqueProduct_DoesNotThrow() {
        when(batchRepository.findByProductIdAndProductTypeIdExcludingSector(
                mockProduct.getId(), mockProduct.getProductType().getId(), mockSector.getId()))
                .thenReturn(new ArrayList<>());

        assertDoesNotThrow(() -> validator.validateProductType(mockProduct, mockSector));

        verify(batchRepository)
                .findByProductIdAndProductTypeIdExcludingSector(
                        mockProduct.getId(), mockProduct.getProductType().getId(), mockSector.getId());
    }

    @Test
    @DisplayName("Should pass validation when product type matches sector type")
    void validateProductType_CompatibleTypes_DoesNotThrow() {
        // Act & Assert (both product and sector have the same product type)
        assertDoesNotThrow(() -> validator.validateProductType(mockProduct, mockSector));
    }

    @Test
    @DisplayName("Should throw BadRequestException when product type does not match sector type")
    void validateProductType_IncompatibleTypes_ThrowsBadRequestException() {
        // Arrange
        ProductType differentType = new ProductType();
        differentType.setId(999L);
        differentType.setName("Frozen");

        Product productWithDifferentType = new Product();
        productWithDifferentType.setName("Frozen Product");
        productWithDifferentType.setProductType(differentType);

        // Act & Assert
        BadRequestException exception =
                assertThrows(
                        BadRequestException.class,
                        () -> validator.validateProductType(productWithDifferentType, mockSector));

        assertTrue(exception.getMessage().contains("Sector with code 200"));
        assertTrue(exception.getMessage().contains("designed for type: Fresh"));
        assertTrue(exception.getMessage().contains("not suitable for product Frozen Product"));
        assertTrue(exception.getMessage().contains("type: Frozen"));
    }

    @Test
    @DisplayName("Should throw BadRequestException when product has null product type")
    void validateProductType_NullProductType_ThrowsBadRequestException() {
        // Arrange
        Product productWithNullType = new Product();
        productWithNullType.setName("Product Without Type");
        productWithNullType.setProductType(null);

        // Act & Assert
        BadRequestException exception =
                assertThrows(
                        BadRequestException.class,
                        () -> validator.validateProductType(productWithNullType, mockSector));

        assertTrue(exception.getMessage().contains("not suitable for product Product Without Type"));
        assertTrue(exception.getMessage().contains("type: N/A"));
    }

    @Test
    @DisplayName("Should throw BadRequestException when sector has null product type")
    void validateProductType_NullSectorType_ThrowsBadRequestException() {
        // Arrange
        Sector sectorWithNullType = new Sector();
        sectorWithNullType.setSectorCode(200);
        sectorWithNullType.setProductType(null);

        // Act & Assert
        BadRequestException exception =
                assertThrows(
                        BadRequestException.class,
                        () -> validator.validateProductType(mockProduct, sectorWithNullType));

        assertTrue(exception.getMessage().contains("designed for type: N/A"));
    }

    // ==================== validateBatchQuantity Tests ====================

    @Test
    @DisplayName("Should pass validation when batch quantity is positive")
    void validateBatchQuantity_ValidQuantity_DoesNotThrow() {
        // Act & Assert
        assertDoesNotThrow(() -> validator.validateBatchQuantity(mockBatchDto));
    }

    @Test
    @DisplayName("Should throw BadRequestException when batch quantity is zero")
    void validateBatchQuantity_ZeroQuantity_ThrowsBadRequestException() {
        // Arrange
        BatchStockDTO batchWithZeroQuantity = new BatchStockDTO();
        batchWithZeroQuantity.setInitialQuantity(0);
        batchWithZeroQuantity.setBatchNumber(1001);

        // Act & Assert
        BadRequestException exception =
                assertThrows(
                        BadRequestException.class,
                        () -> validator.validateBatchQuantity(batchWithZeroQuantity));

        assertTrue(exception.getMessage().contains("Initial quantity for batch 1001"));
        assertTrue(exception.getMessage().contains("must be greater than 0"));
    }

    @Test
    @DisplayName("Should throw BadRequestException when batch quantity is negative")
    void validateBatchQuantity_NegativeQuantity_ThrowsBadRequestException() {
        // Arrange
        BatchStockDTO batchWithNegativeQuantity = new BatchStockDTO();
        batchWithNegativeQuantity.setInitialQuantity(-5);
        batchWithNegativeQuantity.setBatchNumber(1001);

        // Act & Assert
        BadRequestException exception =
                assertThrows(
                        BadRequestException.class,
                        () -> validator.validateBatchQuantity(batchWithNegativeQuantity));

        assertTrue(exception.getMessage().contains("Initial quantity for batch 1001"));
        assertTrue(exception.getMessage().contains("must be greater than 0"));
    }

    // ==================== validateSectorCapacity Tests ====================

    @Test
    @DisplayName("Should pass validation when sector has sufficient capacity")
    void validateSectorCapacity_SufficientCapacity_DoesNotThrow() {
        // Act & Assert (sector has capacity 100, current 50, adding 30 = 80 total)
        assertDoesNotThrow(() -> validator.validateSectorCapacity(mockSector, 30));
    }

    @Test
    @DisplayName("Should pass validation when adding items exactly reaches max capacity")
    void validateSectorCapacity_ExactCapacity_DoesNotThrow() {
        // Act & Assert (sector has capacity 100, current 50, adding 50 = 100 total)
        assertDoesNotThrow(() -> validator.validateSectorCapacity(mockSector, 50));
    }

    @Test
    @DisplayName("Should throw BadRequestException when adding items exceeds capacity")
    void validateSectorCapacity_InsufficientCapacity_ThrowsBadRequestException() {
        // Act & Assert (sector has capacity 100, current 50, adding 60 = 110 total > 100)
        BadRequestException exception =
                assertThrows(
                        BadRequestException.class, () -> validator.validateSectorCapacity(mockSector, 60));

        assertTrue(exception.getMessage().contains("Adding 60 items (total) would exceed sector 200"));
        assertTrue(exception.getMessage().contains("max capacity of 100"));
        assertTrue(exception.getMessage().contains("Current items in sector: 50"));
    }

    @Test
    @DisplayName("Should throw BadRequestException when sector has null max capacity")
    void validateSectorCapacity_NullMaxCapacity_ThrowsBadRequestException() {
        // Arrange
        Sector sectorWithNullCapacity = new Sector();
        sectorWithNullCapacity.setSectorCode(200);
        sectorWithNullCapacity.setCurrentCapacity(50);
        sectorWithNullCapacity.setMaxCapacity(null);

        // Act & Assert
        BadRequestException exception =
                assertThrows(
                        BadRequestException.class,
                        () -> validator.validateSectorCapacity(sectorWithNullCapacity, 30));

        assertTrue(
                exception.getMessage().contains("Sector 200 does not have a maximum capacity defined"));
    }

    @Test
    @DisplayName("Should handle zero quantity addition correctly")
    void validateSectorCapacity_ZeroQuantity_DoesNotThrow() {
        // Act & Assert
        assertDoesNotThrow(() -> validator.validateSectorCapacity(mockSector, 0));
    }

    @Test
    @DisplayName("Should handle sector at full capacity with zero addition")
    void validateSectorCapacity_FullSectorZeroAddition_DoesNotThrow() {
        // Arrange
        mockSector.setCurrentCapacity(100); // Set to max capacity

        // Act & Assert
        assertDoesNotThrow(() -> validator.validateSectorCapacity(mockSector, 0));
    }

    @Test
    @DisplayName(
            "Should throw exception when sector is already at full capacity and trying to add items")
    void validateSectorCapacity_FullSectorWithAddition_ThrowsBadRequestException() {
        // Arrange
        mockSector.setCurrentCapacity(100);

        // Act & Assert
        BadRequestException exception =
                assertThrows(
                        BadRequestException.class, () -> validator.validateSectorCapacity(mockSector, 1));

        assertTrue(exception.getMessage().contains("Adding 1 items (total) would exceed sector 200"));
        assertTrue(exception.getMessage().contains("max capacity of 100"));
        assertTrue(exception.getMessage().contains("Current items in sector: 100"));
    }

    // Add these test methods to your existing InboundOrderValidatorTest.java class

    @Test
    @DisplayName("Should throw BadRequestException when product exists in another non-full sector of the same type")
    void validateProductType_ProductInAnotherNonFullSector_ThrowsBadRequestException() {
        // Arrange
        // A second sector of the same type as mockSector, where the product already exists
        Sector occupiedSector = new Sector();
        occupiedSector.setId(2L);
        occupiedSector.setSectorCode(201);
        occupiedSector.setName("Occupied Fresh Sector");
        occupiedSector.setCurrentCapacity(80); // Has space (80 < 100)
        occupiedSector.setMaxCapacity(100);
        occupiedSector.setProductType(mockProductType); // Same product type

        Batch existingBatch = new Batch();
        existingBatch.setSector(occupiedSector); // This batch is in the occupied sector

        List<Batch> existingBatches = List.of(existingBatch);

        // Mock the repository to return the list with the existing batch
        when(batchRepository.findByProductIdAndProductTypeIdExcludingSector(
                mockProduct.getId(),
                mockProduct.getProductType().getId(),
                mockSector.getId())) // mockSector is the target sector
                .thenReturn(existingBatches);

        // Act & Assert
        BadRequestException exception =
                assertThrows(
                        BadRequestException.class,
                        () -> validator.validateProductType(mockProduct, mockSector)); // Added batchNumber for context

        // Verify the exception message is correct
        assertTrue(exception.getMessage().contains("already exists in Sector with code 201"));
        assertTrue(exception.getMessage().contains("which is not yet full"));

        // Verify the repository method was called
        verify(batchRepository)
                .findByProductIdAndProductTypeIdExcludingSector(
                        mockProduct.getId(),
                        mockProduct.getProductType().getId(),
                        mockSector.getId());
    }

    @Test
    @DisplayName("Should pass validation when product exists in another sector that IS full")
    void validateProductType_ProductInAnotherFullSector_DoesNotThrow() {
        // Arrange
        // A second sector of the same type, but it's completely full
        Sector occupiedAndFullSector = new Sector();
        occupiedAndFullSector.setId(2L);
        occupiedAndFullSector.setSectorCode(202);
        occupiedAndFullSector.setCurrentCapacity(100);
        occupiedAndFullSector.setMaxCapacity(100); // Full
        occupiedAndFullSector.setProductType(mockProductType); // Same product type

        Batch existingBatch = new Batch();
        existingBatch.setSector(occupiedAndFullSector);

        List<Batch> existingBatches = List.of(existingBatch);

        // Mock the repository to return the batch in the full sector
        when(batchRepository.findByProductIdAndProductTypeIdExcludingSector(
                mockProduct.getId(),
                mockProduct.getProductType().getId(),
                mockSector.getId()))
                .thenReturn(existingBatches);

        // Act & Assert
        // The validation should pass, allowing placement in the new sector because the old one is full
        assertDoesNotThrow(() -> validator.validateProductType(mockProduct, mockSector));

        // Verify the repository method was called
        verify(batchRepository)
                .findByProductIdAndProductTypeIdExcludingSector(
                        mockProduct.getId(),
                        mockProduct.getProductType().getId(),
                        mockSector.getId());
    }

    private void setupMockEntities() {
        ProductType mockProductType = new ProductType();
        mockProductType.setId(1L);
        mockProductType.setCategory("FR");
        mockProductType.setName("Fresh");
        mockProductType.setMinRequiredTemp(BigDecimal.valueOf(0.0));
        mockProductType.setMaxRequiredTemp(BigDecimal.valueOf(10.0));

        // Create Warehouse
        mockWarehouse = new Warehouse();
        mockWarehouse.setId(1L);
        mockWarehouse.setWarehouseCode(100);
        mockWarehouse.setName("Test Warehouse");
        mockWarehouse.setLocation("Test Location");

        // Create WarehouseRep
        mockRep = new WarehouseRep();
        mockRep.setId(1L);
        mockRep.setName("Test Rep");
        mockRep.setRole("Manager");
        mockRep.setWarehouse(mockWarehouse);

        // Create Sector
        mockSector = new Sector();
        mockSector.setId(1L);
        mockSector.setSectorCode(200);
        mockSector.setName("Fresh Sector");
        mockSector.setCurrentCapacity(50);
        mockSector.setMaxCapacity(100);
        mockSector.setTemp(BigDecimal.valueOf(5.0));
        mockSector.setProductType(mockProductType);
        mockSector.setWarehouse(mockWarehouse);

        // Create Seller
        Seller seller = new Seller();
        seller.setId(1L);

        // Create Product
        mockProduct = new Product();
        mockProduct.setId(301L);
        mockProduct.setName("Test Product");
        mockProduct.setDescription("Test Description");
        mockProduct.setPrice(BigDecimal.valueOf(10.99));
        mockProduct.setProductType(mockProductType);
        mockProduct.setSeller(seller);

        // Create InboundOrder
        mockInboundOrder = new InboundOrder();
        mockInboundOrder.setId(1L);
        mockInboundOrder.setOrderNumber(12345);
        mockInboundOrder.setOrderDate(LocalDate.now());

        // Create BatchStockDTO
        mockBatchDto = new BatchStockDTO();
        mockBatchDto.setBatchNumber(1001);
        mockBatchDto.setProductId(301L);
        mockBatchDto.setCurrentTemperature(5.0);
        mockBatchDto.setMinimumTemperature(2.0);
        mockBatchDto.setInitialQuantity(50);
        mockBatchDto.setCurrentQuantity(50);
        mockBatchDto.setManufacturingDate(LocalDate.now().minusDays(1));
        mockBatchDto.setManufacturingTime(LocalDateTime.now().minusDays(1));
        mockBatchDto.setDueDate(LocalDate.now().plusDays(30));
    }
}
