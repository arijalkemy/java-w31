package com.example.elastic.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.Data;

@Document(indexName = "blog")
@Data
public class Articulo {
    @Id
    private String id;

    private String titulo;
    
    private Integer anio;
}
