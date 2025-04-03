package com.mercadolibre.model;

public class Producto {
    private TipoProducto tipo;
    private Double precio;

    public Producto(TipoProducto tipo, Double precio) {
        this.tipo = tipo;
        this.precio = precio;
    }

    public TipoProducto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProducto tipo) {
        this.tipo = tipo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
