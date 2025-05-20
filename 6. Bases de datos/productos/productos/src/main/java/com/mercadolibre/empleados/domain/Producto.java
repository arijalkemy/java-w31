package com.mercadolibre.empleados.domain;

import com.mercadolibre.empleados.utils.TipoProducto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "product")
public class Producto {
    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String nombre;

    @Field(type = FieldType.Keyword)
    private TipoProducto tipo;

    @Field(type = FieldType.Double)
    private Double precioDeVenta;

    @Field(type = FieldType.Double)
    private Double precioDeCosto;

    @Field(type = FieldType.Integer)
    private Integer cantidadDisponible;
}
