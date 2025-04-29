package com.mercadolibre.be_java_hisp_w31_g02.dto;

import com.mercadolibre.be_java_hisp_w31_g02.entity.Product;


public final class ProductMapper {

    public static Product toEntity(ProductDto productDto) {
        if (productDto == null) {
            return null;
        }
        Product product = new Product();
        product.setProductId(productDto.getProduct_id());
        product.setProductName(productDto.getProduct_name());
        product.setType(productDto.getType());
        product.setBrand(productDto.getBrand());
        product.setColor(productDto.getColor());
        product.setNotes(productDto.getNotes());
        return product;
    }

    public static ProductDto toDto(Product product) {
        if (product == null) {
            return null;
        }
        ProductDto productDto = new ProductDto();
        productDto.setProduct_id(product.getProductId());
        productDto.setProduct_name(product.getProductName());
        productDto.setType(product.getType());
        productDto.setBrand(product.getBrand());
        productDto.setColor(product.getColor());
        productDto.setNotes(product.getNotes());
        return productDto;
    }

}
