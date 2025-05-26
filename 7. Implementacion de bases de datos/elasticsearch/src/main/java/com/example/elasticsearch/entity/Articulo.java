package com.example.elasticsearch.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "blog")
public class Articulo {
    @Id
    private String id;
    private String titulo;
    private Integer anio;
}
