package com.mercadolibre.melifrescosg9w31.unit.service;

import com.mercadolibre.melifrescosg9w31.dtos.ProductWarehouseDTO;
import com.mercadolibre.melifrescosg9w31.exceptions.NotFoundException;
import com.mercadolibre.melifrescosg9w31.repository.IBatchRepository;
import com.mercadolibre.melifrescosg9w31.service.ProductService;
import com.mercadolibre.melifrescosg9w31.utils.CustomFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private IBatchRepository batchRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    void testSearchWarehouseListProductByIdHappyPath() {
        //Arrange
        Long idProduct = 1L;
        ProductWarehouseDTO productWarehouseDTO = CustomFactory.createProductWarehouseDTO();
        when(batchRepository.findTotalQuantityInWarehouseByProductId(idProduct)).thenReturn(productWarehouseDTO.getWarehouses());

        //Act
        ProductWarehouseDTO result = productService.searchWarehouseListProductById(idProduct);

        //Assert
        assertEquals(productWarehouseDTO, result);
    }

    @Test
    void testSearchWarehouseListProductByIdNotFound() {
        //Arrange
        Long idProduct = 1L;
        when(batchRepository.findTotalQuantityInWarehouseByProductId(idProduct)).thenReturn(new ArrayList<>());

        //Act + Assert
        Exception exception = assertThrows(NotFoundException.class, () -> productService.searchWarehouseListProductById(idProduct));
        assertEquals("Product with id 1 not found or has no warehouses.", exception.getMessage());
    }

}