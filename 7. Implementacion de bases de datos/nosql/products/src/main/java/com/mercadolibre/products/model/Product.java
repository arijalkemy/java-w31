package com.mercadolibre.products.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "products")
@Getter @Setter
public class Product {

    @Id
    private Integer id;
    private String name;
    private String type;
    private Double costPrice;
    private Double salePrice;
    private Integer stock;
}
