package com.mercadolibre.groupfive.socialmeli.service;

import org.springframework.stereotype.Service;

import com.mercadolibre.groupfive.socialmeli.model.Product;
import com.mercadolibre.groupfive.socialmeli.repository.IProductRepository;

@Service
public class ProductServiceImpl implements IProductService {

    private final IProductRepository productRepository;

    public ProductServiceImpl(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

}
