package com.bootcamp.productos_nosql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName="producto")
public class Producto {
    @Id
    private String id;
    @Field(type = FieldType.Text)
    private String nombre;
    @Field(type = FieldType.Text)
    private String tipo;
    @Field(type = FieldType.Double)
    private double precioVenta;
    @Field(type = FieldType.Double)
    private double precioCosto;
    @Field(type = FieldType.Integer)
    private int cantidadDisponible;
}
