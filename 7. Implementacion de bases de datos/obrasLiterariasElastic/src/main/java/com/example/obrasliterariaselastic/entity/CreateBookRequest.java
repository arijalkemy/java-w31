package com.example.obrasliterariaselastic.entity;

import lombok.Data;

@Data
public class CreateBookRequest {
    private String title;
    private String author;
    private Integer year;
    private Integer pagesAmount;
    private String editorial;
}