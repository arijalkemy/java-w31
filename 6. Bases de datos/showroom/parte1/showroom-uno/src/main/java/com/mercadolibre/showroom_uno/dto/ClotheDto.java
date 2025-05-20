package com.mercadolibre.showroom_uno.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ClotheDto {
    private Long id;
    private String nombre;
    private String tipo;
    private String marca;
    private String color;
    private String talle;
    private Integer cantidad;
    private Double precioVenta;
}
