package com.mercadolibre.be_java_hisp_w31_g02.entity;

import java.time.LocalDate;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data

public class Publication {
    private Integer postId;
    private LocalDate publishDate;
    private Integer category;
    private Double price;
    private Product product;
    private List<Promotion> promotionList;

    public Publication() {
        this.promotionList = new ArrayList<>();
    }
    public Publication(Integer postId, LocalDate publishDate, Integer category, Double price, Product product) {
        this.postId = postId;
        this.publishDate = publishDate;
        this.category = category;
        this.price = price;
        this.product = product;
        this.promotionList = new ArrayList<>();
    }
}