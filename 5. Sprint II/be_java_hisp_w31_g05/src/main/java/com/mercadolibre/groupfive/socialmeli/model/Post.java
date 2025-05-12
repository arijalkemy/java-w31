package com.mercadolibre.groupfive.socialmeli.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @JsonProperty("user_id")
    private Integer userId;
    private Integer postId;
    @JsonProperty("date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate publishDate;
    private Product product;
    private Integer category;   
    private Double price;
    private Boolean hasPromo;
    private Double discount;

    public Post(Integer userId, Integer postId, LocalDate publishDate, Product product, int category, double price) {
        this.userId = userId;
        this.postId = postId;
        this.publishDate = publishDate;
        this.product = product;
        this.category = category;
        this.price = price;
        this.hasPromo = false;
        this.discount = 0.0;
    }
}
