package com.mercadolibre.products.service;

import com.mercadolibre.products.model.Product;
import com.mercadolibre.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public String editProduct(Product product) {
        productRepository.save(product);
        return "Product edited successfully";
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
