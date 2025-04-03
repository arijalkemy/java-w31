package com.mercadolibre.modulojava.ejerciciointegrador;

public class Item {
    private String codigo;
    private String nombre;
    private Integer cantidad;
    private Double precio;

    public Item(String codigo, String nombre, Integer cantidad, Double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

}
