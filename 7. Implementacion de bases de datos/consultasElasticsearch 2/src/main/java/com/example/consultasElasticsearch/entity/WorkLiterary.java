package com.example.consultasElasticsearch.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "obras-literarias")
@Getter
@Setter
@Data
public class WorkLiterary {

    @Id
    private String id;
    private String nombre;
    private String autor;
    private int cantidadPaginas;
    private String editorial;
    private int anioPrimeraPublicacion;
}