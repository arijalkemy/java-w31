package com.mercadolibre.melifrescosg9w31.unit.service;

import com.mercadolibre.melifrescosg9w31.dtos.ProductDTO;
import com.mercadolibre.melifrescosg9w31.entity.Product;
import com.mercadolibre.melifrescosg9w31.entity.ProductType;
import com.mercadolibre.melifrescosg9w31.entity.Seller;
import com.mercadolibre.melifrescosg9w31.exceptions.NotFoundException;
import com.mercadolibre.melifrescosg9w31.repository.IProductRepository;
import com.mercadolibre.melifrescosg9w31.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class ServiceProductTest {
    @Mock
    private IProductRepository productRepository;

    @InjectMocks
    private ProductService productService;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    //Req 2 Endpoint 1
    @Test
    void getAllProducts_returnsProductDTOList() {
        //arrange
        ProductType type = new ProductType(1L, "FS", "Frescos", BigDecimal.ZERO, BigDecimal.TEN);
        Seller seller = new Seller(1L, "Juan", null);
        Product product = new Product(1L, "Manteca", "Desc", BigDecimal.valueOf(100), type, seller, Collections.emptyList());

        when(productRepository.findAll()).thenReturn(List.of(product));

        //act
        List<ProductDTO> result = productService.getAllProducts();

        //assert
        assertEquals(1, result.size());
        ProductDTO dto = result.get(0);
        assertEquals(product.getId(), dto.getId());
        assertEquals(product.getName(), dto.getName());
        assertEquals(product.getDescription(), dto.getDescription());
        assertEquals(product.getPrice(), dto.getPrice());
        assertEquals(type.getName(), dto.getProductType());
        assertEquals(seller.getName(), dto.getSellerName());
    }

    @Test
    void getAllProducts_emptyList() {
        // Arrange
        when(productRepository.findAll()).thenReturn(Collections.emptyList());

        // Act
        List<ProductDTO> result = productService.getAllProducts();

        // Assert
        assertTrue(result.isEmpty());
    }


    //Req 2 Endpoint 2
    @Test
    void getProductsByCategory_returnsProductDTOList() {
        // Arrange
        String category = "FS";
        ProductType type = new ProductType(1L, category, "Frescos", BigDecimal.ZERO, BigDecimal.TEN);
        Seller seller = new Seller(1L, "Juan", null);
        Product product = new Product(1L, "Manteca", "Desc", BigDecimal.valueOf(100), type, seller, Collections.emptyList());

        when(productRepository.findByProductTypeCategory(category)).thenReturn(List.of(product));

        // Act
        List<ProductDTO> result = productService.getProductsByCategory(category);

        // Assert
        assertEquals(1, result.size());
        ProductDTO dto = result.get(0);
        assertEquals(product.getId(), dto.getId());
        assertEquals(product.getName(), dto.getName());
        assertEquals(product.getDescription(), dto.getDescription());
        assertEquals(product.getPrice(), dto.getPrice());
        assertEquals(type.getName(), dto.getProductType());
        assertEquals(seller.getName(), dto.getSellerName());
    }

    @Test
    void getProductsByCategory_notFound_throwsException() {
        // Arrange
        String category = "FS";
        when(productRepository.findByProductTypeCategory(category)).thenReturn(Collections.emptyList());

        // Act & Assert
        assertThrows(NotFoundException.class, () -> {
            productService.getProductsByCategory(category);
        });
    }
}

