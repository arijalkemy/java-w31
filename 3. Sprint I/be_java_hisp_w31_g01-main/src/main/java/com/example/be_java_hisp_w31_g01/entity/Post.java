package com.example.be_java_hisp_w31_g01.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private Integer postId;
    private Integer userId;
    private LocalDate date;
    private Product product;
    private Integer category;
    private Double price;
    private Boolean hasPromo;
    private Double discount;
}
