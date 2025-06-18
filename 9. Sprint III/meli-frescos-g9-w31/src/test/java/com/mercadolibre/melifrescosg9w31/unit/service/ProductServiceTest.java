package com.mercadolibre.melifrescosg9w31.unit.service;


import com.mercadolibre.melifrescosg9w31.dtos.ProductBatchDTO;
import com.mercadolibre.melifrescosg9w31.dtos.request.ProductRequestDTO;
import com.mercadolibre.melifrescosg9w31.dtos.response.ProductStockResponseDTO;
import com.mercadolibre.melifrescosg9w31.dtos.response.ResponseMessageDTO;
import com.mercadolibre.melifrescosg9w31.entity.Batch;
import com.mercadolibre.melifrescosg9w31.entity.Product;
import com.mercadolibre.melifrescosg9w31.entity.Sector;
import com.mercadolibre.melifrescosg9w31.entity.Warehouse;
import com.mercadolibre.melifrescosg9w31.exceptions.AlreadyExistsException;
import com.mercadolibre.melifrescosg9w31.exceptions.BadRequestException;
import com.mercadolibre.melifrescosg9w31.exceptions.NotFoundException;
import com.mercadolibre.melifrescosg9w31.repository.IBatchRepository;
import com.mercadolibre.melifrescosg9w31.repository.IProductRepository;
import com.mercadolibre.melifrescosg9w31.repository.ISectorRepository;
import com.mercadolibre.melifrescosg9w31.repository.IWarehouseRepository;
import com.mercadolibre.melifrescosg9w31.service.ProductService;
import com.mercadolibre.melifrescosg9w31.utils.CustomFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    private IBatchRepository batchRepository;
    @Mock
    private IProductRepository productRepository;
    @Mock
    private IWarehouseRepository warehouseRepository;
    @Mock
    private ISectorRepository sectorRepository;
    @InjectMocks
    private ProductService productService;

    private static final Long ID = 1L;
    private static final Long NOT_FOUND_ID = 999999L;
    private static final String ORDER_BATCH_NUMBER = "L";
    private static final String ORDER_QUANTITY = "C";
    private static final String ORDER_DUE_DATE = "F";
    private static final String ORDER_INVALID = "invalid";
    private static final String ORDER_NULL = null;


    @Test
    @DisplayName("Batch list by product id")
    public void testBatchListByProductId() {
        List<Batch> batchListParam = CustomFactory.createBatchesUnordered();

        when(batchRepository.findBatchByProductId(ID)).thenReturn(batchListParam);

        ProductBatchDTO expectedProductBatchList = CustomFactory.productBatchUnordered();
        ProductBatchDTO productBatchList = productService.searchBatchListByProductId(ID, ORDER_NULL);

        assertEquals(expectedProductBatchList, productBatchList);
    }

    @Test
    @DisplayName("Batch list ordered by batch number")
    public void testBatchListOrderByBatchNumber() {
        List<Batch> batchListOrderByNumberParam = CustomFactory.createBatchesOrderedByBatchNumber();

        when(batchRepository.findBatchByProductIdOrderByBatchNumber(ID)).thenReturn(batchListOrderByNumberParam);

        ProductBatchDTO expectedList = CustomFactory.productBatchOrderedByNumber();
        ProductBatchDTO batchList = productService.searchBatchListByProductId(ID, ORDER_BATCH_NUMBER);

        assertEquals(expectedList, batchList);
    }

    @Test
    @DisplayName("Batch list ordered by batch quantity")
    public void testBatchListOrderByQuantity() {
        List<Batch> batchListOrderByQuantity = CustomFactory.createBatchesOrderedByActualQuantity();

        when(batchRepository.findBatchByProductIdOrderByActualQuantity(ID)).thenReturn(batchListOrderByQuantity);

        ProductBatchDTO expectedList = CustomFactory.productBatchOrderedByQuantity();
        ProductBatchDTO batchList = productService.searchBatchListByProductId(ID, ORDER_QUANTITY);

        assertEquals(expectedList, batchList);
    }

    @Test
    @DisplayName("Batch list ordered by due date")
    public void testBatchListOrderByDueDate() {
        List<Batch> batchListOrderByDueDate = CustomFactory.createBatchesOrderedByDueDate();

        when(batchRepository.findBatchByProductIdOrderByDueDate(ID)).thenReturn(batchListOrderByDueDate);

        ProductBatchDTO expectedList = CustomFactory.productBatchOrderedByDueDate();
        ProductBatchDTO batchList = productService.searchBatchListByProductId(ID, ORDER_DUE_DATE);

        assertEquals(expectedList, batchList);
    }

    @Test
    @DisplayName("Batch list by product not found")
    public void testBatchListByProductIdNotFound() {
        when(batchRepository.findBatchByProductId(NOT_FOUND_ID)).thenReturn(List.of());
        assertThrows(NotFoundException.class,
                () -> productService.searchBatchListByProductId(NOT_FOUND_ID, ORDER_NULL));
    }

    @Test
    @DisplayName("Batch list ordered by invalid order")
    public void testBatchListOrderByOInvalidOrder() {
        assertThrows(BadRequestException.class,
                () -> productService.searchBatchListByProductId(ID, ORDER_INVALID));
    }

    @Test
    @DisplayName("Get product stock by warehouse not found")
    public void testGetProductStockByWarehouseNotFound(){
        //Arrange
        when (warehouseRepository.findById(ID)).thenReturn(Optional.empty());

        //Act + Assert
        Exception exception = assertThrows(NotFoundException.class, () -> productService.getProductStockByWarehouse(ID, null));
        assertEquals("Warehouse with id 1 not found.", exception.getMessage());
    }

    @Test
    @DisplayName("Add product in warehouse")
    public void testAddProduct() {
        ProductRequestDTO requestDto = CustomFactory.createProductRequestDTO();
        Product expectedProduct = CustomFactory.createProductFromRequestDTO(requestDto);
        ResponseMessageDTO expectedResponse = new ResponseMessageDTO("Product added successfully.");

        when(productRepository.save(ArgumentMatchers.any()))
                .thenReturn(expectedProduct);

        ResponseMessageDTO actualResponse = productService.addProductInWarehouse(requestDto);

        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    @DisplayName("Cannot add a product with existing name")
    public void testAddProductThrowsIfNameExists() {
        ProductRequestDTO requestDto = CustomFactory.createProductRequestDTO();
        requestDto.setName("Test Product 1");

        Product existingProduct = new Product();
        existingProduct.setId(1L);
        existingProduct.setName("Test Product 1");

        when(productRepository.findByName("Test Product 1"))
                .thenReturn(Optional.of(existingProduct));

        assertThrows(AlreadyExistsException.class, () ->
                productService.addProductInWarehouse(requestDto)
        );
    }


    @Test
    @DisplayName("Get product stock by warehouse with max filter")
    public void testGetProductStockByWarehouseWithMaxFilter(){
        Integer maxStock = 50;
        Warehouse warehouse = CustomFactory.createTestWarehouse();
        List<Sector> sectors = CustomFactory.createTestSectors();
        List<Batch> batches = CustomFactory.createBatchesWithDifferentStock();

        when(warehouseRepository.findById(ID)).thenReturn(Optional.of(warehouse));
        when(sectorRepository.findByWarehouseId(ID)).thenReturn(sectors);
        when(batchRepository.findBySectorIds(List.of(1L))).thenReturn(batches);

        ProductStockResponseDTO result = productService.getProductStockByWarehouse(ID, maxStock);

        assertEquals(101, result.getWarehouseCode());
        assertEquals(2, result.getProductInfo().size());
        assertEquals(20, result.getProductInfo().get(0).getCurrentStock());
        assertEquals(30, result.getProductInfo().get(1).getCurrentStock());
    }

}
