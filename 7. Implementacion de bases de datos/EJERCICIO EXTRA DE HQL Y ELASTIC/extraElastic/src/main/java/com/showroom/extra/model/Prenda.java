package com.showroom.extra.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.annotation.Id;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "prendas")
public class Prenda {
    @Id
    private String codigo;
    private String nombre, tipo, marca,color,talle;
    private Integer cantidad;
    private Double precioVenta;
    private List<Venta> ventas;
}
