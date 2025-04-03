package com.company;

public class Item {
    private Integer codigo, cantidadCompra;
    private String nombre;
    private Double precio;

    public Item(Integer codigo, Integer cantidadCompra, String nombre, Double precio) {
        this.codigo = codigo;
        this.cantidadCompra = cantidadCompra;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCantidadCompra() {
        return cantidadCompra;
    }

    public void setCantidadCompra(Integer cantidadCompra) {
        this.cantidadCompra = cantidadCompra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Item{" +
                "codigo=" + codigo +
                ", cantidadCompra=" + cantidadCompra +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}
