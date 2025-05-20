package com.bootcamp.productos.domain;

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
@Document(indexName = "producto")
public class Producto {
     @Id
     private String id;

     private String nombre;
     private String tipo;
     private Double precioVenta;
     private Double precioCosto;
     private Integer stock;
}
