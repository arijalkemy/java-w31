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
    private int post_id;
    private int user_id;
    private LocalDate date;
    private Product product;
    private int category;
    private double price;
    private boolean hasPromo;
    private double discount;
}
