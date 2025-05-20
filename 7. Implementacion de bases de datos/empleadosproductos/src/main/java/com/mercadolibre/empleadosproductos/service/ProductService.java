package com.mercadolibre.empleadosproductos.service;

import com.mercadolibre.empleadosproductos.dto.ProductDTO;
import com.mercadolibre.empleadosproductos.model.Product;
import com.mercadolibre.empleadosproductos.repository.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final IProductRepository productRepository;

    public Product createProduct(ProductDTO dto) {
        Product product = Product.builder()
                .id(UUID.randomUUID().toString())
                .name(dto.getName())
                .type(dto.getType())
                .salePrice(dto.getSalePrice())
                .costPrice(dto.getCostPrice())
                .stock(dto.getStock())
                .build();
        return productRepository.save(product);
    }

    public Optional<Product> updateProduct(String id, ProductDTO dto) {
        return productRepository.findById(id).map(existing -> {
            existing.setName(dto.getName());
            existing.setType(dto.getType());
            existing.setSalePrice(dto.getSalePrice());
            existing.setCostPrice(dto.getCostPrice());
            existing.setStock(dto.getStock());
            return productRepository.save(existing);
        });
    }
}

