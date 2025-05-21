package com.bootcamp.obrasliterarias.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(indexName = "obra_literaria")
public class ObraLiteraria {
     @Id
     private String id;

     private String nombre;
     private String autor;
     private Integer cantidadDePaginas;
     private String editorial;
     private Integer anioPublicacion;
}