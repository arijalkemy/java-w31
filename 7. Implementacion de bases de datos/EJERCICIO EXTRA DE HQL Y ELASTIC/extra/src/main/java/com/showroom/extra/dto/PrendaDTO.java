package com.showroom.extra.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrendaDTO {
    private String nombre, tipo, marca,color,talle;
    private Integer cantidad;
    private Double precioVenta;
}
