package com.example.obrasliterariaselastic.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "books")
@Data
public class Book {

    @Id
    private String id;

    private String title;
    @Field(type = FieldType.Nested, includeInParent = true)

    private Author author;
    private Integer pagesAmount;
    private String editorial;
    private Integer year;
}
